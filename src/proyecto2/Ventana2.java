/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

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
 * @author Radenixlol
 */
public class Ventana2 {

//    public static void main(String[] args) {
//        Ventana2 ventana = new Ventana2();
//        String text = "";
//        ventana.initcomponents2(text);
//    }
    
    public void initcomponents2(String text) {
        JPanel Panel = new JPanel();
        Panel.setBorder(new TitledBorder(new EtchedBorder(), "Artículo"));

        // create the middle panel components
        JTextArea TextArea = new JTextArea(45, 120);
        TextArea.setEditable(false);
        TextArea.setWrapStyleWord(true);
        TextArea.setLineWrap(true);
        TextArea.setBorder(BorderFactory.createCompoundBorder(TextArea.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        text = "aqaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaahhhhaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        TextArea.append(text);
        JScrollPane scroll = new JScrollPane(TextArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Add Textarea in to middle panel
        Panel.add(scroll);

        // My code
        JFrame frame = new JFrame();
        frame.add(Panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(2);
        frame.setVisible(true);
    }
}
