/**
 * 
 */
package com.zoo.sim;

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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
