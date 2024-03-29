/**
 * 
 */
package zoosim;

/**
 * Represents images for the animals
 */
public class Image {
	private int width;
	private int height;

	/**
         * default constructor
	 * 
	 */
	public Image() {
		// TODO Auto-generated constructor stub
	}
	/** 
         * constructor
	 * @param width
	 * @param height
	 */
	public Image(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	/**
         * @return int
         */
	public int getWidth() {
		return width;
	}

	/**
         * @param width 
         */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
         * @return int
         */
	public int getHeight() {
		return height;
	}

	/**
         * @param height 
         */
	public void setHeight(int height) {
		this.height = height;
	}

}
