package com.example.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Login extends JFrame {

    JLabel userLabel, passwordLabel, result, forgetPass, forgetEmail;
    JTextField userNameText;
    JPasswordField passwordText;
    JButton submit, creatAccount;
    JCheckBox showPass;

    Login() {
        userLabel = new JLabel();
        userLabel.setText("User Name :");
        userNameText = new JTextField();
        passwordLabel = new JLabel();
        passwordLabel.setText("Password :");
        passwordText = new JPasswordField();
        forgetPass = new JLabel();
        forgetEmail = new JLabel();
        passwordLabel.setFont(new Font("bold", Font.PLAIN, 18));
        userLabel.setFont(new Font("bold", Font.PLAIN, 18));
        setLayout(new BorderLayout());
        submit = new JButton("SUBMIT");
        creatAccount = new JButton("Creat Account");
        showPass = new JCheckBox("Show Passwords");
        submit.setFont(new Font("bold", Font.PLAIN, 16));
        creatAccount.setFont(new Font("bold", Font.PLAIN, 18));

        showPass.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (showPass.isSelected()) {
                    passwordText.setEchoChar('\0');
                } else {
                    passwordText.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
                }
            }
        });
        userLabel.setBounds(70, 25, 150, 110);
        forgetEmail.setBounds(250, 60, 170, 110);
        passwordLabel.setBounds(70, 118, 150, 110);
        userNameText.setBounds(250, 60, 200, 40);
        passwordText.setBounds(250, 150, 200, 40);
        submit.setBounds(240, 300, 100, 50);
        showPass.setBounds(250, 190, 200, 40);
        creatAccount.setBounds(200, 440, 190, 50);
        forgetPass.setBounds(250, 180, 200, 40);
        forgetPass.setForeground(Color.red);
        forgetEmail.setForeground(Color.red);
        creatAccount.setBackground(Color.green);
        creatAccount.setForeground(Color.WHITE);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.blue);

        add(userLabel, (BorderLayout.CENTER));
        add(userNameText, (BorderLayout.CENTER));
        add(passwordLabel, (BorderLayout.CENTER));
        add(passwordText, (BorderLayout.CENTER));
        add(showPass, (BorderLayout.CENTER));
        add(forgetEmail);
        result = new JLabel();
        result.setBounds(200, 360, 200, 50);
        result.setForeground(Color.RED);

        add(result, (BorderLayout.CENTER));
        add(submit, (BorderLayout.CENTER));
        add(creatAccount, (BorderLayout.CENTER));
        add(forgetPass, (BorderLayout.CENTER));
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    subbtnActionPerformed(e);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        creatAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    creatbtnActionPerformed(e);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

//        setLayout(new BorderLayout(BorderLayout.CENTER));
        setTitle("Please Login Here !");
        setSize(600, 600);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        new Login();
//    }
    private void subbtnActionPerformed(ActionEvent evt) throws UnknownHostException, IOException {
        String userName = userNameText.getText();
        String password = new String(passwordText.getPassword());
        if (userName.trim().equals("salma123") && password.equals("nour")) {
            new Start().pack();
            dispose();
        } else {
            forgetPass.setText("!! Are You Forget The Password ? ...");
            forgetEmail.setText("!! Are You Forget The Email ? ...");

            result.setText("InValid,Please, Try Again....");
        }

    }

    private void creatbtnActionPerformed(ActionEvent evt) throws UnknownHostException, IOException {
        String userName = userNameText.getText();
        char[] password = passwordText.getPassword();
        if (!(userName.equals("salma123") && password.equals("nour"))) {
            new CreatAccount().setVisible(true);
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Login();
    }

}
