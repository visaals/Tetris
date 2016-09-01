package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class VertBlock implements Anim {

	boolean boo;
	public int x, y;

	public VertBlock(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// public void moveRight() {
	// this.x = this.x + 1;
	// }
	//
	// public void moveLeft() {
	// this.x = this.x - 1;
	//
	// }

	public void draw(Grid a) {
		StdDraw.setPenColor(Color.cyan);
		// StdDraw.filledRectangle(x, y, 1, 1);
		StdDraw.filledRectangle(this.x, this.y, 1, 4);

		if (this.getRow() > 4 && a.grid[getRow() - 4][getCol()] == false
		// && a.grid[getRow() - 6][getCol()+1] == false
		// && a.grid[getRow() - 6][getCol()-1] == false
		) {
			this.y = this.y - 1;
		}

		// if (this.getRow() > 2 && this.getRow() <= 4 ) {
		// this.y = this.y - 1;
		//
		// }
		if (getRow() == 4) {
			a.occupyVert(this);
			//// a.clearRow();

		}

	}
	/**
	 * This method returns true if the block is finished dropping
	 *  and it calls the occupy method once it is finished dropping
	 *  so that the next block will not occupy the same space
	 */
	public boolean isDone(Grid a) {
		if (getRow() == 4) {
			a.occupyVert(this);
		}
		if (getRow() < 4) {
			return true;

		}
		if (getRow() >= 4) {
			if (a.grid[getRow() - 4][getCol()] == true) {
				a.occupyVert(this);
				return true;
			}
		}
		return false;
	}

	public int getRow() {
		return (int) this.y;
	}

	public int getCol() {
		return (int) this.x;
	}
	/**
	 * This method controls the objects movement. 
	 * 
	 * It will move left 1 notch if 'a' is pressed,
	 * and it will move right if 'd' is pressed.
	 */
	public void move(Grid a) {

		if (this.isDone(a) == false && StdDraw.hasNextKeyTyped()) {
			if (StdDraw.nextKeyTyped() == 'a') {
				if (a.grid[getRow()][getCol() - 2] == false && this.x >= 3) {
					this.x = this.x - 2;
				}
			} else {

				if (a.grid[getRow()][getCol() + 2] == false && this.x <= 17) {
					this.x = this.x + 2;
				}
			}

		}

	}
	
	/**
	 * This method is used to move blocks down when a row is cleared.
	 */
	public void moveDown(Grid a) {
		this.y = this.y - 4;
	}

	public boolean isVertBlock() {
		return true;
	}
	public void callOccupy(Grid a){
		a.occupyVert(this);
	}

}
