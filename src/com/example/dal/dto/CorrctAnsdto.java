
package com.example.dal.dto;

import java.util.Objects;


public class CorrctAnsdto {
    private String correctAns;

    public CorrctAnsdto(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final CorrctAnsdto other = (CorrctAnsdto) obj;
        if (!Objects.equals(this.correctAns, other.correctAns)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  correctAns ;
    }
    
}
