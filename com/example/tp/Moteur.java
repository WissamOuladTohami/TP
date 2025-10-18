package com.example.tp;

public class Moteur {
	
	 private String type;
	    private int puissance; 

	    public Moteur(String type, int puissance) {
	        this.type = type;
	        this.puissance = puissance;
	    }

	    @Override
	    public String toString() {
	        return type + " " + puissance + "ch";
	    }

}
