package edu.ou.cs2334.project5.handlers;

import java.io.File;

import edu.ou.cs2334.project5.interfaces.Saveable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Window;
/**
 * Savehandler class
 * @author terriaunajames
 * extends the abstract base handler
 * implements eventhandler of type actionevent
 *
 */
public class SaveHandler extends AbstractBaseHandler implements EventHandler<ActionEvent>{

	private Saveable saver;
	
	/**
	 * Savehandler constructor
	 * @param window from abstract base handler
	 * @param fileChooser from abstract base handler
	 * @param saver used to help save file with the saveable interface
	 * 
	 */
	public SaveHandler(Window window, FileChooser fileChooser, Saveable saver) {
		super(window,fileChooser);
		this.saver = saver;
	}
	 
	@Override
	/**
	 * Used to show user a save dialog and if not null save file as string
	 */
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		File f = fileChooser.showSaveDialog(window);
		if(f != null) {
			saver.save(f.toString());
		}

	}
}
