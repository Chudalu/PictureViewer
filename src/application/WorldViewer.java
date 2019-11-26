package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * This class is the main control class of the WorldViewer application
 * This WorldViewer application is a simple image exploring application 
 * Users get to move to different locations. These locations have views at different directions.
 * The user navigates through the locations, and try to locate a randomly placed bird
 * the bird can be picked and placed at any desired location.
 * This class initialises all the other classes. It creates all the locations and directions. 
 * It also executes the returned values from the Location and Direction classes.
 *  
 * @author Chudalu Ezenwafor
 * @version 2017.11.23
 */

public class WorldViewer {
	@FXML
	private Button lookleft;
	@FXML
	private Button lookright;
	@FXML
	private Button accelerate;
	@FXML
	private Button lookback;
	@FXML
	private MenuBar Menubar;
	@FXML
	private MenuItem pickup;
	@FXML
	private MenuItem putdown;
	@FXML
	private MenuItem Infoguide;  
	@FXML
	private Button rightturn;
	@FXML
    private Button lookfront;
	@FXML
	private Button leftturn;  
	@FXML
	private ImageView viewer;
	@FXML
	private ImageView view;
	@FXML
	private TextField info;
	//image locations to be used for bird pick up and put down 
	private Image putdownlocationConfirm;
	private Image randombirdLocation;
	private Image putdownLocation, pickupLocation;
	
	//The locations are declared, but not yet created.
	private Location leftjunction, rightjunction, garage, junction;
	private Location localize;
	
	//object of Direction class declared
	Direction direct = new Direction();
	
	int increment;
	int coordinate;
	int accel;
	int setrand;
	int currentCordinate;
	//The coordinates defining the directions are created.
	int North = 0;
	int East = 1;
	int South = 2;
	int West = 3; 
	
	
	/**
	 * Creates the WorldViewer and initialises its map.
	 */
	public WorldViewer() {
		
		CreateLocation();
		increment = 0;
		accel = 0;
		
	}
	/**
	 * Creates the locations and links them to their exits.
	 * Also creates the directions.
	 */ 
	private void CreateLocation() {
		
		//images used to develop each location and direction.
		Image Gfront = new Image("02 Garage .jpg");
		Image Grightview = new Image("03 Garage look right.jpg");
		Image Gbackview = new Image("05 Garage look back.jpg");
		Image Gleftview = new Image("04 Garage look left.jpg");
		Image Gright = new Image("07 Garage turn right.jpg");
		Image Gback = new Image("08 Garage turn back.jpg");
		Image Gleft = new Image("09 Garage turn left.jpg");
		Image Jfront = new Image("12 Junction Start .jpg");
		Image Jrightview = new Image("13 Junction look right.jpg");
		Image Jbackview = new Image("15 Junction Look back.jpg");
		Image Jleftview= new Image("14 Junction look left.jpg");
		Image Jright = new Image("16 Junction turn right.jpg");
		Image Jback = new Image("39 Junction facing Garage.jpg");
		Image Jleft = new Image("17 Junction turn left.jpg");
		Image Rfront = new Image("21 Right facing front.jpg");
		Image Rrightview = new Image("23 Right looking right .jpg");
		Image Rbackview = new Image("23 Right looking back .jpg");
		Image Rleftview = new Image("22 Right looking left.jpg");
		Image Rright = new Image("25 Right turn right.jpg");
		Image Rback = new Image("26 Right turn back.jpg");
		Image Rleft = new Image("24 Right turn left.jpg");
		Image Lfront = new Image("30 Left start.jpg");
		Image Lrightview = new Image("31 Left look right.jpg");
		Image Lbackview = new Image("33 Left Look back.jpg");
		Image Lleftview = new Image("32 Left look left.jpg");
		Image Lright = new Image("34 Left turn right.jpg");
		Image Lback = new Image("36 Left turn back.jpg");
		Image Lleft = new Image("35 Left turn left.jpg");
		
		
		//each location is created with its images/views
		garage = new Location( Gfront, Grightview, Gbackview, Gleftview);
		junction = new Location(Jfront, Jrightview, Jbackview, Jleftview);
		leftjunction = new Location(Lfront, Lrightview, Lbackview, Lleftview);
		rightjunction = new Location(Rfront, Rrightview, Rbackview, Rleftview);
		
		//the  exits are set to connect to the next locations
		//this sets the garage exit
		garage.setExit(Gfront, junction);
		//this sets the junction exits
		junction.setExit(Jback, garage);
		junction.setExit(Jleft, leftjunction);
		junction.setExit(Jright, rightjunction);
		//this sets the right location exits
		rightjunction.setExit(Rback, junction);
		//this sets the left location exits
		leftjunction.setExit(Lback, junction);
		
		//this sets up the locations for the Direction class
		int Garage = 100;
		int Junction = 200;
		int Rightjunction = 300;
		int Leftjunction = 400;
		//The Location class's location are linked with the Direction class's location.
		direct.setDirection(garage, Garage);
		direct.setDirection(junction, Junction);
		direct.setDirection(rightjunction, Rightjunction);
		direct.setDirection(leftjunction, Leftjunction);
		
		//Various locations and the views(images) at different directions
		//00 = NORTH, 01 = EAST, 02 = SOUTH, 03 = WEST, as declared above
		// 100 = garage
		direct.setImages(Garage + North, Gfront);
		direct.setImages(Garage + East, Gright);
		direct.setImages(Garage + South, Gback);
		direct.setImages(Garage + West, Gleft);
		
		//00 = NORTH, 01 = EAST, 02 = SOUTH, 03 = WEST
		// 200 = Junction
		direct.setImages(Junction + North, Jfront);
		direct.setImages(Junction + East, Jright);
		direct.setImages(Junction + South, Jback);
		direct.setImages(Junction + West, Jleft);
		
		//00 = NORTH, 01 = EAST, 02 = SOUTH, 03 = WEST
		// 300 = right Junction
		direct.setImages(Rightjunction + North, Rleft);
		direct.setImages(Rightjunction + East, Rfront);
		direct.setImages(Rightjunction + South, Rright);
		direct.setImages(Rightjunction + West, Rback);
		
		////00 = NORTH, 01 = EAST, 02 = SOUTH, 03 = WEST
		//400 = left Junction
		direct.setImages(Leftjunction + North, Lright);
		direct.setImages(Leftjunction + East, Lback);
		direct.setImages(Leftjunction + South, Lleft);
		direct.setImages(Leftjunction + West, Lfront);
		
		//the WorldViewer starts at the Garage location.
		localize = garage;
		
		//The direction of where the randomly placed bird should be is received from the Direction class.
		randombirdLocation = direct.randomLocation();
	}
	
