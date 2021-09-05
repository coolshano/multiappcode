package com.MyActualProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DearDiary {
    private JPanel mainPanel;
    private JComboBox comboBox;
    private JTextArea textArea;
    private JButton submitButton;



    public DearDiary() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void helloDiary(){
        JFrame frame = new JFrame("Enter Details");
        frame.setContentPane(new DearDiary().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
