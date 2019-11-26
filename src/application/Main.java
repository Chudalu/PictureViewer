package application;
	
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * This is the Main class of the WorldViewer application.
 * 
 * @author Chudalu Ezenwafor
 *@version 2017.11.23
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			String viewerFxml = "WorldViewer.fxml";
     		AnchorPane page = (AnchorPane)fxmlLoader.load(this.getClass().getResource(viewerFxml).openStream());
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			
			
			WorldViewer view = (WorldViewer) fxmlLoader.getController();
			view.Start();
			primaryStage.show();
			
		} 
		
		
		catch(IOException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
			System.exit(1);
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