	/**
	 * this sets the initial state of the interface
	 */
	//sets the initial state of the WorldViewer interface before the user starts
	//initial picture in the interface's Image views
	public void Start() {
	
       Image initial = new Image("01.jpg", true);
       Image bird = new Image("bird1.png", true);
	   viewer.setImage(initial);
	   view.setImage(bird);
	   view.setVisible(false);
	   info.setText("Click on Help menu for information");
	   movementerrorHandling();
	}
	/**
	 * this puts down the bird when picked up from a location.
	 * it invokes a method that disables the view image-view.
	 * actionpic - records any direction where the image is placed by the user.
	 * @param event button click event from the PUT DOWN menu item.
	 */
	public void putDown(ActionEvent event) {
		putdownLocation = viewer.getImage();
		getView();
	}
	/**
	 * this picks up the bird when its located.
	 * If the user ever arrives at the random chosen image (direction),
	 * or if the user arrives at a direction the bird was previously placed,
	 * the user is able to pick up bird, else a message is output via the INFO Textfield.
	 * @param event button click from the PICKUP menu item.
	 */
	public void pickUp(ActionEvent event) {
		setrand++;
		pickupLocation = viewer.getImage();
		if (randombirdLocation.equals(viewer.getImage())) {
			setView();
		}
		else if (putdownLocation.equals(viewer.getImage())) {
			setView();
		}
		else {
			info.setText("please pick up bird from the place it is set");
		}
	}
	/**
	 * Displays the welcome message and description of the WorldViewer application
	 * to user via the INFO Textfield.
	 * It is invoked when the help menu item is clicked.
	 */
	public void infoGuide() {
		info.setText("Welcome!!!. Explore the streets and check out the views. There is a cool-ass bird placed randomly at a location. Find it and put it anywhere you want");
	}
	
