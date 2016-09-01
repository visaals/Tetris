package lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import javax.imageio.ImageIO;

import sedgewick.StdDraw;

/**
 * This is my Game class, which has the main method of my program.
 * 
 * As of now, I create a linked list consisting of randomized objects.
 * 
 * My draw loop iterates through this list of objects and draws the block object
 * at the top and draws the next object once the previous object "isDone," which
 * is a method in the Block object that checks if the block should stop moving.
 * 
 * My draw loop also has a grid of lines I drew to represent the tetris board.
 * 
 * 
 * @author Visaaleswar Sivakumar Ambalam
 *
 */
public class Game {

	public static void main(String[] args) {

		/**
		 * This creates a random list of 100 blocks
		 * 
		 * Need to update to include multiple blocks
		 * 
		 * Draw a white square for when the row fills up, and then set it's
		 * occupy value to 0 so that everything falls down
		 * 
		 */
		List<Anim> scene = new LinkedList<Anim>();

		for (double l = 0; l < 1000; l++) {

			// generating a random block object and adding it to the list
			// int randx = (int) (Math.random() * 18);
			// make sure to spawn on an even block
			if (Math.random() > 0.5) {
				Block random = new Block(11, 45);
				scene.add(random);

			} else {
				VertBlock random2 = new VertBlock(10, 45);
				scene.add(random2);

			}
		}

		Grid actualGrid = new Grid();

		// Scaled the Canvas from 0 to 10
		StdDraw.setXscale(0, 40);
		StdDraw.setYscale(0, 40);

		while (!scene.isEmpty()) {
			StdDraw.clear();
			// draw everything

			// Boundary for Tetris playing board
			StdDraw.setPenColor(Color.black);
			StdDraw.filledRectangle(20, 20, 25, 25);
			StdDraw.setPenColor(Color.white);
			StdDraw.filledRectangle(10, 21, 9.1, 21.1);

			// setting the font and drawing the text
			Font font = new Font("Georgia", Font.PLAIN, 40);
			StdDraw.setFont(font);

			StdDraw.setPenColor(Color.white);
			StdDraw.text(30, 30, "Score: " + actualGrid.score);
			StdDraw.text(30, 20, "Next Block:");

			// StdDraw.setPenColor(Color.black);
			// StdDraw.line(20, 0, 20, 40);
			// for (double i = 0; i < 20; i = i + 1) {
			// StdDraw.setPenColor(Color.black);
			//
			// StdDraw.line(i, 0, i, 40);
			// }
			// for (double i = 0; i < 40; i = i + 1) {
			// StdDraw.setPenColor(Color.black);
			// StdDraw.line(0, i, 20, i);
			// }

			// draws the first object
			scene.get(0).draw(actualGrid);
			scene.get(0).move(actualGrid);
			// draws the first next-block image
		/*	if (scene.get(1).isVertBlock() == true) {
				StdDraw.picture(30, 10, "file:/Users/Visaal/Desktop/VertBlock2.jpg", 10, 10);
			} else {
				StdDraw.picture(30, 10, "file:/Users/Visaal/Desktop/Block.png", 10, 10);
			} 
		*/

			// Draws the list of objects every time an object .isDone is true
			// draws consecutive objects when the previous object is done.
			for (int i = 0; i < scene.size() - 1; i++) {
				// if at the end of the list, print GAME OVER
				if (scene.get(i).isDone(actualGrid)) {
					if (i == scene.size() - 3) {
						StdDraw.text(30, 35, "GAME OVER");
						break;
					}

					else {
						actualGrid.checkRow();

						scene.get(i + 1).move(actualGrid);
						scene.get(i + 1).draw(actualGrid);

						// displays image based on what the next object is
						if (scene.get(i + 2).isVertBlock() == true) {
							StdDraw.picture(30, 10, "file:/Users/Visaal/Desktop/VertBlock2.jpg", 10, 10);
						} else {
							StdDraw.picture(30, 10, "file:/Users/Visaal/Desktop/Block.png", 10, 10);
						}
					}

				}

			}
			// moves down objects that are above the cleared row when
			// there is a row that needs to be cleared
			if (actualGrid.clearRow == true) {
				for (int j = 0; j < scene.size() - 1; j++) {

					if (scene.get(j).getRow() >= actualGrid.clearRowInt) {
						// StdDraw.filledRectangle(10, 2, 9, 2);

						actualGrid.moveGridDown();

						scene.get(j).moveDown(actualGrid);

					}

				}
			}

			// drawing over the blocks that were moved down for cosmetic brownie
			// points
			StdDraw.setPenColor(Color.black);
			StdDraw.filledRectangle(20, -1, 20, 1);
			StdDraw.show(50);
		}

	}
}
