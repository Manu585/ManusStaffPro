package me.manu.manusstaffpro.hierarchy;

public class Hierarchy {
    private String rank;
    private int power;

    public Hierarchy(String rank, int power) {
        this.rank = rank;
        this.power = power;
    }

    public String getRank() {
        return this.rank;
    }

    public int getPower() {
        return this.power;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
