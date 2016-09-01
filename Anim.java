package lab10;

/**
 * This interface is implemented to each of my Tetris blocks
 * 
 * @author Visaal
 *
 */
public interface Anim {

	/**
	 * Draws the shape on the screen relative to the boolean array (grid)
	 */
	public void draw(Grid a);

	/**
	 * shows whether it is finished, and should be removed from my list of
	 * things I'm animating
	 * 
	 * @return true or false when the block hits the floor or bottom blocks
	 */
	public boolean isDone(Grid a);

	/**
	 * 
	 * @return the this.y integer value of the block
	 */
	public int getRow();

	/**
	 * 
	 * @return the this.x integer value of the block
	 */
	public int getCol();

	/**
	 * moves the block left or right with the keys a and d
	 * 
	 * @param a
	 */
	public void move(Grid a);

	/**
	 * moves blocks down when a row is filled
	 * 
	 * @param a
	 */
	public void moveDown(Grid a);

	/**
	 * returns true if this <Anim> object is a VertBlock, returns false if it is
	 * a regular Block
	 */
	public boolean isVertBlock();
	/**
	 * Allows me to call the .occupy() method in my Grid class from the Game class
	 * @param a
	 */
	public void callOccupy(Grid a);

}
