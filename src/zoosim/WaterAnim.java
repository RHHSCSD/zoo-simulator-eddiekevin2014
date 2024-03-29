/**
 * 
 */
package zoosim;

/**
 * Water Animal Class
 */
public class WaterAnim extends Animal implements ISwimmable {
	private boolean canBreathe = true;

	/**
	 * Constructor
	 */
	public WaterAnim() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @return the canBreathe
	 */
	public boolean isCanBreathe() {
		return canBreathe;
	}


	/**
	 * @param canBreathe the canBreathe to set
	 */
	public void setCanBreathe(boolean canBreathe) {
		this.canBreathe = canBreathe;
	}

        
        /**
         * Check if water animal can surface above water
         * @return boolean
         */
	@Override
	public boolean canSurface() {
		// TODO Auto-generated method stub
		if (position.getY() >= ZooConfig.WATER_MAX_POS.getY()){
			return true;
		}else {
			return false;
		}	
	}
	
	/**
         * Place inside water animal area (bottom)
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
		if (y < ZooConfig.WATER_MIN_POS.getY()) {
			y = (int)ZooConfig.WATER_MIN_POS.getY();
		} else if (y > ZooConfig.WATER_MAX_POS.getY()) {
			y = (int)ZooConfig.WATER_MAX_POS.getY();
		}
		position.move(x, y);
	}
	
	/**
	 * get superclass toDetailString and add breathing statistic
  	 * @return String
	 */
	@Override
	public String toDetailString() {
		String detailStr = super.toDetailString() +  "\n\t" + ZooConfig.HEADER_CAN_BREATHE + ": " + isCanBreathe();	
		return detailStr;
	}
}
