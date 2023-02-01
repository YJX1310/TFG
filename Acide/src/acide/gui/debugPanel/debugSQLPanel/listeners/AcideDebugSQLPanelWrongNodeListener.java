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
package acide.gui.debugPanel.debugSQLPanel.listeners;

import acide.gui.debugPanel.debugCanvas.AcideDebugCanvas;
import acide.gui.debugPanel.debugSQLPanel.AcideDebugSQLDebugWindow;
import acide.gui.debugPanel.utils.AcideDebugHelper;
import acide.gui.mainWindow.AcideMainWindow;
import acide.language.AcideLanguageManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AcideDebugSQLPanelWrongNodeListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(AcideDebugSQLDebugWindow.getInstance().isVisible())
                AcideDebugSQLDebugWindow.getInstance().setAlwaysOnTop(false);

            // Gets the canvas
            AcideDebugCanvas canvas = AcideMainWindow.getInstance()
                    .getDebugPanel().getDebugSQLPanel().getCanvas();
            String view = canvas.getSelectedNode().getLabel().split("/")[0];
            String userInput = AcideDebugHelper.getUserInputSQLTuple(view, "wrong");
            if(!userInput.isEmpty()) {
                if (!AcideDebugHelper.isSQLSessionDebugging() || AcideDebugHelper.isRootView(view))
                    AcideDebugSQLDebugWindow.getInstance().resetErrors();
                AcideDebugSQLDebugWindow.getInstance().addError(view,AcideLanguageManager.getInstance()
                        .getLabels().getString("s2361") + " " + view + " " +
                        AcideLanguageManager.getInstance()
                                .getLabels().getString("s2362") + " (" + userInput + ")");
                String action = "wrong(" + view + "(" + userInput +"))";
                if (AcideDebugHelper.isSQLSessionDebugging() && !AcideDebugHelper.isRootView(view)) {
                    AcideDebugHelper.performViewNodeDebug(view, action);
                } else {
                    AcideMainWindow.getInstance().getDebugPanel().getDebugSQLPanel().setDebugging(true);
                    AcideDebugHelper.startViewNodeDebug(view, action);
                }
            }
            if(AcideDebugSQLDebugWindow.getInstance().isVisible())
                AcideDebugSQLDebugWindow.getInstance().setAlwaysOnTop(true);
        } catch (Exception ex) {
            System.out.println(ex);
            AcideMainWindow.getInstance().getDebugPanel()
                    .setCursor(Cursor.getDefaultCursor());
        }
    }
}