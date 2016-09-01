package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Grid extends Game {

	public int rows = 50;
	public int cols = 22;
	public boolean occupied;
	public boolean[][] grid;
	public boolean clearRow;
	public int clearRowInt;
	public int score = 0;

	/**
	 * This will be the grid for Tetris. It should be a 20 rows and 10 columns.
	 * Each (x,y) coordinate in the grid will have a true or false value -->
	 * occupied or not
	 * 
	 * When a block isDone, it changes the truth values of the corresponding
	 * index of the grid, so that the next block will stop.
	 * 
	 * @param rows
	 *            22 rows (2 are above the thing)
	 * @param cols
	 *            10 cols
	 * 
	 */
	public Grid() {
		rows = 50;
		cols = 22;
		grid = new boolean[rows + 2][cols + 2];

		for (int i = 0; i < rows + 2; i++) {
			for (int j = 0; j < cols + 2; j++) {
				grid[i][j] = false;
			}
		}

	}

	public void checkRow() {

		int counter = 0;
		clearRow = false;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == true) {
					counter++;
				}
			}

			if (counter >= cols - 3) {
				score = score + 100;
				for (int k = 0; k < cols; k++) {
					clearRowInt = i;
					
//					grid[i][k] = false;
//					grid[i + 1][k] = false;
//					grid[i + 2][k] = false;
//					
//					if (i > 0) {
//						grid[i - 1][k] = false;
//					}
//					if (i > 1) {
//						grid[i - 2][k] = false;
//					}

					StdDraw.setPenColor(Color.white);

					if (i >= 2) {
						StdDraw.filledRectangle(10, i, 9, 2);
					}
					if (i < 2) {
						StdDraw.filledRectangle(10, 2, 9, 2);
					}
					clearRow = true;


				}
			}
			counter = 0;
		}

	}
	// flawed
	public void moveGridDown(){
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				
				
				grid[clearRowInt][j] = grid[clearRowInt+4][j];
				grid[clearRowInt-1][j] = grid[clearRowInt+3][j];
				grid[clearRowInt-2][j] = grid[clearRowInt+2][j];
				
				grid[clearRowInt+1][j] = grid[clearRowInt+5][j];
				grid[clearRowInt+2][j] = grid[clearRowInt+6][j];
				
				for (int k = 3; k < 30; k++) {
				grid[clearRowInt+k][j] = grid[clearRowInt+ 4 + k][j];
				}
				


			}
		}
	}
	
	/**
	 * if a block stops moving, or isDone = true, then this method changes the
	 * truth values of the grid array
	 * 
	 * @param a1
	 */
	public void occupy(Block a1) {

		// if (a1.isDone(this) == true) {
		if (a1.getRow() >= 0) {
		grid[a1.getRow()][a1.getCol()] = true;

		grid[a1.getRow()][(a1.getCol() + 2)] = true;
		grid[a1.getRow()][(a1.getCol() - 2)] = true;
		grid[a1.getRow()][(a1.getCol() + 1)] = true;
		grid[a1.getRow()][(a1.getCol() - 1)] = true;

		grid[a1.getRow() + 1][(a1.getCol() + 2)] = true;
		grid[a1.getRow() + 1][(a1.getCol() - 2)] = true;
		grid[a1.getRow() + 1][(a1.getCol() + 1)] = true;
		grid[a1.getRow() + 1][(a1.getCol() - 1)] = true;

		grid[a1.getRow() + 2][(a1.getCol() + 2)] = true;
		grid[a1.getRow() + 2][(a1.getCol() - 2)] = true;
		grid[a1.getRow() + 2][(a1.getCol() + 1)] = true;
		grid[a1.getRow() + 2][(a1.getCol() - 1)] = true;
		}
		if (a1.getRow() >=2) {

		grid[a1.getRow() - 2][(a1.getCol() + 2)] = true;
		grid[a1.getRow() - 2][(a1.getCol() - 2)] = true;
		grid[a1.getRow() - 2][(a1.getCol() + 1)] = true;
		grid[a1.getRow() - 2][(a1.getCol() - 1)] = true;

		grid[a1.getRow() - 1][(a1.getCol() + 2)] = true;
		grid[a1.getRow() - 1][(a1.getCol() - 2)] = true;
		grid[a1.getRow() - 1][(a1.getCol() + 1)] = true;
		grid[a1.getRow() - 1][(a1.getCol() - 1)] = true;

		}
	}

	public void occupyVert(VertBlock v1) {
		if (v1.getRow() >= 0) {
		grid[(v1.getRow())][(v1.getCol())] = true;
		grid[(v1.getRow())][(v1.getCol() - 1)] = true;
		grid[(v1.getRow())][(v1.getCol() + 1)] = true;

		grid[(v1.getRow() + 1)][(v1.getCol())] = true;
		grid[(v1.getRow() + 2)][(v1.getCol())] = true;
		grid[(v1.getRow() + 3)][(v1.getCol())] = true;
		grid[(v1.getRow() + 4)][(v1.getCol())] = true;
		

		grid[(v1.getRow() + 1)][(v1.getCol() + 1)] = true;
		grid[(v1.getRow() + 2)][(v1.getCol() + 1)] = true;
		grid[(v1.getRow() + 3)][(v1.getCol() + 1)] = true;
		grid[(v1.getRow() + 4)][(v1.getCol() + 1)] = true;
	
		grid[(v1.getRow() + 1)][(v1.getCol() - 1)] = true;
		grid[(v1.getRow() + 2)][(v1.getCol() - 1)] = true;
		grid[(v1.getRow() + 3)][(v1.getCol() - 1)] = true;
		grid[(v1.getRow() + 4)][(v1.getCol() - 1)] = true;
		}
		
		if (v1.getRow() >=4 ) {
		
		grid[(v1.getRow() - 1)][(v1.getCol() - 1)] = true;
		grid[(v1.getRow() - 2)][(v1.getCol() - 1)] = true;
		grid[(v1.getRow() - 3)][(v1.getCol() - 1)] = true;
		grid[(v1.getRow() - 4)][(v1.getCol() - 1)] = true;
		
		grid[(v1.getRow() - 1)][(v1.getCol())] = true;
		grid[(v1.getRow() - 2)][(v1.getCol())] = true;
		grid[(v1.getRow() - 3)][(v1.getCol())] = true;
		grid[(v1.getRow() - 4)][(v1.getCol())] = true;
		
		grid[(v1.getRow() - 1)][(v1.getCol() + 1)] = true;
		grid[(v1.getRow() - 2)][(v1.getCol() + 1)] = true;
		grid[(v1.getRow() - 3)][(v1.getCol() + 1)] = true;
		grid[(v1.getRow() - 4)][(v1.getCol() + 1)] = true;
		}






	}

}
