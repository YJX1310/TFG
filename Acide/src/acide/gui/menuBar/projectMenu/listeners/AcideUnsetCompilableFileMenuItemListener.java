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
package acide.gui.menuBar.projectMenu.listeners;

import acide.configuration.project.AcideProjectConfiguration;
import acide.files.project.AcideProjectFile;
import acide.gui.mainWindow.AcideMainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 * ACIDE -A Configurable IDE project menu unset compilable menu item listener.
 * 
 * @version 0.11
 * @see ActionListener
 */
public class AcideUnsetCompilableFileMenuItemListener implements ActionListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
	 * )
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		action(actionEvent);
	}
	
	public static void action(ActionEvent actionEvent){
		// Gets the selection in the explorer tree
		TreePath currentSelection = AcideMainWindow.getInstance().getExplorerPanel()
				.getTree().getSelectionPath();

		// Current node
		DefaultMutableTreeNode currentNode;

		// Current project file
		AcideProjectFile currentProjectFile;

		// If something is selected
		if (currentSelection != null) {

			// Gets the selected node in the explorer
			currentNode = (DefaultMutableTreeNode) currentSelection
					.getLastPathComponent();

			// Gets the current project file from the current node info
			currentProjectFile = (AcideProjectFile) currentNode.getUserObject();

			// If is COMPILABLE and not MAIN FILE
			if (currentProjectFile.isCompilableFile()
					&& !currentProjectFile.isMainFile()) {

				// If it is a file and not a directory
				if (!currentProjectFile.isDirectory()) {

					// The file is not COMPILABLE FILE
					currentProjectFile.setIsCompilableFile(false);

					// The project has been modified
					AcideProjectConfiguration.getInstance().setIsModified(true);

					// Updates the file editor
					for (int index = 0; index < AcideMainWindow.getInstance()
							.getFileEditorManager()
							.getNumberOfFileEditorPanels(); index++) {
						if (AcideMainWindow.getInstance().getFileEditorManager()
								.getFileEditorPanelAt(index).getAbsolutePath()
								.equals(currentProjectFile.getAbsolutePath())) {

							// Updates the file editor configuration
							AcideMainWindow.getInstance().getFileEditorManager()
									.getFileEditorPanelAt(index)
									.setCompilableFile(false);
							AcideMainWindow.getInstance().getFileEditorManager()
									.getFileEditorPanelAt(index)
									.setMainFile(false);

							// Updates the file editor panel image icon
							AcideMainWindow.getInstance().getFileEditorManager()
									.getFileEditorPanelAt(index).setIcon(null);

							// Removes the COMPILABLE icon from the selected file editor panel
							AcideMainWindow.getInstance().getFileEditorManager()
									.getTabbedPane().setIconAt(index, null);

							// Updates the status message in the status bar
							AcideMainWindow
									.getInstance()
									.getStatusBar()
									.setStatusMessage(
											AcideMainWindow
													.getInstance()
													.getFileEditorManager()
													.getFileEditorPanelAt(index)
													.getAbsolutePath());
						}
					}
				}
			}
		}
	}
}
