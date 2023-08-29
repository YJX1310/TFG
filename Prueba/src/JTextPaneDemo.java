import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;
import javax.swing.text.*;

public class JTextPaneDemo extends JFrame {
    
    public JTextPaneDemo() {
        setTitle("JTextPane Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPopupMenu popup = new JPopupMenu();
        popup.add(new JMenuItem("Opción 1"));
        popup.add(new JMenuItem("Opción 2"));

        
        // Crea un JTextPane
        JTextPane textPane = new JTextPane();
        
        // Agrega texto al JTextPane
        String texto = "Este es un ejemplo de texto con estilo.";
        textPane.setText(texto);
        
        // Busca la palabra "ejemplo" en el texto
        String palabra = "ejemplo";
        int index = texto.indexOf(palabra);
        
        // Subraya la palabra "ejemplo"
        if (index >= 0) {
            StyledDocument doc = textPane.getStyledDocument();
            SimpleAttributeSet estilo = new SimpleAttributeSet();
            StyleConstants.setUnderline(estilo, true);
            StyleConstants.setForeground(estilo, Color.RED);
            StyleConstants.setItalic(estilo, true);
            doc.setCharacterAttributes(index, palabra.length(), estilo, false);
        }
        

        textPane.addMouseListener(new MouseAdapter() {
            private Timer timer;
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    // Mostrar el menú emergente en la posición del cursor
                    popup.show(textPane, e.getX(), e.getY());
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                int pos = textPane.viewToModel(e.getPoint());
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String[] palabras = { "opción", "para", "mostrar" };
                        JOptionPane.showMessageDialog(textPane, String.join(", ", palabras));
                        timer.stop();
                    }
                });
                timer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (timer != null) {
                    timer.stop();
                }
            }
        });
        // Agrega el JTextPane a la ventana
        getContentPane().add(new JScrollPane(textPane));
        pack();
        setLocationRelativeTo(null);
    }

}
