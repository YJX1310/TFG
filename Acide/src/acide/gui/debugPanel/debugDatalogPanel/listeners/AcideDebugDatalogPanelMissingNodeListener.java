/*
 * ACIDE - A Configurable IDE
 * Official web site: http://acide.sourceforge.net
 *
 * Copyright (C) 2007-2013
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
package acide.gui.debugPanel.debugDatalogPanel.listeners;

import acide.gui.debugPanel.debugDatalogPanel.AcideDebugDatalogDebugWindow;
import acide.gui.debugPanel.utils.AcideDebugHelper;
import acide.gui.mainWindow.AcideMainWindow;
import acide.language.AcideLanguageManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * ACIDE - A Configurable IDE debug datalog panel missing node listener.
 *
 * @version 0.19
 * @see ActionListener
 *
 */
public class AcideDebugDatalogPanelMissingNodeListener implements ActionListener{

    /*
     * (non-Javadoc)
     *
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(AcideDebugDatalogDebugWindow.getInstance().isVisible())
            AcideDebugDatalogDebugWindow.getInstance().setAlwaysOnTop(false);

        String predicate = AcideMainWindow.getInstance().getDebugPanel().getDebugDatalogPanel()
                .getCanvas().getSelectedNode().getLabel();

        String userInput = AcideDebugHelper.getUserInputDatalogTuple(predicate, "missing");

        if(!userInput.isEmpty()){
            if(!AcideDebugHelper.isDatalogSessionDebugging() || AcideDebugHelper.isRootPredicate(predicate))
                AcideDebugDatalogDebugWindow.getInstance().resetErrors();
            AcideDebugDatalogDebugWindow.getInstance().addError(predicate.split("/")[0],
                    AcideLanguageManager.getInstance().getLabels().getString("s2350") +
                            " (" + userInput + ") " + AcideLanguageManager.getInstance().getLabels()
                            .getString("s2412") +" "+ predicate.split("/")[0]);
            String action = "missing("+predicate.split("/")[0]+"("+userInput+"))";
            if(AcideDebugHelper.isDatalogSessionDebugging() && !AcideDebugHelper.isRootPredicate(predicate))
                AcideDebugHelper.performPredicateNodeDebug(predicate, action);
            else{
                AcideMainWindow.getInstance().getDebugPanel().getDebugDatalogPanel().setDebugging(true);
                AcideDebugHelper.startPredicateNodeDebug(predicate,action);
            }
        }
        if(AcideDebugDatalogDebugWindow.getInstance().isVisible())
            AcideDebugDatalogDebugWindow.getInstance().setAlwaysOnTop(true);
    }
}
