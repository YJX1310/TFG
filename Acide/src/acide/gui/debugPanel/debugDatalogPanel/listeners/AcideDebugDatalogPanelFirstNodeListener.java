package acide.gui.debugPanel.debugDatalogPanel.listeners;

import acide.gui.debugPanel.debugDatalogPanel.AcideDebugDatalogPanel;
import acide.gui.mainWindow.AcideMainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * ACIDE - A Configurable IDE debug datalog panel first node listener.
 *
 * @version 0.19
 * @see ActionListener
 *
 */
public class AcideDebugDatalogPanelFirstNodeListener implements ActionListener {

    /*
     * (non-Javadoc)
     *
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        AcideMainWindow.getInstance().getDebugPanel()
                .setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        try{

            //Updates the selected node
            int selectedNodeIndex;
            do{
                AcideDebugDatalogPanel._canvas.retardSelectedNode();
                selectedNodeIndex=AcideDebugDatalogPanel._canvas.get_pathGraphindex();
            }while(selectedNodeIndex>0);
            AcideDebugDatalogPanel._canvas.repaint();

            //Updates the highlights
            AcideMainWindow.getInstance().getDebugPanel().getDebugDatalogPanel()
                    .getHighLighter().resetLines();
            AcideMainWindow.getInstance().getDebugPanel().getDebugDatalogPanel()
                    .getHighLighter().unHighLight();
            AcideMainWindow.getInstance().getDebugPanel().getDebugDatalogPanel()
                    .getHighLighter().highLight(AcideDebugDatalogPanel._canvas
                    .getSelectedNode().getLabel());

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        AcideMainWindow.getInstance().getDebugPanel()
                .setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

    }
}
