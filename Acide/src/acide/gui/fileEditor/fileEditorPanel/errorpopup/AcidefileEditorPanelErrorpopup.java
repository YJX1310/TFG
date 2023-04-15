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
	 private JLabel textError = new JLabel("");
	 
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
		panel.add(textError); // Agregar la etiqueta de texto
		mainPanel.add(panel, BorderLayout.LINE_START);
		mainPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		add(mainPanel);
		setResizable(false); // Desactivar la opción de pantalla completa
		setUndecorated(true);

	}
	public static AcidefileEditorPanelErrorpopup getInstance() {
		
		if (_instance == null)
			_instance = new AcidefileEditorPanelErrorpopup();
		return _instance;
	}
	
	public void SetErrorLabel(String a) {
		textError.setText(a);
	}
	
}
