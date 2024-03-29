/**
 * 
 */
package zoosim;

/**
 * Land Animal Class
 */
public class LandAnim extends Animal {

	/**
	 * Constructor
	 */
	public LandAnim() {
		// TODO Auto-generated constructor stub
		
	}

        
        /**
         * Place inside land animal area (middle)
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
		if (y < ZooConfig.LAND_MIN_POS.getY()) {
			y = (int)ZooConfig.LAND_MIN_POS.getY();
		} else if (y > ZooConfig.LAND_MAX_POS.getY()) {
			y = (int)ZooConfig.LAND_MAX_POS.getY();
		}
		position.move(x, y);
	}
}
