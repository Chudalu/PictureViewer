package application;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.HashMap;
import java.util.Set;
/**
 * This class sets the locations of the WorldViewer application.
 * A location represents a particular area a user can be at. 
 * the location is connected to other location(s) through its exits.
 * each location contain the views from that locations and the exits to the next location.
 *  these views and exits are used to explore and navigate the locations.
 * @author Chudalu Ezenwafor
 *@version 2017.11.23
 */

public class Location {
   
	@FXML
	private ImageView viewer;
	private Image frontview, rightview, leftview, backview;
	
	private HashMap<Image, Location> exits;
	
	/**
	 * This creates a location with several views. 
	 * these location does not have exits yet
	 * @param frontview 
	 * @param rightview
	 * @param backview
	 * @param leftview
	 */
	public Location(Image frontview, Image rightview, Image backview, Image leftview)
	{
		this.frontview = frontview;
		this.rightview= rightview;
		this.leftview = leftview;
		this.backview = backview;
		
		
		exits = new HashMap<>();
		
	}
	
	
	/**
	 * Sets the exits of different locations 
	 * and specifies the next location.
	 * @param direction the direction with the exit
	 * @param local the next location through the exit.
	 */
	public void setExit(Image direction, Location local)
	{
		exits.put(direction, local);
		
	}
	/**
	 * Returns the front view of a direction in the location
	 * @return
	 */
	public Image getfront() {
		return frontview;
	}
	/**
	 * Returns the right view of a direction in the location
	 * @return
	 */
	public Image getlookright() {
		return rightview;
	}
	/**
	 * Returns the left view of a direction in the location
	 * @return
	 */
	public Image getlookLeft() {
		return leftview;
	}
	/**
	 * Returns the right view of a direction in the location
	 */
	public Image getlookback(){
		return backview;
	}
	/**
	 * Returns the exit of a direction in the location
	 * @param view the current direction of the user
	 * @return
	 */
	public Location getExit(Image view) {
		return exits.get(view);
	}
	/**
	 * Returns a boolean value to assert whether there is an exit
	 * in the direction the user is in.
	 * @param view the current direction of the user
	 * @return
	 */
	public Boolean assertExit(Image view) {
		Set <Image> exit = exits.keySet();
		return exit.contains(view);
	}
}
