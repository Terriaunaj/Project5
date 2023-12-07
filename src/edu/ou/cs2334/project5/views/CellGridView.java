package edu.ou.cs2334.project5.views;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
/**
 * Cellgridview class
 * @author terriaunajames
 *
 */
public class CellGridView {

	private ArrayList<ToggleButton> gridButtons;
	private GridPane gridPane;
	private int numRows;
	private int numCols;
	
	/**
	 * CellGridView constructor
	 * @param numRows number of rows
	 * @param numCols number of columns
	 * @param cellLength
	 * initializes row,col,celllength
	 * sets alignment to pos center
	 * initializes togglebuttons
	 */
	public CellGridView(int numRows, int numCols, int cellLength) {
		this.numRows = numRows;
		this.numCols = numCols;
		
		gridButtons = new ArrayList<ToggleButton>();
		gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		
		initButtons(numRows,numCols,cellLength);
	}
	
	/**
	 * initButtons
	 * @param numRows number of rows
	 * @param numCols number of columns
	 * @param cellLength the length of the cell
	 * creates buttons according to the given parameters
	 */
	public void initButtons(int numRows, int numCols, int cellLength) {
		this.numRows = numRows;
		this.numCols = numCols;
		
		gridButtons.clear();
		gridPane.getChildren().clear();
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
			
				ToggleButton tb = new ToggleButton();
				
				tb.setMaxWidth(cellLength);
				tb.setMinWidth(cellLength);
				tb.setPrefWidth(cellLength);
				
				tb.setMaxHeight(cellLength);
				tb.setMinHeight(cellLength);
				tb.setPrefHeight(cellLength);
				
				gridButtons.add(tb);
				gridPane.add(tb, j, i);
			}
		}
	}
	/**
	 * getNumRows
	 * @return
	 * number of rows
	 */
	public int getNumRows() {
		return numRows;
	}
	/**
	 * getNumCols
	 * @return
	 * number of columns
	 */
	public int getNumCols() {
		return numCols;
	}
	/**
	 * getTogglebutton
	 * @param row number
	 * @param col number
	 * @return
	 * togglebutton with given row and col
	 */
	public ToggleButton getToggleButton(int row, int col) {
		return gridButtons.get(row*this.numCols+col);
	}
	/**
	 * getPane
	 * @return
	 * gridPane
	 */
	public Pane getPane() {
		return gridPane;
	}
}
