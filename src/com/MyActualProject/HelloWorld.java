package com.MyActualProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloWorld {
    private JPanel rootPanel;
    private JLabel helloLabel;
    private JButton helloButton;
    private JTextField nameTextField;
    private JTextField textEmailField;
    private JTextField textPhone;
    private JLabel phoneLabel;
    private JLabel conFirmData;
    private JLabel inValid;

    public HelloWorld() {
        helloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String name = nameTextField.getText();
                String email = textEmailField.getText();
                String phone = textPhone.getText();

                try {
                    if (name.equals("") || email.equals("") || phone.equals(""))
                        throw new IllegalArgumentException("Cannot insert data!");
                    int intPhone = Integer.parseInt(phone);
                    var dbCOnnection = new DBConnection();
                    dbCOnnection.insertDB(name, email, intPhone);
                    //conFirmData.setText("Data has been inserted!");

                } catch (Exception cc) {
                    inValid.setText("Cannot insert Data as fields are empty!");

                }


            }



        });
    }

    public void helloWorld(){
        JFrame frame = new JFrame("Enter Details");
        frame.setContentPane(new HelloWorld().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
