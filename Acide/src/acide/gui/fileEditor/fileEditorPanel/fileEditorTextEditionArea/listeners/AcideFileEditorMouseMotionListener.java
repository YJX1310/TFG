/*
 * ACIDE - A Configurable IDE
 * Official web site: http://acide.sourceforge.net
 *
 * Copyright (C) 2007-2013
 * Authors:
 * 		- Fernando Sáenz Pérez (Team Director).
 *      - Version from 0.1 to 0.6:
 *      	- Diego Cardiel Freire.
 *			- Juan José Ortiz Sánchez.
 *          - Delfín Rupérez Cañas.
 *      - Version 0.7:
 *          - Miguel Martín Lázaro.
 *      - Version 0.8:
 *      	- Javier Salcedo Gómez.
 *      - Version from 0.9 to 0.11:
 *      	- Pablo Gutiérrez García-Pardo.
 *      	- Elena Tejeiro Pérez de Ágreda.
 *      	- Andrés Vicente del Cura.
 *      - Version from 0.12 to 0.16
 *      	- Semíramis Gutiérrez Quintana
 *      	- Juan Jesús Marqués Ortiz
 *      	- Fernando Ordás Lorente
 *      - Version 0.17
 *      	- Sergio Domínguez Fuentes
 * 		- Version 0.18
 * 			- Sergio García Rodríguez
 * 		- Version 0.19
 * 			- Carlos González Torres
 * 			- Cristina Lara López
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
package acide.gui.fileEditor.fileEditorPanel.fileEditorTextEditionArea.listeners;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Utilities;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;

import acide.configuration.lexicon.AcideLexiconConfiguration;
import acide.configuration.lexicon.delimiters.AcideLexiconDelimitersManager;
import acide.gui.fileEditor.fileEditorPanel.AcideFileEditorPanel;
import acide.gui.fileEditor.fileEditorPanel.errorpopup.AcidefileEditorPanelErrorpopup;
import acide.gui.mainWindow.AcideMainWindow;
import acide.process.parser.AcideGrammarAnalyzer;
/**
 * ACIDE - A Configurable IDE file editor text edition area mouse motion listener
 * 
 * @version 0.19
 * @see MouseMotionListener
 */
public class AcideFileEditorMouseMotionListener implements MouseMotionListener {
	
	/**
	 * ACIDE - A Configurable IDE timer.
	 */
    private Timer _timer = null;
	/**
	 * ACIDE - A Configurable IDE last mouse position.
	 */
    private Point _lastMousePosition;
   
