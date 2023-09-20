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
import acide.files.AcideFileExtensionFilterManager;
import acide.files.AcideFileManager;
import acide.files.bytes.AcideByteFileManager;
import acide.files.utils.AcideFileOperation;
import acide.files.utils.AcideFileTarget;
import acide.files.utils.AcideFileType;
import acide.gui.fileEditor.fileEditorPanel.fileEditorTextEditionArea.utils.AcideHighlightError;
import acide.gui.mainWindow.AcideMainWindow;
import acide.language.AcideLanguageManager;
import acide.process.parser.AcideGrammarAnalyzer;
import acide.process.parser.AcideGrammarFileCreationProcess;

/**
 * ACIDE - A Configurable IDE load grammar menu item listener.
 * 
 * @version 0.19
 * @see ActionListener
 */
public class AcideLoadGrammarMenuItemListener implements ActionListener {
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
		// Asks the the file to the user
		String absolutePath = AcideFileManager.getInstance().askForFile(
				AcideFileOperation.OPEN,
				AcideFileTarget.FILES,
				AcideFileType.FILE,
				"./configuration/grammars/",
				new AcideFileExtensionFilterManager(new String[] { ".txt" },
						AcideLanguageManager.getInstance().getLabels()
								.getString("s270")));
		
		// If the path is not null
		if(absolutePath != null) {
			// Process the file grammar
			AcideByteFileManager.getInstance().processGrammarFile(absolutePath);
			
			AcideGrammarFileCreationProcess process = new AcideGrammarFileCreationProcess(
					absolutePath, false, AcideLanguageManager.getInstance().getLabels()
					.getString("s35"), true);
			
			process.setLock(AcideLanguageManager.getInstance().getLabels().getString("s2438"));
			
			// Starts the process
			process.start();
			
			// Clear all the errors highlights
			AcideHighlightError.getInstance().clearErrorHighlight();
		}
	}
}