	/**
	 * this moves the user from one location to the next.
	 * the view set by the image viewer is dependent on the previous direction of the user
	 * @param event button click event from the Accelerate button.
	 */
	
	public void Accelerate(ActionEvent event ) {
		accel++; //records number of times this method is called.
	    if (accel < 2) {
		viewer.setImage(direct.getDirect(localize, currentCordinate));
	    }
		else {
			nextLocation();
			//sets the image that should be viewed based on the previous direction.
			//-/+ coordinates defines left turn(-) or right turn(+)
			if (coordinate == 0) {
				viewer.setImage(direct.getDirect(localize, North));
			}
			else if (coordinate == -1 || coordinate == 3) {
				viewer.setImage(direct.getDirect(localize, West));
			}
			else if (coordinate == -2 || coordinate == 2) {
				viewer.setImage(direct.getDirect(localize, South));
			}
			else if (coordinate == -3 || coordinate == 1) {
				viewer.setImage(direct.getDirect(localize, East));
			}
			
			}
	    getView();
	    movementerrorHandling();
	    viewerrorHandling();
	}
	/**
	 * sets the image view to show the front view of its current location and direction.
	 * @param event button click event from the LOOKFRONT button
	 */
	public void lookfront(ActionEvent event) {
		viewer.setImage(localize.getfront());
		movementerrorHandling();
	}
	/**
	 * sets the image view to show the right view of its current location and direction.
	 * @param event button click event from the LOOKRIGHT button.
	 */
	//method for lookright button click event
	@FXML
	public void lookright(ActionEvent event) {
		viewer.setImage(localize.getlookright());
		movementerrorHandling();
	}
	/** 
	 * sets the image view to show the back view of its current location and direction
	 * @param event button click event from the LOOKBACK button
	 */
	//method for lookback button click event
	@FXML
	public void lookback(ActionEvent event) {
		viewer.setImage(localize.getlookback());
		movementerrorHandling();
	}
	/**
	 * sets the image view to show the left view of its current location and direction
	 * @param event button click event from the LOOKLEFT button
	 */
	//method for lookleft button click event
	@FXML
	public void lookLeft(ActionEvent event) {
		viewer.setImage(localize.getlookLeft());
		movementerrorHandling();
	}
	
	
	/**
	 * turns the player to the right of its current direction and location.
	 * sets the image view to show the view of the right turn based on its previous direction.
	 * @param event button click event from the TURN RIGHT button
	 */
	public void turnright(ActionEvent event) {
		increment++;//increments when the button is pressed
		coordinate = increment % 4; //iterates round the four coordinate from the right (+)
		
		if (coordinate == 0 ) {
			viewer.setImage(direct.getDirect(localize, North));
			currentCordinate = North;
		}
		else if (coordinate == 1 || coordinate == -3) {
			viewer.setImage(direct.getDirect(localize, East));
			currentCordinate = East;
		}
		else if (coordinate == 2 || coordinate == -2) {
			viewer.setImage(direct.getDirect(localize, South));
			currentCordinate = South;
		}
		else if (coordinate == 3 || coordinate == -1) {
			viewer.setImage(direct.getDirect(localize, West));
			currentCordinate = West;
		}
		getView();
		movementerrorHandling();
		viewerrorHandling();
	}
	
	
	/**
	 * turns the player to the left of its current direction and location.
	 * sets the image view to show the view of the right turn based on its previous direction. 
	 * @param event button click event from the TURN RIGHT button
	 */
	public void turnleft(ActionEvent event) {
		increment--;//decrements as the button is pressed
		coordinate = increment % 4; //iterates around the coordinate from the left (-)
		
		if (coordinate == 0) {
			viewer.setImage(direct.getDirect(localize, North));
			currentCordinate = North;
		}
		else if (coordinate == -1 || coordinate == 3) {
			viewer.setImage(direct.getDirect(localize, West));
			currentCordinate = West;
		}
		else if (coordinate == -2 || coordinate == 2) {
			viewer.setImage(direct.getDirect(localize, South));
			currentCordinate = South;
		}
		else if (coordinate == -3 || coordinate == 1) {
			viewer.setImage(direct.getDirect(localize, East));
			currentCordinate = East;
		}
		getView();
		movementerrorHandling();
		viewerrorHandling();
	}
	
	
	/**
	 * gets the next location of the user's current location from a particular exit (view).
	 * this method is called from the accelerate method.
	 * any time the accelerate button is pushed, it considers the current direction and location of the user to get the next location.
	 */
	//method to call next location 
	private void nextLocation() {
		Location nextlocate = null;
	    nextlocate = localize.getExit(direct.getDirect(localize, currentCordinate));
		localize = nextlocate;
	}

	
    /**
     * This sets the gets the image of the bird to show on the view Image-view any time it is called.
     * It compares with the current view to the randomly chosen view and sets the view Image-view to be visible if true.
     * it also compares the current view to the view the bird putDown method was called, sets view to be visible if true.
     */
	private void getView() {
		putdownlocationConfirm = viewer.getImage();
		//setrand makes sure that once the random bird image is picked, its not viewed again.
		if ((viewer.getImage().equals(randombirdLocation)) && (setrand < 1)) {
			
				view.setVisible(true);	
		}	
		else if (putdownlocationConfirm.equals(putdownLocation) && !pickupLocation.equals(viewer.getImage())) {
			view.setVisible(true);
		}
		else
		{
			setView();
		}
	}
    /**
     * this sets the bird image to not be visible.
     * it sets the view Image-view to not diplay any time its called.
     */
	private void setView() {	
			view.setVisible(false);
	}
	/**
	 * this method sets the order of the game and prevents errors that could arise from user input.
	 * disables all control Interface until the user begins.
	 */
	private void movementerrorHandling() {
		
		if (accel == 0 ) {
			leftturn.setDisable(true);
			rightturn.setDisable(true);
			lookfront.setDisable(true);
			lookleft.setDisable(true);
			lookright.setDisable(true);
			lookback.setDisable(true);
			pickup.setDisable(true);
			putdown.setDisable(true);
		}
		else {
			//disables the accelerate button until the user is facing an exit.
			if (!localize.assertExit(viewer.getImage())) {
					accelerate.setDisable(true);
				}
			else {
				accelerate.setDisable(false);
			}
			if(randombirdLocation.equals(viewer.getImage())) {
				pickup.setDisable(false);
				putdown.setDisable(false);	
			}
			info.setText(null);
			leftturn.setDisable(false);
			rightturn.setDisable(false);
			
			
		}
	}
	
