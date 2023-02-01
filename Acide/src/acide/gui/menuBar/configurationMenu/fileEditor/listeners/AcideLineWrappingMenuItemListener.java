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
package acide.gui.menuBar.configurationMenu.fileEditor.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

import acide.configuration.workbench.AcideWorkbenchConfiguration;
import acide.gui.mainWindow.AcideMainWindow;
import acide.log.AcideLog;

/**
 * ACIDE - A Configurable IDE file editor panel popup menu line wrapping check
 * box menu item action listener.
 * 
 * @version 0.11
 * @see ActionListener
 */
public class AcideLineWrappingMenuItemListener implements ActionListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		action(actionEvent);
	}
	
	public static void action(ActionEvent actionEvent){
		

		// Updates the ACIDE - A Configurable IDE workbench configuration
		AcideWorkbenchConfiguration
				.getInstance()
				.getFileEditorConfiguration()
				.setLineWrapping(
						AcideMainWindow.getInstance().getMenu()
								.getConfigurationMenu().getFileEditorMenu()
								.getLineWrappingCheckBoxMenuItem().isSelected());
		
//		boolean lineWrapping = AcideWorkbenchConfiguration.getInstance()
//				.getConsolePanelConfiguration()
//				.getLineWrapping();
//		
//		AcideWorkbenchConfiguration
//				.getInstance()
//				.getConsolePanelConfiguration()
//				.setLineWrapping(!lineWrapping);
//		
//		AcideMainWindow.getInstance().getMenu()
//			.getConfigurationMenu().getConsoleMenu()
//			.getConsoleLineWrappingCheckBoxMenuItem().setSelected(!lineWrapping);
//		
//		AcideMainWindow.getInstance().getConsolePanel().getPopupMenu()
//			.getLineWrappingMenuItem().setSelected(!lineWrapping);
		
		try {

			for (int index = 0; index < AcideMainWindow.getInstance()
					.getFileEditorManager().getNumberOfFileEditorPanels(); index++) {
				
				// Provokes the changes in the document to apply the changes
				AcideMainWindow.getInstance().getFileEditorManager()
						.getSelectedFileEditorPanel()
						.getActiveTextEditionArea().getDocument()
						.insertString(0, "", new SimpleAttributeSet());
			}
			
		} catch (BadLocationException exception) {
			
			// Updates the log
			AcideLog.getLog().error(exception.getMessage());
			exception.printStackTrace();
		}
	}
}
