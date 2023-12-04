package edu.ou.cs2334.project5.handlers;

import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * abstractbasehandler class
 * @author terriaunajames
 * general handler for file selection
 */
public class AbstractBaseHandler {

	protected Window window;
	protected FileChooser fileChooser;
	
	/**
	 * AbstractBaseHandler constructor
	 * @param window assigned to given window
	 * @param fileChooser assigned to given filechooser
	 * 
	 */
	protected AbstractBaseHandler(Window window, FileChooser fileChooser) {
		this.window = window;
		this.fileChooser = fileChooser;
	}
}
