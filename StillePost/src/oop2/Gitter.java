package oop2;

import java.util.ArrayList;


import java.util.Random;


public class Gitter {
	//Attribute
	private int width;
	private int height;

	private Feld[][] gitter;
	
	private ArrayList<Mensch> persons;
	
	public Gitter(int width, int height, int personCount){
		this.width = width;
		this.height = height;
		gitter = new Feld[width][height];
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				gitter[i][j] = new Feld(i,j);
			}
		}
		this.persons = new ArrayList<>();
		
		Random rand = new Random();
		for (int i = 0; i < personCount; i++) {
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			this.persons.add(new Mensch(x,y));
		}
		
		this.persons.add(new Mensch("Anton Angeber", 1, 0, 0));
		this.persons.add(new Mensch("Berta Bl�mchen", 2, width, height));
	}

	
    public ArrayList<Feld> getNachbarn(Feld start){
        ArrayList<Feld> nachbarn = new ArrayList<Feld>();
        // get start coordinates
        int x = start.getX();
        int y = start.getY();
        
        // if neighbor is in gitter then add to neighbor list
        if(inGitter(x-1, y)){
            nachbarn.add(gitter[x-1][y]);
        }
        if(inGitter(x+1, y)){
            nachbarn.add(gitter[x+1][y]);
        }
        if(inGitter(x, y+1)){
            nachbarn.add(gitter[x][y+1]);
        }
        if(inGitter(x, y-1)){
            nachbarn.add(gitter[x][y-1]);
        }
        return nachbarn;
    }
	
    public boolean inGitter(int x, int y){
        
        return x < width  && x >= 0 && y < height  && y >= 0;
    }


	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	

}
