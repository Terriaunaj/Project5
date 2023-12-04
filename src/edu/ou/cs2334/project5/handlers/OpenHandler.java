package edu.ou.cs2334.project5.handlers;

import java.io.File;

import edu.ou.cs2334.project5.interfaces.Openable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * Openhandler class
 * @author terriaunajames
 * extends the abstract base handler
 * implements eventhandler of type actionevent
 */
public class OpenHandler extends AbstractBaseHandler implements EventHandler<ActionEvent>{

	private Openable opener;
	
	/**
	 * OpenHandler constructor
	 * @param window from abstract base handler
	 * @param fileChooser from abstract base handler
	 * @param opener used to help open file with the openable interface
	 */
	public OpenHandler(Window window, FileChooser fileChooser, Openable opener) {
		super(window,fileChooser);
		this.opener = opener;
	}

	@Override
	/**
	 * Used to show user an open dialog and if not null open file
	 */
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		File f = fileChooser.showOpenDialog(window);
		if(f != null) {
			opener.open(f);
		}
	}
	
}
