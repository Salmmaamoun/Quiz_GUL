
package com.example.dal.dto;

import java.util.Objects;


public class Ansdto {
    private String first;
    private String second;
    private String third;
    private String fourth;

    public Ansdto(String first, String second, String third, String fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.first);
        hash = 79 * hash + Objects.hashCode(this.second);
        hash = 79 * hash + Objects.hashCode(this.third);
        hash = 79 * hash + Objects.hashCode(this.fourth);
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
        final Ansdto other = (Ansdto) obj;
        if (!Objects.equals(this.first, other.first)) {
            return false;
        }
        if (!Objects.equals(this.second, other.second)) {
            return false;
        }
        if (!Objects.equals(this.third, other.third)) {
            return false;
        }
        if (!Objects.equals(this.fourth, other.fourth)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return first + "," + second + "," + third + "," + fourth ;
    }
    
}
