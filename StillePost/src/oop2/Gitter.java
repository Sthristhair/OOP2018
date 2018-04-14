package oop2;

public class Gitter {
	//Attribute
	private int width;
	private int height;
	private Feld[][] gitter;
	
	public Gitter(int width, int height){
		this.width = width;
		this.height = height;
		gitter = new Feld[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				gitter[i][j] = new Feld(i,j);
			}
		}
	}
}
