package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	public ArrayList<Note> notes = new ArrayList<Note>();

	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	public void loadScore() {
		for (int i = 0; i < score.length(); i++) {
			char c = score.charAt(i);
			int d = 1;

			if (Character.isDigit(i + 1)) {
				d = c - '0';
				i++;
			}

			Note n = new Note(c, d);
			notes.add(n);
		}
	}
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void setup() 
	{
		loadScore();
	}

	public void draw()
	{
		background(255);
		
	}

	void drawNotes()
	{
	}
}
