package acide.gui.mainWindow.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.Timer;

import acide.gui.fileEditor.fileEditorPanel.AcideFileEditorPanel;
import acide.gui.mainWindow.AcideMainWindow;

public class AcideMainWindowFocusListener implements WindowFocusListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event. FocusEvent)
	 */

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/*@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		AcideFileEditorPanel selectedFileEditorPanelIndex = AcideMainWindow.getInstance().getFileEditorManager()
				.getSelectedFileEditorPanel();
		Component oppositeComponent = e.getOppositeWindow();
		if (oppositeComponent==null||!selectedFileEditorPanelIndex.getErrorPopup().getClass().equals(oppositeComponent.getClass())) {
			selectedFileEditorPanelIndex.getErrorPopup().setVisible(false);
		}

	}*/
	@Override
	public void windowLostFocus(WindowEvent focusEvent) {
		// Dispatches the event
		
         Timer _timer = null;
    	_timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	AcideFileEditorPanel selectedFileEditorPanelIndex = AcideMainWindow.getInstance().getFileEditorManager()
                        .getSelectedFileEditorPanel();
                 Component oppositeComponent = focusEvent.getOppositeWindow();
                 if (oppositeComponent == null || oppositeComponent != selectedFileEditorPanelIndex.getErrorPopup()) {            
                	 selectedFileEditorPanelIndex.getErrorPopup().setVisible(false);
                 }
            }
        });
    	_timer.start();
    	_timer.setRepeats(false);
	}

}