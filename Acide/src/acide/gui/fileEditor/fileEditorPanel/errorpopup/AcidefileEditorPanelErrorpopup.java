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
package acide.gui.fileEditor.fileEditorPanel.errorpopup;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowFocusListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import acide.language.AcideLanguageManager;




public class AcidefileEditorPanelErrorpopup extends JFrame{
	//Atributos de la clase
	 private static AcidefileEditorPanelErrorpopup _instance;
	 private JLabel _textError = new JLabel("");
	 
	public AcidefileEditorPanelErrorpopup() { //Constructor con parametro;
		initGUI();
	}

	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		ImageIcon erroricon = new ImageIcon("resources/icons/menu/project/deleteFile.png");
		JLabel etiqueta = new JLabel(erroricon);
		mainPanel.add(etiqueta,BorderLayout.LINE_START);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(etiqueta); // Agregar el icono
		panel.add(Box.createRigidArea(new Dimension(10,0))); // Agregar un espacio en blanco para separar los componentes
		panel.add(_textError); // Agregar la etiqueta de texto
		mainPanel.add(panel, BorderLayout.LINE_START);
		mainPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		add(mainPanel);
		setResizable(false); // Desactivar la opci�n de pantalla completa
		setUndecorated(true);

	}
	public static AcidefileEditorPanelErrorpopup getInstance() {
		
		if (_instance == null)
			_instance = new AcidefileEditorPanelErrorpopup();
		return _instance;
	}
	
	public void SetErrorLabel(String a) {
		_textError.setText(a);
	}
	
}
