package acide.gui.fileEditor.fileEditorPanel.fileEditorTextEditionArea.listeners;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;
import acide.gui.fileEditor.fileEditorPanel.AcideFileEditorPanel;
import acide.gui.fileEditor.fileEditorPanel.errorpopup.AcidefileEditorPanelErrorpopup;
import acide.gui.mainWindow.AcideMainWindow;

public class AcideFileEditorMouseMotionListener implements MouseMotionListener {

    private Timer timer = null;
    private Point lastMousePosition;
    private AcideFileEditorPanel selectedFileEditorPanelIndex = AcideMainWindow.getInstance().getFileEditorManager()
            .getSelectedFileEditorPanel();
    
    public AcideFileEditorMouseMotionListener() {
        timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostrar el mensaje después de que el temporizador haya transcurrido un segundo

                Point punto = lastMousePosition;
                int offset = selectedFileEditorPanelIndex.getActiveTextEditionArea().viewToModel(punto);
                int linea = 0;
                int columna = 0;

                try {
                    Element root = selectedFileEditorPanelIndex.getActiveTextEditionArea().getDocument()
                        .getDefaultRootElement();
                    int inicioLinea = Utilities.getRowStart(selectedFileEditorPanelIndex.getActiveTextEditionArea(), offset);
                    int indiceElemento = root.getElementIndex(inicioLinea);
                    linea = indiceElemento + 1;
                    columna = offset - inicioLinea + 1;

                    StyledDocument doc = (StyledDocument) selectedFileEditorPanelIndex.getActiveTextEditionArea().getDocument();
                    Element palabra = doc.getCharacterElement(offset);
                    int inicioPalabra = palabra.getStartOffset();
                    int inicioLineaPalabra = Utilities.getRowStart(selectedFileEditorPanelIndex.getActiveTextEditionArea(),
                        inicioPalabra);
                    int columnaInicioPalabra = inicioPalabra - inicioLineaPalabra + 1;
                    
                    // Mostrar un cuadro de diálogo con la información relevante

                    selectedFileEditorPanelIndex.getErrorPopup().SetErrorLabel("Línea: " + linea + "\nColumna: " + columna + "\nComienzo de la palabra: Línea " + linea + ", Columna " + columnaInicioPalabra);     
                    selectedFileEditorPanelIndex.getErrorPopup().setVisible(true);
                    selectedFileEditorPanelIndex.getErrorPopup().pack();
                   

                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        });
        timer.setRepeats(false);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    	
        Point currentMousePosition = mouseEvent.getPoint();
        if (lastMousePosition == null) {
            lastMousePosition = currentMousePosition;
        } else if (!lastMousePosition.equals(currentMousePosition)) {
            // Si el ratón se ha movido, reinicia el temporizador
        	selectedFileEditorPanelIndex.getErrorPopup().setVisible(false);
        	selectedFileEditorPanelIndex.getErrorPopup().setLocation(mouseEvent.getLocationOnScreen());
        	lastMousePosition = currentMousePosition;
            timer.restart();
            
        }
    }

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
