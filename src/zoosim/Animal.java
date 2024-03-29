/**
import java.awt.Point;
 * 
 */
package zoosim;

import java.awt.Point;

/**
 * Animal Class
 */
public class Animal implements IEntity {

	String id;
	String name; 
	String species;
	char sex; //(M/F)
	int age;
	Point position; //(x,y)
	char size; //(L/M/S)
	int speed; //(1-20) 
	double direction;
	int hunger;	//(1-10)
	int fatigue; //(1-10)
	Image image;  //(x,y)
	String sound;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return the sex
	 */
	public char getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
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
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the direction
	 */
	public double getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(double direction) {
		this.direction = direction;
	}

	/**
	 * @return the hunger
	 */
	public int getHunger() {
		return hunger;
	}

	/**
	 * @param hunger the hunger to set
	 */
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	/**
	 * @return the fatigue
	 */
	public int getFatigue() {
		return fatigue;
	}

	/**
	 * @param fatigue the fatigue to set
	 */
	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	
	/**
	 * @param image the image to set
	 */
	public void setImage(int w, int h) {
		this.image.setWidth(w);
		this.image.setHeight(h);
	}

	/**
	 * @return the sound
	 */
	public String getSound() {
		return sound;
	}

	/**
	 * @param sound the sound to set
	 */
	public void setSound(String sound) {
		this.sound = sound;
	}

	
	/**
         * default constructor
	 */
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	/**
         * constructor
	 * @param id
	 */
	public Animal(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	
	/**
         * Turn method
         * @param degree 
         */
	@Override
	public void turn(int degree) {
		// TODO Auto-generated method stub
                System.out.println("\tCurrent direction: " + getDirection() + " degrees");
		System.out.println("\tTurn: " + degree + " degrees");
                setDirection(getDirection() + degree);
                if (getDirection() >= 360){
                    setDirection(getDirection() - 360);
                }
		System.out.println("\tNew direction: " + getDirection() + " degrees");
	}

	/**
         * Place method
         * @param x
         * @param y 
         */
	@Override
	public void place(int x, int y) {
		// TODO Auto-generated method stub
		if (x > ZooConfig.WIDTH) {
			x -= ZooConfig.WIDTH;
		} else if (x < 0) {
			x += ZooConfig.WIDTH;
		}
		if (y > ZooConfig.HEIGHT) {
			y -= ZooConfig.HEIGHT;
		} else if (y < 0) {
			y += ZooConfig.HEIGHT;
		}
		this.position.move(x, y);
	}

	/**
         * Move method
         */
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("\tSpeed: " + getSpeed());
		double yLen = speed*(Math.sin(Math.toRadians(direction)));
		double xLen = speed*(Math.cos(Math.toRadians(direction)));
		System.out.println("\tMove from: (" + position.getX() + ", " + position.getY() + ')');
		System.out.println("\tDirection: " + getDirection()+ " degrees");
		place((int)(position.getX()+ xLen), (int)(position.getY() + yLen));
		System.out.println("\tMove to: (" + position.getX() + ", " + position.getY() + ')');
		
		//hunger +2
		hunger += 2;
		if (hunger > ZooConfig.MAX_LEVEL) {
			hunger = ZooConfig.MAX_LEVEL;
		}
		
		//fatigue +2
		fatigue += 2;
		if (fatigue > ZooConfig.MAX_LEVEL) {
			fatigue = ZooConfig.MAX_LEVEL;
		}	
	}

	/**
         * Sound method
         */
	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("\tSound: " + getSound());
	}
	
	/**
         * Eat method
         */
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("\tHunger Level: " + getHunger());
		System.out.println("\tEat... ");
		int level = getHunger() - 5 ;
		if (level < ZooConfig.MIN_LEVEL) {
			level += ZooConfig.MAX_LEVEL;
		}
		setHunger(level);
		System.out.println("\tNew Hunger Level: " + getHunger());
	}

	/**
         * Sleep method
         */
	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("\tFatigue Level: " + getFatigue());
		System.out.println("\tSleep... ");
		int level = getFatigue() - 5 ;
		if (level < ZooConfig.MIN_LEVEL) {
			level += ZooConfig.MAX_LEVEL;
		}
		setFatigue(level);
		System.out.println("\tNew Fatigue Level: " + getFatigue());
	}
	
	/**
	 * toString
	 */
        @Override
	public String toString() {
		return getId() + " - " + getName();
	}
	
	/**
         * list zoo animal statistics
	 * toDetailString
	 */
	public String toDetailString() {
		String detailStr = new String();
		detailStr = ZooConfig.HEADER_ID + ": " + getId() + "\n\t" + 
				ZooConfig.HEADER_NAME + ": " + getName() + "\n\t" + 
				ZooConfig.HEADER_SPECIES + ": " + getSpecies() + "\n\t" + 
				ZooConfig.HEADER_SEX + ": " + getSex() + "\n\t" + 
				ZooConfig.HEADER_AGE + ": " + getAge() + "\n\t" + 
				ZooConfig.HEADER_POS + ": (" + getPosition().getX() + ", " + getPosition().getY() + ")\n\t" + 
				ZooConfig.HEADER_SIZE + ": " + getSize() + "\n\t" + 
				ZooConfig.HEADER_SPEED + ": " + getSpeed() + "\n\t" +
				ZooConfig.HEADER_DIRECT + ": " + getDirection() + "\n\t" + 
				ZooConfig.HEADER_HUNGER + ": " + getHunger() + "\n\t" + 
				ZooConfig.HEADER_FATIGUE + ": " + getFatigue() + "\n\t" + 
				ZooConfig.HEADER_IMAGE + ": (" + getImage().getWidth() + ", " + getImage().getHeight() + ")\n\t" + 
				ZooConfig.HEADER_SOUND + ": " + getSound(); 
		return detailStr;
	}

}
