
package com.example.bussnius;

import com.example.dal.dao.AnswersDao;
import com.example.dal.dao.CorrectAnswersDao;
import com.example.dal.dao.QuestionsDao;
import com.example.dal.dto.Ansdto;
import com.example.dal.dto.CorrctAnsdto;
import com.example.dal.dto.Quesdto;
import com.example.view.Exam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class ExamBusiness {

    public ExamBusiness() {
    }

    QuestionsDao qesDao = new QuestionsDao();
    AnswersDao ansDao = new AnswersDao();
    CorrectAnswersDao correctDao = new CorrectAnswersDao();

    public ArrayList setQues() throws IOException {
        ArrayList<Quesdto> qes = qesDao.read();
        return qes;
    }

    public ArrayList setAnswer() throws IOException {
        ArrayList<Ansdto> ans = ansDao.read();
        return ans;
    }

    public ArrayList checkResult() throws IOException {
        ArrayList<CorrctAnsdto> correctAns = correctDao.read();
        for (CorrctAnsdto correctAn : correctAns) {
            
        }
        return correctAns;
    }

    public static String getSelectedButtonText(ButtonGroup btnGroup) {
        for (Enumeration buttons = btnGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = (AbstractButton) buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {

    }

}
