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
package acide.gui.fileEditor.fileEditorPanel.fileEditorTextEditionArea.utils;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.SwingUtilities;
import javax.swing.event.CaretListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import acide.gui.fileEditor.fileEditorPanel.AcideFileEditorPanel;
import acide.gui.fileEditor.fileEditorPanel.errorpopup.AcidefileEditorPanelErrorpopup;
import acide.gui.mainWindow.AcideMainWindow;
/**
 * ACIDE - A Configurable IDE file editor text edition area error highlighter.
 * 
 * @version 0.19
 * @see AcideHighlightError
 */
public class AcideHighlightError {

	private static AcideHighlightError _instance;

	public static AcideHighlightError getInstance() {

		if (_instance == null)
			_instance = new AcideHighlightError();
		return _instance;
	}

	public void ErrorHighLight() {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				AcideFileEditorPanel selectedFileEditorPanelIndex = AcideMainWindow.getInstance().getFileEditorManager()
						.getSelectedFileEditorPanel();
				// Obtener el documento del JTextPane
				StyledDocument document = selectedFileEditorPanelIndex.getStyledDocument();
				String text = selectedFileEditorPanelIndex.getActiveTextEditionArea().getText();
				// Crear un estilo personalizado con subrayado rojo
				SimpleAttributeSet underlineStyle = new SimpleAttributeSet();
				StyleConstants.setForeground(underlineStyle, Color.RED);
				StyleConstants.setUnderline(underlineStyle, true);

				// Agregar el estilo personalizado a un nuevo estilo de car�cter
				StyleContext styleContext = StyleContext.getDefaultStyleContext();
				Style customStyle = styleContext.addStyle("custom", null);
				customStyle.addAttributes(underlineStyle);

				// Subrayar cada palabra en rojo
				for (HashMap.Entry<String, String> entry : selectedFileEditorPanelIndex.getGrammarAnalyzer().getErrors()
						.entrySet()) {
					// Obtener la l�nea y columna de inicio de la palabra
					String[] parts = entry.getKey().split(":");
					int line = Integer.parseInt(parts[0]) - 1;
					int column = Integer.parseInt(parts[1]);

					// Calcular la posici�n de inicio y fin de la palabra
					int start = document.getDefaultRootElement().getElement(line).getStartOffset() + column;
					int end = text.indexOf(" ", start);
					int newline = text.indexOf("\n", start);
					if (end == -1 || (newline != -1 && newline < end)) {
						end = newline;
					}
					if (end == -1) {
						end = text.length();
					}

					// Aplicar el estilo de subrayado rojo a la palabra
					document.setCharacterAttributes(start, end - start, customStyle, false);

				}
			}
		});
	}
}
