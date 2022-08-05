package com.example.view;

import com.example.bussnius.ExamBusiness;
import com.example.dal.dto.Ansdto;
import com.example.dal.dto.CorrctAnsdto;
import com.example.dal.dto.Quesdto;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.blue;
import static java.awt.Color.gray;
import static java.awt.Color.green;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

public class Exam extends JFrame implements Runnable {

    private JLabel labelQuistion, l;
    private JRadioButton[] radios;
    private JButton nextBtn, resultBtn, show, start;
    private ButtonGroup btnGroup;
    private int count = 0, current = 0;
    private JLabel timeLabel;

    public Exam() throws IOException {
        initcom();

        setQuesOnPotions();

    }

    public void initcom() {
        timeLabel = new JLabel("01:00");
        add(timeLabel);
        labelQuistion = new JLabel();
        add(labelQuistion);
        btnGroup = new ButtonGroup();
        radios = new JRadioButton[5];
        for (int i = 0; i < 5; i++) {
            radios[i] = new JRadioButton();
            add(radios[i]);
            btnGroup.add(radios[i]);
        }
        start = new JButton("Start");
        nextBtn = new JButton("Next");
        resultBtn = new JButton("Result");
        show = new JButton("Show");
        add(nextBtn);
        add(resultBtn);
        add(show);
        labelQuistion.setBounds(30, 40, 450, 30);
        labelQuistion.setBounds(30, 40, 450, 30);
        radios[0].setBounds(45, 70, 300, 30);
        radios[1].setBounds(45, 100, 300, 30);
        radios[2].setBounds(45, 130, 300, 30);
        radios[3].setBounds(45, 160, 300, 30);
        nextBtn.setBounds(50, 200, 80, 50);
        start.setBounds(50, 200, 80, 50);
        timeLabel.setBounds(300, 100, 250, 100);
        timeLabel.setForeground(blue);
        timeLabel.setFont(new Font("bold", Font.BOLD, 24));
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nextbtnActionPerformed(e);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        resultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    resbtnActionPerformed(e);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showbtnActionPerformed(e);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        resultBtn.setBounds(230, 200, 80, 50);
        show.setBounds(400, 200, 80, 50);
        resultBtn.setVisible(true);
        setLayout(null);
        setSize(600, 300);
        setTitle("Exam");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        resultBtn.setVisible(false);
    }
    ExamBusiness eb = new ExamBusiness();

    ArrayList<CorrctAnsdto> c = eb.checkResult();

    private void setQuiz(int i, JLabel label, JRadioButton[] rad, ArrayList<Quesdto> qes, ArrayList<Ansdto> ans) {
        label.setText("Q" + " " + qes.get(i));
        rad[0].setText(ans.get(i).getFirst());
        rad[1].setText(ans.get(i).getSecond());
        rad[2].setText(ans.get(i).getThird());
        rad[3].setText(ans.get(i).getFourth());

    }

    private void setQuesOnPotions() throws IOException {
        for (int i = 0; i < 5; i++) {
            radios[i].setEnabled(true);

        }
        ArrayList<Quesdto> qes = eb.setQues();
        ArrayList<Ansdto> ans = eb.setAnswer();
        ArrayList<CorrctAnsdto> c = eb.checkResult();
        radios[4].setSelected(true);
        switch (current) {
            case 0:
                setQuiz(current, labelQuistion, radios, qes, ans);
                break;
            case 1:
                setQuiz(current, labelQuistion, radios, qes, ans);
                break;
            case 2:
                setQuiz(current, labelQuistion, radios, qes, ans);
                break;
            case 3:
                setQuiz(current, labelQuistion, radios, qes, ans);
                break;
            case 4:
                setQuiz(current, labelQuistion, radios, qes, ans);
                break;
            case 5:
                setQuiz(current, labelQuistion, radios, qes, ans);
                break;
            case 6:
                setQuiz(current, labelQuistion, radios, qes, ans);
                break;
            case 7:
                setQuiz(current, labelQuistion, radios, qes, ans);
                break;
            case 8:
                setQuiz(current, labelQuistion, radios, qes, ans);
                break;
            case 9:
                setQuiz(current, labelQuistion, radios, qes, ans);
                break;

        }
    }

