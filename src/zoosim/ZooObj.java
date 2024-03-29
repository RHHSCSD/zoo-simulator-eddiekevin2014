/**
 * 
 */
package zoosim;

import java.awt.Point;

/**
 * Zoo Object Class
 */
public class ZooObj implements IObject {
	private String id;
	private String type; //(food, rock, tree)
	private Point position;
	private char size; //(L/M/S)

	/**
	 * Constructor
	 */
	public ZooObj() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Point position) {
		this.position = position;
	}
        
        /**
	 * @param x the position X to set
	 */
	public void setPositionX(int x) {
		this.position.move(x, (int) position.getY());
	}
        
        /**
	 * @param y the position Y to set
	 */
	public void setPositionY(int y) {
		this.position.move((int) position.getX(), y);
	}

	/**
	 * @return the size
	 */
	public char getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(char size) {
		this.size = size;
	}

	/**
         * Turn (objects cannot turn)
         * @param degree 
         */
	@Override
	public void turn(int degree) {
		// TODO Auto-generated method stub
	}

	/**
         * Place object 
         * @param x
         * @param y 
         */
	@Override
	public void place(int x, int y) {
		// TODO Auto-generated method stub
		position.move(x, y);
	}

	/**
	 * toString
	 */
	public String toString() {
		return getId() + " - " + getType();
	}
	
	/**
	 * toDetailString for object statistics
         * @return String
	 */
	public String toDetailString() {
		String detailStr = new String();
		detailStr = ZooConfig.HEADER_ID + ": " + getId() + "\n\t" + 
				ZooConfig.HEADER_TYPE + ": " + getType() + "\n\t" + 
				ZooConfig.HEADER_POS + ": (" + getPosition().getX() + ", " + getPosition().getY() + ")\n\t" + 
				ZooConfig.HEADER_SIZE + ": " + getSize(); 
		return detailStr;
	}
	
}
