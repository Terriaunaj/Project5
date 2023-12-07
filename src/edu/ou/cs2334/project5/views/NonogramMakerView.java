package edu.ou.cs2334.project5.views;

import java.util.HashMap;

import edu.ou.cs2334.project5.views.CellGridView;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
/**
 * NonogramMakerView class
 * @author terriaunajames
 *
 */
public class NonogramMakerView {

	/**
	 * Variable declarations
	 */
	private BorderPane borderPane;
	private MenuBar menuBar;
	private CellGridView cellGridView;
	private HashMap<String, MenuItem> menuItemsMap;
	
	/**
	 * Variable declarations
	 */
	public static String MENU_ITEM_OPEN = "MENU_ITEM_OPEN";
	/**
	 * Variable declarations
	 */
	public static String MENU_ITEM_SAVE = "MENU_ITEM_SAVE";
	/**
	 * Variable declarations
	 */
	public static String MENU_ITEM_EXIT = "MENU_ITEM_EXIT";
	
	/**
	 * NonogramMakerView constructor
	 * @param numRows number of rows
	 * @param numCols number of columns
	 * @param cellLength length of cell
	 * initializes the border pane, cellgrid, and menubar
	 * sets the top and center of border pane
	 */
	public NonogramMakerView(int numRows, int numCols, int cellLength) {
		borderPane = new BorderPane();
		cellGridView = new CellGridView(numRows, numCols, cellLength);
		menuItemsMap  = new HashMap<String,MenuItem>();
		initMenuBar();
		borderPane.setTop(menuBar);
		borderPane.setCenter(cellGridView.getPane());
	}
	
	/**
	 * initMenuBar
	 * makes menu and adds items to menu and menu map
	 * then adds to menu bar
	 */
	private void initMenuBar() {
		Menu menu = new Menu("_File");
		
		MenuItem item1 = new MenuItem("_Open");
		MenuItem item2 = new MenuItem("_Save");
		MenuItem item3 = new MenuItem("_Exit");
		
		menu.getItems().addAll(item1,item2,item3);
		
		menuItemsMap.put(MENU_ITEM_OPEN,item1);
		menuItemsMap.put(MENU_ITEM_SAVE, item2);
		menuItemsMap.put(MENU_ITEM_EXIT, item3);
		
		item3.setOnAction(event -> Platform.exit());
		
		menuBar = new MenuBar(menu);
	}
	/**
	 * get menu item
	 * @param name given string name
	 * @return
	 * item with given name
	 */
	public MenuItem getMenuItem(String name) {
		return menuItemsMap.get(name);
	}
	/**
	 * get pane
	 * @return
	 * border pane
	 */
	public Pane getPane() {
		
		return borderPane;
	}
	/**
	 * init buttons
	 * @param numRows on cell grid
	 * @param numCols on cell grid
	 * @param cellLength on cell grid
	 */
	public void initButtons(int numRows, int numCols, int cellLength) {
		cellGridView.initButtons(numRows, numCols, cellLength);;
	}
	
	/**
	 * get toggle button
	 * @param row on cell grid
	 * @param col on cell grid
	 * @return
	 * togglebutton on cell grid at given row and col
	 */
	public ToggleButton getToggleButton(int row, int col) {
		return cellGridView.getToggleButton(row, col);
	}
	
	/**
	 * get number of rows
	 * @return
	 * number of rows on cell grid
	 */
	public int getNumRows() {
		return cellGridView.getNumRows();
	}
	
	/**
	 * get number of columns
	 * @return
	 * number of columns on cellgrid
	 */
	public int getNumCols() {
		return cellGridView.getNumCols();
	}
}
