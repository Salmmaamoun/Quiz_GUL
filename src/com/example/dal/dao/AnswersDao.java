package com.example.dal.dao;

import com.example.dal.dto.Ansdto;
import com.example.dal.dto.Quesdto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AnswersDao {

    private ArrayList ans = new ArrayList();

    public ArrayList read() throws FileNotFoundException, IOException, ArrayIndexOutOfBoundsException {

        File f = new File("answers.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] spl;
        while ((line = br.readLine()) != null) {
            spl = line.split(",");
            String first = spl[0];
            String second = (spl[1]);
            String third = (spl[2]);
            String fourth = (spl[3]);
            Ansdto s = new Ansdto(first, second, third, fourth);
            ans.add(s);
        }
        br.close();
        return ans;
    }
}
