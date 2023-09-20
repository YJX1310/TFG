/*
 * ACIDE - A Configurable IDE
 * Official web site: http://acide.sourceforge.net
 *
 * Copyright (C) 2007-2023
 * Authors:
 * 		- Fernando S�enz P�rez (Team Director).
 *      - Version from 0.1 to 0.6:
 *      	- Diego Cardiel Freire.
 *			- Juan Jos� Ortiz S�nchez.
 *          - Delf�n Rup�rez Ca�as.
 *      - Version 0.7:
 *          - Miguel Mart�n L�zaro.
 *      - Version 0.8:
 *      	- Javier Salcedo G�mez.
 *      - Version from 0.9 to 0.11:
 *      	- Pablo Guti�rrez Garc�a-Pardo.
 *      	- Elena Tejeiro P�rez de �greda.
 *      	- Andr�s Vicente del Cura.
 *      - Version from 0.12 to 0.16
 *      	- Sem�ramis Guti�rrez Quintana
 *      	- Juan Jes�s Marqu�s Ortiz
 *      	- Fernando Ord�s Lorente
 *      - Version 0.17
 *      	- Sergio Dom�nguez Fuentes
 * 		- Version 0.18
 * 			- Sergio Garc�a Rodr�guez
 * 		- Version 0.19
 * 			- Carlos Gonz�lez Torres
 * 			- Cristina Lara L�pez
 * 			- Yuejie Xu
 * 			- Yihang Zhuo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package acide.gui.debugPanel.traceDatalogPanel.listeners;

import acide.gui.debugPanel.debugCanvas.tasks.AcideDebugCanvasParseTask;
import acide.gui.debugPanel.debugDatalogPanel.AcideDebugDatalogPanel;
import acide.gui.debugPanel.utils.AcideDebugHelper;
import acide.gui.graphCanvas.tasks.AcideGraphCanvasParseTask;
import acide.gui.graphUtils.DirectedWeightedGraph;
import acide.gui.mainWindow.AcideMainWindow;
import acide.process.console.DesDatabaseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 *
 * ACIDE - A Configurable IDE debug datalog panel show predicate listener
 *
 * @version 0.19
 * @see ActionListener
 */
public class AcideTraceDatalogPanelViewBoxListener implements ActionListener{
    /*
     * (non-Javadoc)
     *
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        JComboBox cb=(JComboBox) e.getSource();

        if(cb.getSelectedIndex()<1)
            return;

        String query=cb.getSelectedItem().toString();

        if(query!=null) {

            int arity = Integer.parseInt(query.substring(query.lastIndexOf("/") + 1));

            // Builds the query
            query = query.substring(0, query.lastIndexOf("/")) + "(";

            for (int i = 0; i < arity; i++) {
                query += "X" + i;
                if (i + 1 < arity)
                    query += ",";
            }

            query += ")";

            final String queryText=query;

            AcideMainWindow.getInstance().getDebugPanel()
                    .getTraceDatalogPanel().setQuery(queryText);

            // Gets the result of the /tapi /trace_datalog command
            LinkedList<String> l = DesDatabaseManager.getInstance()
                    .executeCommand("/tapi /trace_datalog "+queryText);

            String result = "";
            for(String s:l){
                result+=s+"\n";
            }

            // Parses the result and generates the path graph
            AcideDebugCanvasParseTask pathParseTask=new AcideDebugCanvasParseTask(result,
                    AcideGraphCanvasParseTask.PARSE_TAPI_PDG, AcideMainWindow.getInstance()
                    .getDebugPanel().getTraceDatalogPanel().getCanvas(),
                    AcideDebugCanvasParseTask.DESTINY_PATH,queryText,true);

            final Thread t = new Thread(pathParseTask);
            t.start();

            new Thread(new Runnable() {
                /*
                 * (non-Javadoc)
                 *
                 * @see java.lang.Runnable#run()
                 */
                @Override
                public void run() {
                    try {
                        // Enable the refresh button
                        AcideMainWindow.getInstance().getDebugPanel().getTraceDatalogPanel()
                                .refreshDatalog.setEnabled(true);

                        t.join();

                        if (pathParseTask.isSuccess()) {

                            // Enable the refresh button
                            AcideMainWindow.getInstance().getDebugPanel().getTraceDatalogPanel()
                                    .refreshDatalog.setEnabled(true);

                            // Getes the result of the /tapi /pdg command
                            LinkedList<String> l = DesDatabaseManager.getInstance()
                                    .executeCommand("/tapi /pdg " + queryText.substring(0,
                                            queryText.lastIndexOf("(")));

                            String result = "";
                            for (String s : l) {
                                result += s + "\n";
                            }

                            // Parses the result and generates the graph
                            new Thread(new AcideDebugCanvasParseTask(result, AcideGraphCanvasParseTask.PARSE_TAPI_PDG,
                                    AcideMainWindow.getInstance().getDebugPanel().getTraceDatalogPanel().getCanvas(),
                                    AcideDebugCanvasParseTask.DESTINY_MAIN, queryText, true)).start();
                        } else
                            AcideMainWindow.getInstance().getDebugPanel().getTraceDatalogPanel().getCanvas()
                                    .set_graph(new DirectedWeightedGraph());

                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }).start();

            // Checks if the show rule property is active
            if(AcideMainWindow.getInstance().getDebugPanel().getTraceDatalogPanel()
                    .getShowRulesMenuItem().isSelected()){

                new Thread(new Runnable() {
                    /*
                     * (non-Javadoc)
                     *
                     * @see java.lang.Runnable#run()
                     */
                    @Override
                    public void run() {
                        try{
                            t.join();

                            if(pathParseTask.isSuccess()){
                                AcideDebugDatalogPanel._refreshDatalog.setEnabled(true);

                                // Gets the root node of the canvas
                                String selected=AcideMainWindow.getInstance().getDebugPanel()
                                        .getTraceDatalogPanel().getCanvas().getRootNode().getLabel();

                                // Unhighlight the previous highlights
                                AcideMainWindow.getInstance().getDebugPanel().getTraceDatalogPanel()
                                        .getHighLighter().unHighLight();

                                // Highlights the root node
                                AcideMainWindow.getInstance().getDebugPanel().getTraceDatalogPanel()
                                        .getHighLighter().highLight(selected);

                                AcideDebugHelper.getRoot(selected);
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
        SwingUtilities.invokeLater(() -> {
            cb.setEnabled(false);
            cb.setEnabled(true);
        });
    }
}
