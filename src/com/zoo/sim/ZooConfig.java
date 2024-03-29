package com.zoo.sim;

import java.awt.Point;

/**
 * Zoo Class of Static values
 * 
 */
public class ZooConfig {

	public static final int WIDTH = 900;
	public static final int HEIGHT = 1200;
	
	public static final Point BIRD_MIN_POS = new Point(0,800);
	public static final Point LAND_MIN_POS = new Point(0,400);
	public static final Point WATER_MIN_POS = new Point(0,0);
	
	public static final Point BIRD_MAX_POS = new Point(900,1200);
	public static final Point LAND_MAX_POS = new Point(900,800);
	public static final Point WATER_MAX_POS = new Point(900,400);
	
	public static final int MIN_LEVEL = 1;
	public static final int MAX_LEVEL = 10;
	
	public static final String HEADER_ID = "ID";
	public static final String HEADER_NAME = "Name"; 
	public static final String HEADER_SPECIES = "Species"; 
	public static final String HEADER_SEX = "SEX"; 
	public static final String HEADER_AGE = "Age"; 
	public static final String HEADER_POS = "Position";
	public static final String HEADER_POS_X = "PositionX";
	public static final String HEADER_POS_Y = "PositionY";
	public static final String HEADER_SIZE = "Size";
	public static final String HEADER_SPEED = "Speed";
	public static final String HEADER_DIRECT = "Direction";
	public static final String HEADER_HUNGER = "Hunger";
	public static final String HEADER_FATIGUE = "Fatigue";
	public static final String HEADER_IMAGE = "Image"; 
	public static final String HEADER_IMAGE_W = "ImageW"; 
	public static final String HEADER_IMAGE_H ="ImageH";
	public static final String HEADER_SOUND ="Sound";
	public static final String HEADER_CAN_FLY ="CanFly";
	public static final String HEADER_CAN_BREATHE ="CanBreathe";
	public static final String HEADER_TYPE = "Type";
	
	public static final String KEY_LAND = "LAND";
	public static final String KEY_BIRD = "BIRD";
	public static final String KEY_WATER = "WATER";
	
	public static final String VALUE_NA = "n/a";
	
	
}
