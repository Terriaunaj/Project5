package edu.ou.cs2334.project5;



import java.util.List;

import edu.ou.cs2334.project5.presenters.NonogramMakerPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class
 * 
 * @author terriaunajames Extends Application
 */
public class Main extends Application {

	/**
	 * variable declaration
	 */
	private static final int IDX_NUM_ROWS = 0;
	private static final int IDX_NUM_COLS = 1;
	private static final int IDX_CELL_SIZE = 2;

	/**
	 * main method
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	/**
	 * Start method Starts the application
	 */
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
//		List<String> stuff = getParameters().getRaw();
//		int numRows = Integer.parseInt(stuff.get(IDX_NUM_ROWS));
//		int numCols = Integer.parseInt(stuff.get(IDX_NUM_COLS));
//		int cellSize = Integer.parseInt(stuff.get(IDX_CELL_SIZE));

		NonogramMakerPresenter nano = new NonogramMakerPresenter(10, 10, 50);

		Scene scene = new Scene(nano.getPane());
		primaryStage.setScene(scene);
		scene.getStylesheets().add("style.css");

		primaryStage.setTitle("style.css");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
