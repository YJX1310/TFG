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
package acide.gui.menuBar.configurationMenu.grammarMenu.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;

import acide.files.bytes.AcideByteFileManager;
import acide.gui.fileEditor.fileEditorPanel.AcideFileEditorPanel;
import acide.gui.fileEditor.fileEditorPanel.fileEditorTextEditionArea.utils.AcideHighlightError;
import acide.gui.mainWindow.AcideMainWindow;
import acide.language.AcideLanguageManager;
import acide.process.parser.AcideGrammarAnalyzer;
import acide.process.parser.AcideGrammarFileCreationProcess;

/**																
 * ACIDE - A Configurable IDE auto analysis check box menu item listener.										
 *					
 * @version 0.19	
 * @see ActionListener																													
 */
public class AcideIncrementalAnalysisMenuItemListener implements ActionListener{
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		action(actionEvent);
	}
	
	public static void action(ActionEvent actionEvent){
		// Gets the new value of the checkBox
		boolean selected = ((JCheckBoxMenuItem)actionEvent
				.getSource()).isSelected();

		// Clear all the errors highlights
		AcideHighlightError.getInstance().clearErrorHighlight();
		
		if(!AcideMainWindow.getInstance().getMenu().getConfigurationMenu().getGrammarMenu()
				.getAnalyzeMenu().getCompleteTextAnalysisCheckBoxMenuItem().isSelected()) {
			if(selected) {
				invokeAnalyze();
			}	
		}
		else {
			invokeAnalyze();
			
			// Set the new value of the checkBox
			AcideMainWindow.getInstance()
			.getMenu().getConfigurationMenu()
			.getGrammarMenu().getAnalyzeMenu()
			.getCompleteTextAnalysisCheckBoxMenuItem().setSelected(!selected);
		}
	}
	
	private static void invokeAnalyze() {
		// Gets the selected file editor panel
		AcideFileEditorPanel selectedFileEditorPanel = AcideMainWindow.getInstance()
				.getFileEditorManager().getSelectedFileEditorPanel();
		
		String delimiter = selectedFileEditorPanel.get_grammarDelimiter();
		if(delimiter == null || delimiter.equals("")) {
			JOptionPane.showMessageDialog(
					null,               
					AcideLanguageManager.getInstance().getLabels().getString("s2441"), 
					AcideLanguageManager.getInstance().getLabels().getString("s2040"),           
					JOptionPane.WARNING_MESSAGE 
					);
			
			// Set the new value of the checkBox
			AcideMainWindow.getInstance()
			.getMenu().getConfigurationMenu()
			.getGrammarMenu().getAnalyzeMenu()
			.getIncrementalAnalysisCheckBoxMenuItem().setSelected(false);
		}
		else {
			// Process the current grammar
			AcideByteFileManager.getInstance().processGrammarFile(selectedFileEditorPanel
					.getCurrentGrammarConfiguration().getPath());
			
			AcideGrammarFileCreationProcess fileCreationProcess = new AcideGrammarFileCreationProcess(AcideMainWindow
					.getInstance().getFileEditorManager().getSelectedFileEditorPanel()
					.getCurrentGrammarConfiguration().getPath(), false, 
					AcideLanguageManager.getInstance().getLabels().getString("s35"), false);
			
			fileCreationProcess.setLock(AcideLanguageManager.getInstance().getLabels().getString("s2438"));
			
			// Starts the process
			fileCreationProcess.start();
		}
	}
}
