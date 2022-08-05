
package com.example.dal.dao;

import com.example.dal.dto.CorrctAnsdto;
import com.example.dal.dto.Quesdto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CorrectAnswersDao {
    
    private ArrayList correct = new ArrayList();

    public ArrayList read() throws FileNotFoundException, IOException, ArrayIndexOutOfBoundsException {

        File f = new File("corrctanswer1.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
          
            String correctAns = line+"\n";
            CorrctAnsdto s = new  CorrctAnsdto(correctAns);
            correct.add(s);
        }
        return correct;
    }
}
