
package com.example.view;

import static java.awt.Color.blue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public  class Start extends JFrame{
        public Start() throws IOException {
        JFrame f = new JFrame("Exam");
        f.setLayout(new FlowLayout());
        JButton b = new JButton("Start");
        JLabel l = new JLabel("Are you Already want to Start Exam ?");

        l.setBounds(70, 100, 250, 20);
        f.add(b);
        f.add(l);
        f.setSize(400, 400);
        f.setVisible(true);
        Exam t = new Exam();
        f.setLayout(null);
        b.setBounds(150, 200, 95, 30);
        l.setBounds(30, 100, 350, 20);
        l.setForeground(blue);
        l.setFont(new Font("Arial", Font.BOLD, 18));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    new Exam().setVisible(true);
                    new Exam();
                } catch (IOException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                }
                f.setVisible(false);
            }
        });

    }
        public static void main(String[] args) throws IOException {
        new Start();
    }
}