    public AcideFileEditorMouseMotionListener() {
    	_timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AcideFileEditorPanel selectedFileEditorPanelIndex = AcideMainWindow.getInstance().getFileEditorManager()
                        .getSelectedFileEditorPanel();
                // Mostrar el mensaje después de que el temporizador haya transcurrido un segundo

                Point punto = _lastMousePosition;
                int offset = selectedFileEditorPanelIndex.getActiveTextEditionArea().viewToModel(punto);
                String text=selectedFileEditorPanelIndex.getActiveTextEditionArea().getText();
                int line = selectedFileEditorPanelIndex.getActiveTextEditionArea().getDocument().getDefaultRootElement().getElementIndex(offset) + 1;
                int wordStart = offset;

                AcideLexiconConfiguration lexiconConfiguration = AcideMainWindow.getInstance()
						.getFileEditorManager()
						.getSelectedFileEditorPanel().getLexiconConfiguration();
                AcideLexiconDelimitersManager delimiters =  lexiconConfiguration.getDelimitersManager();
                
                Set<String> listadedelimitadores = new HashSet<String>();

                 for(int i = 0; i < delimiters.getSize(); i++) {
                	 String delimiter =delimiters.getDelimiterAt(i);
                     if(!listadedelimitadores.contains(delimiter)) {
                    	 listadedelimitadores.add(delimiter);
                    	 }
                     }
                 Character xddd=text.charAt(wordStart - 1);
                 boolean contiene=delimiters.getList().getList().contains(text.charAt(wordStart - 1));
                if(!delimiters.getList().getList().contains(text.charAt(wordStart))&&wordStart>0) {
                    while (!delimiters.getList().getList().contains(text.charAt(wordStart-1))) {
                        wordStart--;
                    }
                }
                int column = wordStart - selectedFileEditorPanelIndex.getActiveTextEditionArea().getDocument().getDefaultRootElement().getElement(line - 1).getStartOffset() + 1;
                String word = text.substring(wordStart, offset);
                String posicion=line + ":" + (column-1);
                System.out.println(posicion);
                HashMap<String,String> a=selectedFileEditorPanelIndex.getGrammarAnalyzer().getErrors();
                if(selectedFileEditorPanelIndex.getGrammarAnalyzer().getErrors().containsKey(posicion)) {
                    selectedFileEditorPanelIndex.getErrorPopup().SetErrorLabel(selectedFileEditorPanelIndex.getGrammarAnalyzer().getErrors().get(posicion));     
                    selectedFileEditorPanelIndex.getErrorPopup().setVisible(true);
                    selectedFileEditorPanelIndex.getErrorPopup().pack();
                }
                
                /*try {
                    Element root = selectedFileEditorPanelIndex.getActiveTextEditionArea().getDocument()
                        .getDefaultRootElement();
                    int inicioLinea = Utilities.getRowStart(selectedFileEditorPanelIndex.getActiveTextEditionArea(), offset);
                    int indiceElemento = root.getElementIndex(inicioLinea);
                    linea = indiceElemento +1;
                    columna = offset - inicioLinea;

                    Document doc = selectedFileEditorPanelIndex.getActiveTextEditionArea().getDocument();
                    Element palabra = ((StyledDocument) doc).getCharacterElement(offset);
                    
                    int inicioPalabra = palabra.getStartOffset();
                    Element parrafo = ((StyledDocument) doc).getParagraphElement(inicioPalabra);
                    int inicioParrafo = parrafo.getStartOffset();
                    int inicioPalabraMod = inicioPalabra;
                    for (int i = inicioPalabra - 1; i >= inicioParrafo; i--) {
                        if (doc.getText(i, 1).matches("\\s")) { // Comprobamos si el carácter es un espacio en blanco o un carácter de control.
                            inicioPalabraMod = i + 1;
                            break;
                        }
                    }

                    int inicioLineaPalabra = Utilities.getRowStart(selectedFileEditorPanelIndex.getActiveTextEditionArea(),
                            inicioPalabraMod);
                    int columnaInicioPalabra = inicioPalabraMod - inicioLineaPalabra;
                    
                    // Mostrar un cuadro de diálogo con la información relevante
                    String posicion=(linea) + ":" + columnaInicioPalabra;
                    System.out.println((linea+1)+":"+columna);
                    System.out.println(posicion);
                    HashMap<String,String> a=selectedFileEditorPanelIndex.getGrammarAnalyzer().getErrors();
                    if(selectedFileEditorPanelIndex.getGrammarAnalyzer().getErrors().containsKey(posicion)) {
                        selectedFileEditorPanelIndex.getErrorPopup().SetErrorLabel(selectedFileEditorPanelIndex.getGrammarAnalyzer().getErrors().get(posicion));     
                        selectedFileEditorPanelIndex.getErrorPopup().setVisible(true);
                        selectedFileEditorPanelIndex.getErrorPopup().pack();
                    }
             

                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }*/
            }
        });
    	_timer.setRepeats(false);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    	AcideFileEditorPanel selectedFileEditorPanelIndex = AcideMainWindow.getInstance().getFileEditorManager()
                .getSelectedFileEditorPanel();
        Point currentMousePosition = mouseEvent.getPoint();
        if (_lastMousePosition == null) {
        	_lastMousePosition = currentMousePosition;
        } else if (!_lastMousePosition.equals(currentMousePosition)) {
            // Si el ratón se ha movido, reinicia el temporizador
        	selectedFileEditorPanelIndex.getErrorPopup().setVisible(false);
        	selectedFileEditorPanelIndex.getErrorPopup().setLocation(mouseEvent.getLocationOnScreen());
        	_lastMousePosition = currentMousePosition;
        	_timer.restart();
            
        }
    }

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
