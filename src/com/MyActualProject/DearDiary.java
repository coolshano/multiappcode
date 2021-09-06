package com.MyActualProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DearDiary {
    private JPanel mainPanel;
    private JComboBox comboBox;
    private JTextArea textArea;
    private JButton submitButton;



    public DearDiary() {
        comboBox.addItem("Good");
        comboBox.addItem("Bad");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String mood = (String) comboBox.getSelectedItem();
                String entry = textArea.getText();

                if (entry.length() > 50) {

                    long millis = System.currentTimeMillis();
                    java.sql.Date myDate = new java.sql.Date(millis);

                    var myEntry = new DBConnection();
                    myEntry.insertDB(entry, mood, myDate);

                } else
                    System.out.println("Please enter a valid statement!");

                textArea.selectAll();
                textArea.replaceSelection("");
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
