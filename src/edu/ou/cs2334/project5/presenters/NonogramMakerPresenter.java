package edu.ou.cs2334.project5.presenters;

import java.io.File;
import java.io.IOException;

import edu.ou.cs2334.project5.handlers.OpenHandler;
import edu.ou.cs2334.project5.handlers.SaveHandler;
import edu.ou.cs2334.project5.handlers.ToggleButtonEventHandler;
import edu.ou.cs2334.project5.interfaces.Openable;
import edu.ou.cs2334.project5.interfaces.Saveable;
import edu.ou.cs2334.project5.models.NonogramMakerModel;
import edu.ou.cs2334.project5.views.NonogramMakerView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

/**
 * NonogramMakerPresenter class
 * @author terriaunajames
 * implements openable and saveable 
 *
 */
public class NonogramMakerPresenter implements Openable, Saveable{

	/**
	 * Variable declarations
	 */
	private NonogramMakerView view;
	private NonogramMakerModel model;
	private int cellLength;
	
	/**
	 * NonogramMakerPresenter constructor
	 * @param numRows number of rows
	 * @param numCols number of columns
	 * @param cellLength length of cell
	 * initializes 
	 * sets celllength
	 * and calls init method
	 */
	public NonogramMakerPresenter(int numRows, int numCols, int cellLength) {
		view = new NonogramMakerView(numRows, numCols, cellLength);
		model = new NonogramMakerModel(numRows,numCols);
		this.cellLength = cellLength;		
		init();
	}
	
	/**
	 * Window 
	 * @return
	 * returns the views panes scene window
	 */
	private Window getWindow() {
		try {
			return view.getPane().getScene().getWindow();
		}
		catch (NullPointerException e) {
			return null;
		}
	}
	
	/**
	 * init method
	 * initializes the toggle buttons
	 * binds the buttons to the model
	 * configures the menu items
	 */
	private void init() {
		initToggleButtons();
		bindToggleButtons();
		configureMenuItems();
	}
	
	/**
	 * initToggleButtons method
	 * calls the view init buttons
	 * 
	 */
	private void initToggleButtons() {
		view.initButtons(model.getNumRows(), model.getNumCols(), cellLength);
		if(getWindow() != null) {
			getWindow().sizeToScene();
		}
	}
	
	/**
	 * bindToggleButton method
	 * makes sure the view toggle button selected 
	 * matches the models cell state
	 */
	private void bindToggleButtons() {
		
		int rows = view.getNumRows();
		int cols = view.getNumCols();
		
		for(int rowIdx = 0; rowIdx < rows; rowIdx++) {
			for(int colIdx = 0; colIdx < cols; colIdx++) {
				
				ToggleButton tb = view.getToggleButton(rowIdx, colIdx);
				
				tb.setSelected(model.getCell(rowIdx, colIdx));
				tb.setOnAction(new ToggleButtonEventHandler(model, rowIdx,colIdx));
			}
		}
	}
	
	/**
	 * configureMenuItems
	 * sets the event handler for the open and save buttons
	 */
	private void configureMenuItems() {
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		fileChooser.setInitialDirectory(new File("."));
		view.getMenuItem(NonogramMakerView.MENU_ITEM_OPEN)
		    .setOnAction(new OpenHandler(getWindow(), fileChooser, this));
		
		FileChooser fileChooserTwo = new FileChooser();
		fileChooserTwo.setTitle("Save");
		fileChooserTwo.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		fileChooserTwo.setInitialDirectory(new File("."));
		view.getMenuItem(NonogramMakerView.MENU_ITEM_SAVE)
		    .setOnAction(new SaveHandler(getWindow(), fileChooserTwo, this));
	}
	
	/**
	 * getPane method
	 * @return
	 * the view pane
	 */
	public Pane getPane() {
		return view.getPane();
	}
	
	/**
	 * open method
	 * re initialize the model variable
	 * calls the init method
	 */
	public void open(File file) {
		try {
			model = new NonogramMakerModel(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();		
	}
	
	/**
	 * save method
	 * calls models save to file method
	 */
	public void save(String filename) {
		try {
			model.saveToFile(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
