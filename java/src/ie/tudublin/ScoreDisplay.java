package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	public ArrayList<Note> notes = new ArrayList<Note>();

	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	float border;
	float h;
	int numLines = 5;
	float space;

	public void loadScore() {
		for (int i = 0; i < score.length(); i++) {
			char c1 = score.charAt(i);
			char c2 = score.charAt(i + 1);
			int d = 1;

			if (Character.isDigit(c2)) {
				d = c2 - '0';
				i++;
			}

			Note n = new Note(c1, d);
			notes.add(n);
		}
	}

	public void printScores() {
		String type;

		for (Note n:notes) {
			if (n.getDuration() == 1) {
				type = "Quaver";
			}
			else {
				type = "Crotchet";
			}

			println(n.getNote() + "\t" + n.getDuration() + "\t" + type + "\n");
		}
	}

	public void lines() {
		space = h / numLines;

		for (int i = 0; i < numLines; i++) {
			stroke(0);
			strokeWeight(3);

			line(border, height * 0.4f + (space * i), width - border, height * 0.4f + (space * i));
		}
	}

	public void drawNotes() {
		int numNotes = notes.size();
		float lineLength = width - border - border;
		float lengthSpace = lineLength / numNotes;
		float x_pos = border + (lengthSpace * 0.5f);

		for (Note n:notes) {
			float newNote = n.getNote();
			noStroke();
			fill(0);

			if (n.getNote() < 'D') {
				newNote = n.getNote() + 7;
			}

			float y_pos = map(newNote,'D','K', height * 0.4f + (space * 5), height * 0.4f);
			circle(x_pos, y_pos, 22);

			stroke(0);
			line(x_pos + 11, y_pos, x_pos + 11, y_pos - (space * 2.5f));

			if (n.getDuration() == 1) {
				line(x_pos + 12, y_pos - (space * 2.5f), x_pos + 24, y_pos - (space * 2));
			}

			x_pos += lengthSpace;
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
		border = width * 0.1f;
		h = height * 0.2f;

		loadScore();
		printScores();
	}

	public void draw()
	{
		background(255);
		
		lines();
		drawNotes();
	}
}
