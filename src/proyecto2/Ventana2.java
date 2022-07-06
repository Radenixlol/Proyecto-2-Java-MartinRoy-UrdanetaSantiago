/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Roy Martin
 */
public class Ventana2 {
     /**
     * @param text
     * @author: Roy Martin
     * @deprecated: Crea una ventana que muestra la información del artículo
     * solicitada
     *
     */
    public void initcomponents2(String text) {
        JPanel Panel = new JPanel();
        Panel.setBorder(new TitledBorder(new EtchedBorder(), "Artículo"));
        Font arial=new Font("Arial",0,12);
        JTextArea TextArea = new JTextArea(45, 120);
        TextArea.setEditable(false);
        TextArea.setWrapStyleWord(true);
        TextArea.setLineWrap(true);
        TextArea.setFont(arial);
        TextArea.setBorder(BorderFactory.createCompoundBorder(TextArea.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        TextArea.append(text);
        JScrollPane scroll = new JScrollPane(TextArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Panel.add(scroll);
        JFrame frame = new JFrame();
        frame.add(Panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(2);
        frame.setVisible(true);
    }
}
