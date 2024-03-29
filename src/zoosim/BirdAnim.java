/**
 * 
 */
package zoosim;

/**
 * Bird Animal Class
 */
public class BirdAnim extends Animal implements IFlyable {
	
	private boolean canFly = true;

	/**
	 * Constructor
	 */
	public BirdAnim() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return canFly
	 */
	public boolean isCanFly() {
		return canFly;
	}


	/**
	 * @param canFly the canFly to set
	 */
	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

        /**
         * set direction upwards when flying
	 */
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		setDirection(90);
		move();	
	}

        /**
         * set direction downward when landing
	 */
	@Override
	public void land() {
		// TODO Auto-generated method stub
		setDirection(-90);
		move();	
	}
        
        /**
         * check if inside the bird animal area
	 */
	@Override
	public boolean isFlying() {
		// TODO Auto-generated method stub	
		if (position.getY() >= ZooConfig.BIRD_MIN_POS.getY()){
			return true;
		}else {
			return false;
		}
	}
	
	/**
         * place inside the bird animal area (top)
	 */
	@Override
	public void place(int x, int y) {
		// TODO Auto-generated method stub
		if (x > ZooConfig.WIDTH) {
			x -= ZooConfig.WIDTH;
		} else if (x < 0) {
			x += ZooConfig.WIDTH;
		}
		if (y < ZooConfig.BIRD_MIN_POS.getY()) {
			y = (int)ZooConfig.BIRD_MIN_POS.getY();
		} else if (y > ZooConfig.BIRD_MAX_POS.getY()) {
			y = (int)ZooConfig.BIRD_MAX_POS.getY(); 
		}
		position.move(x, y);
	}

	/**
	 * get superclass toDetailString and add flying statistic
	 */
	@Override
	public String toDetailString() {
		String detailStr = super.toDetailString() +  "\n\t" + ZooConfig.HEADER_CAN_FLY + ": " + isCanFly();	
		return detailStr;
	}
}
