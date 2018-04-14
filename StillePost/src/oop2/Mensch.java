package oop2;

import java.util.Random;

public class Mensch {
	//Attribute
	private String name;
	private int opinion;
	private int x,y;
	
	//Meinungen: 0 = unentschlossen, 1 = heiraten, 2 = heiraten nicht
	public Mensch(int x, int y) {
		this.opinion = 0;
		this.x = x;
		this.y = y;
						
	}
	
	public Mensch(String name, int opinion, int x, int y) {
		this.name = name;
		this.opinion = opinion;
		this.x = x;
		this.y = y;
		
	}
}
