package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

/**
 * Has-a x and y value, which is the center of the block
 * 
 * @author Visaal
 *
 */
public class Block implements Anim {

	public int x, y; // location of blocks

	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Draws the Square block
	/**
	 * draws a yellow square block and has conditions based on the 
	 * 	boolean grid to determine if it should keep falling
	 * 
	 * if the grid value below the block is false
	 * the block should keep dropping
	 * 
	 * else it will stop and occupy the grid
	 */
	public void draw(Grid a) {
		StdDraw.setPenColor(Color.yellow);
		StdDraw.filledRectangle(this.x, this.y, 2, 2);

		if (getRow() > 2 && a.grid[getRow() - 1][getCol() + 1] == false
				&& a.grid[getRow() - 1][getCol() - 1] == false
				&& a.grid[getRow()][getCol() - 1] == false) {

			this.y = this.y - 1;

		}

		// This if statement below doesn't do anything
		if (getRow() == 2) {
			a.occupy(this);
		}

	}

	// when it is drawn, the parts of the grid become true and it stops
	// drawing with the .occupy() Method

	/**
	 * Determines when the block should stop moving
	 */
	public boolean isDone(Grid a) {

		if (getRow() >= 2) {
			if (a.grid[getRow() - 2][getCol()] == true || a.grid[getRow() - 2][getCol() + 1] == true
					|| a.grid[getRow() - 2][getCol() - 1] == true
			// ||
			// a.grid[getRow() - 4][getCol()+2] == true
			// ||
			// a.grid[getRow() - 4][getCol()-2] == true
			) {
				a.occupy(this);
				return true;
			}
		}

		if (getRow() == 2) {
			a.occupy(this);
			return true;

		}

		if (getRow() < 2) {
			return true;
		}

		else {
			return false;
		}
	}

	public int getRow() {
		if (this.y > 0) {
			return (int) this.y;
		}

		else {
			return 0;
		}
	}

	public int getCol() {
		return (int) this.x;
	}
	
	/**
	 * allows me to move objects by 2 units using 'a' or 'd'
	 */
	public void move(Grid a) {

		if (this.isDone(a) == false && StdDraw.hasNextKeyTyped()) {
			if (StdDraw.nextKeyTyped() == 'a') {
				if (a.grid[getRow()][getCol() - 3] == false && this.x >= 4) {
					this.x = this.x - 2;
				}

			} else {
				if (a.grid[getRow()][getCol() + 3] == false && this.x <= 16) {
					this.x = this.x + 2;
				}
			}

		}

	}
	
	/**
	 * this method is called when a row is filled up so objects are moved down.
	 */
	public void moveDown(Grid a) {
		this.y = this.y - 4;
	}

	public boolean isVertBlock() {
		return false;
	}
	public void callOccupy(Grid a){
		
	}

}
