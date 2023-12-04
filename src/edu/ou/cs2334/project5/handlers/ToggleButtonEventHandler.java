package edu.ou.cs2334.project5.handlers;

import edu.ou.cs2334.project5.models.NonogramMakerModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

/**
 * ToggleButtonEventHandler class
 * @author terriaunajames
 * implements EventHandler of type ActionEvent
 *
 */
public class ToggleButtonEventHandler implements EventHandler<ActionEvent>{

	/**
	 * Variable declarations
	 */
	private NonogramMakerModel model;
	private int rowIdx;
	private int colIdx;
	
	/**
	 * toggleButtonEventHandler constructor
	 * @param model given nonogram model
	 * @param rowIdx row index
	 * @param colIdx column index
	 * initializies instance variables
	 */
	public ToggleButtonEventHandler(NonogramMakerModel model, int rowIdx, int colIdx) {
		this.model = model;
		this.rowIdx = rowIdx;
		this.colIdx = colIdx;
	}
	
	/**
	 * handle method
	 * get current state of the toggle button
	 */
	public void handle(ActionEvent event) {
		ToggleButton tb = new ToggleButton();
		if(tb.isSelected()) {
			model.setCell(rowIdx, colIdx, tb.isSelected());
		}
		//GET CHECKED
	}
}
