package com.example.dal.dao;

import com.example.dal.dto.Quesdto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionsDao {

    private ArrayList qes = new ArrayList();

    public ArrayList read() throws FileNotFoundException, IOException, ArrayIndexOutOfBoundsException {

        File f = new File("qestion.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] spl;
        while ((line = br.readLine()) != null) {
            spl = line.split(",");
            String list = spl[0];
            String question = spl[1];
            Quesdto s = new Quesdto(list, question);
            qes.add(s);
        }
        return qes;
    }

}
