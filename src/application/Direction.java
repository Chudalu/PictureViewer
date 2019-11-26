package application;
import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * This class handles the directions the user can be at.
 * A direction have views defining the North, East, West and South.
 * Each direction is either an exit to a location or an entry to another location.
 * @author Chudalu Ezenwafor
 *@version 2017.11.23
 */

public class Direction {
	
	private HashMap<Location, Integer> Direction; 
	private HashMap<Integer, Image> Pictures;
	Random generator = new Random();
	
	/**
	 * Initialises the Direction and Picture hashmaps.
	 */
	public Direction () {
		
		Direction = new HashMap<>();
		Pictures = new HashMap<>();
		
	}
	/**
	 * This maps the different location to coordinate format (integer)
	 * @param local 
	 * @param cord
	 */
	public void setDirection(Location local, int cord) {
		
		Direction.put(local, cord);
	}
	/**
	 * Maps the various locations (integer) + the different coordinates
	 * (North = 0, East = 1, South = 2, West = 3) to their various views 
	 * @param num location coordinate
	 * @param pic direction views
	 */
	public void setImages(int cord, Image pic) {
		Pictures.put(cord, pic);
	}
	
	/**
	 * this takes the locations and the current coordinate
	 * returns the direction view the user should be on.
	 * @param loc current location
	 * @param cor coordinates
	 * @return 
	 */
	public Image getDirect(Location loc, int cor) {
		int num = Direction.get(loc);
		num = num + cor;
		
	 return Pictures.get(num);
		
	}
	/**
	 * this sets the random location of the bird image in a specific direction
	 * to a specific direction view.
	 * @return returns the specific direction view.
	 */
	public Image randomLocation() {
		List<Image> valuesList = new ArrayList<Image>(Pictures.values());
		int randomIndex = new Random().nextInt(valuesList.size());
		Image randomLocation = valuesList.get(randomIndex);
		
		return randomLocation;
	}
	
}
