package com.example.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class CreatAccount extends JFrame {

    JLabel userLabel, passwordLabel, phoneOrEmailLabel, type, date, result;
    JTextField userNameText, phoneOrEmailText;
    JPasswordField passwordText;
    JButton register;
    JCheckBox showPass;
    JRadioButton female, male;
    JComboBox day, mon, year;

    public CreatAccount() {

        userLabel = new JLabel();
        userLabel.setText("User Name :");
        userNameText = new JTextField();
        passwordLabel = new JLabel();
        passwordLabel.setText("Password :");
        passwordText = new JPasswordField();
        phoneOrEmailLabel = new JLabel();
        phoneOrEmailLabel.setText("The  Phone Or Email :");
        phoneOrEmailText = new JTextField();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        type = new JLabel();
        type.setText("Gendar ? ");
        register = new JButton("Register");
        result = new JLabel();
        date = new JLabel();
        date.setText("Date :");
        showPass = new JCheckBox("Show Passwords");
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        String[] years = {"2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2001"};
        day = new JComboBox(days);
        mon = new JComboBox(months);
        year = new JComboBox(years);

        showPass.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            passwordText.setEchoChar(c.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    regbtnActionPerformed(e);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        userLabel.setBounds(70, 5, 150, 110);
        passwordLabel.setBounds(70, 80, 150, 110);
        phoneOrEmailLabel.setBounds(40, 175, 350, 110);
        userNameText.setBounds(250, 35, 200, 40);
        passwordText.setBounds(250, 100, 200, 40);
        showPass.setBounds(250, 140, 220, 40);
        phoneOrEmailText.setBounds(250, 210, 200, 40);
        type.setBounds(70, 280, 100, 30);
        female.setBounds(70, 310, 100, 30);
        male.setBounds(180, 310, 100, 30);
        date.setBounds(70, 380, 100, 30);
        day.setBounds(70, 420, 100, 30);
        mon.setBounds(180, 420, 100, 30);
        year.setBounds(290, 420, 100, 30);
        register.setBounds(180, 500, 100, 30);
        register.setBounds(180, 520, 100, 30);
        userLabel.setFont(new Font("bold", Font.PLAIN, 18));
        passwordLabel.setFont(new Font("bold", Font.PLAIN, 18));
        phoneOrEmailLabel.setFont(new Font("bold", Font.PLAIN, 18));
        type.setFont(new Font("bold", Font.PLAIN, 18));
        female.setFont(new Font("bold", Font.PLAIN, 18));
        male.setFont(new Font("bold", Font.PLAIN, 18));
        date.setFont(new Font("bold", Font.PLAIN, 18));
        register.setFont(new Font("bold", Font.PLAIN, 14));

        add(userLabel);
        add(userNameText);
        add(passwordLabel);
        add(passwordText);
        add(register);
        add(showPass);
        add(phoneOrEmailText);
        add(phoneOrEmailLabel);
        add(type);
        add(male);
        add(female);
        add(date);
        add(day);
        add(mon);
        add(year);
        add(result);
        setSize(550, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    public static void main(String[] args) {
//        new CreatAccount().setVisible(true);
//    }
    private String select() {
        if (male.isSelected()) {
            return "male";
        } else {
            return "female";
        }

    }

    void regbtnActionPerformed(ActionEvent evt) throws UnknownHostException, IOException {

        File f = new File("res.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
            String txt = (userNameText.getText() + ","
                    + new String(passwordText.getPassword()) + ","
                    + phoneOrEmailText.getText() + ","
                    + select());

            bw.write(txt);

//            Logger.getLogger(CreatAccount.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(CreatAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(CreatAccount.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(CreatAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(CreatAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }}

//         catch (IOException ex) {
//
//            Logger.getLogger(CreatAccount.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                bw.close();
//            } catch (IOException ex) {
//                Logger.getLogger(CreatAccount.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                fw.close();
//            } catch (IOException ex) {
//                Logger.getLogger(CreatAccount.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//    }

