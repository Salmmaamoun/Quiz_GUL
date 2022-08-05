package com.example.dal.dto;

import java.util.Objects;

public class Quesdto {

    private String list;
    private String question;

    public Quesdto(String list, String question) {
        this.question = question;
        this.list = list;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.question);
        hash = 47 * hash + Objects.hashCode(this.list);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Quesdto other = (Quesdto) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.list, other.list)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return list + "," + question;
    }

}
