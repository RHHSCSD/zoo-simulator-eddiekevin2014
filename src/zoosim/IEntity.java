/**
 * 
 */
package zoosim;

/**
 * Interface (Every animal in the zoo is an entity)
 */
public interface IEntity extends IObject {
	
	public void move();
	public void makeSound();
	public void eat();
	public void sleep();

}