	/**
	 * this handles the direction in which you can check out the views of that particular location.
	 * also provides information about the current location whenever
	 *  the user is facing the normal direction of that location.
	 */
	private void viewerrorHandling() {
		
		if ((localize.equals(garage) || localize.equals(junction)) && direct.getDirect(localize, North).equals(viewer.getImage())) {
			if (localize.equals(garage)) {
				info.setText("You are at the Garage, up ahead is the Junction" );
			}
			if(localize.equals(junction)) {
				info.setText("You are at the Central Junction, Go left or right.");
			}
			lookfront.setDisable(false);
			lookleft.setDisable(false);
			lookright.setDisable(false);
			lookback.setDisable(false);
		}
		else if (localize.equals(rightjunction) && direct.getDirect(localize, East).equals(viewer.getImage())) {
			info.setText("You are at the Right Junction Location");
			lookfront.setDisable(false);
			lookleft.setDisable(false);
			lookright.setDisable(false);
			lookback.setDisable(false);
		}
		else if (localize.equals(leftjunction) && direct.getDirect(localize, West).equals(viewer.getImage())) {
			
			info.setText("You are at the Left Junction location");
			lookfront.setDisable(false);
			lookleft.setDisable(false);
			lookright.setDisable(false);
			lookback.setDisable(false);
		}
		else {
			
			lookfront.setDisable(true);
			lookleft.setDisable(true);
			lookright.setDisable(true);
			lookback.setDisable(true);
		}
	}
	
}