    private boolean checkTrue() {
        if (current == 0) {
            return ExamBusiness.getSelectedButtonText(btnGroup).equals(c.get(0));
        }
        if (current == 1) {
            return ExamBusiness.getSelectedButtonText(btnGroup).equals(c.get(1));
        }
        if (current == 2) {
            return ExamBusiness.getSelectedButtonText(btnGroup).equals(c.get(2));
        }
        if (current == 3) {
            return ExamBusiness.getSelectedButtonText(btnGroup).equals(c.get(3));
        }
        if (current == 4) {
            return ExamBusiness.getSelectedButtonText(btnGroup).equals(c.get(4));
        }
        if (current == 5) {
            return ExamBusiness.getSelectedButtonText(btnGroup).equals(c.get(5));
        }
        if (current == 6) {
            return ExamBusiness.getSelectedButtonText(btnGroup).equals(c.get(6));
        }
        if (current == 7) {
            return ExamBusiness.getSelectedButtonText(btnGroup).equals(c.get(7));
        }
        if (current == 8) {
            return ExamBusiness.getSelectedButtonText(btnGroup).equals(c.get(8));
        }
        if (current == 9) {
            return ExamBusiness.getSelectedButtonText(btnGroup).equals(c.get(0));
        }

        return false;
    }

    private void setColorAsDefult() {
        for (int i = 0; i < 5; i++) {
            radios[i].setForeground(black);

        }
    }

    private void nextbtnActionPerformed(ActionEvent evt) throws UnknownHostException, IOException {

        setColorAsDefult();
//        if (checkTrue()) {
//            count++;
//        }
        for (int i = 0; i < 5; i++) {
            radios[i].setEnabled(true);
        }
        current++;
        setQuesOnPotions();
        if (current == 9) {
            nextBtn.setEnabled(false);
            resultBtn.setVisible(true);
        }
    }

    private void resbtnActionPerformed(ActionEvent evt) throws UnknownHostException, IOException {
        if (checkTrue()) {
            count++;
        }
        JOptionPane.showMessageDialog(null, "Correct Answers : " + count + "\n" + "Wrong Answer : " + (10 - count));

    }

    private void showbtnActionPerformed(ActionEvent evt) throws UnknownHostException, IOException {
        color();
        CorrctAnsdto[] a = new CorrctAnsdto[10];

        if (current == 9) {
            for (int i = 0; i < 10; i++) {
                a[i] = (c.get(i));

            }
            JOptionPane.showMessageDialog(null, "Correct Answers :\n --------- \n " + a[0] + "\n"
                    + a[1] + "\n"
                    + a[2] + "\n"
                    + a[3] + "\n"
                    + a[4] + "\n"
                    + a[5] + "\n"
                    + a[6] + "\n"
                    + a[7] + "\n"
                    + a[8] + "\n"
                    + a[9] + "\n"
                    + "---------");
        }
    }

    private void selsectdColor(JRadioButton[] rb, int correctAns, int wrong1, int wrong2, int wrong3) {
        if (rb[correctAns].isSelected()) {
            rb[correctAns].setForeground(green);
            seTEnableFalse(rb, wrong1, wrong2, wrong3);

        } else if (rb[wrong1].isSelected()) {
            rb[wrong1].setForeground(red);
            seTEnableFalse(rb, correctAns, wrong2, wrong3);
        } else if (rb[wrong2].isSelected()) {
            rb[wrong2].setForeground(red);
            seTEnableFalse(rb, correctAns, wrong1, wrong3);
        } else if (rb[wrong3].isSelected()) {
            rb[wrong3].setForeground(red);
            seTEnableFalse(rb, correctAns, wrong2, wrong1);
        }

    }

    private void seTEnableFalse(JRadioButton[] rb, int wrong1, int wrong2, int wrong3) {

        radios[wrong1].setEnabled(false);
        radios[wrong2].setEnabled(false);
        radios[wrong3].setEnabled(false);
    }

    private void color() throws IOException {

        if (current == 0) {
            selsectdColor(radios, 0, 1, 2, 3);
        }

        if (current == 1) {
            selsectdColor(radios, 3, 1, 2, 0);

        }
        if (current == 2) {
            selsectdColor(radios, 2, 1, 0, 3);

        }
        if (current == 3) {
            selsectdColor(radios, 2, 1, 0, 3);

        }
        if (current == 4) {
            selsectdColor(radios, 0, 1, 2, 3);

        }
        if (current == 5) {
            selsectdColor(radios, 1, 0, 2, 3);

        }
        if (current == 6) {
            selsectdColor(radios, 2, 1, 0, 3);

        }
        if (current == 7) {
            selsectdColor(radios, 3, 1, 2, 0);

        }
        if (current == 8) {
            selsectdColor(radios, 2, 1, 0, 3);

        }
        if (current == 9) {
            selsectdColor(radios, 0, 1, 2, 3);

        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 59; i >= 0; i--) {
            timeLabel.setText("00" + ":" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Exam().setVisible(true);
        Thread t = new Thread(new Exam());                     

        t.start();

    }
}
