package edu.ou.cs2334.project5.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * NonogramMakerModel class
 * @author terriaunajames
 *
 */
public class NonogramMakerModel {

	/**
	 * Variable declarations
	 * 
	 */
	private static final char EMPTY_CELL_CHAR = '0';
	private static final char FILLED_CELL_CHAR = '1';
	private int numRows;
	private int numCols;
	private boolean[] grid;
	
	/**
	 * 
	 * @param numRows number of rows
	 * @param numCols number of columns
	 * NonogramMakerModel constructor int,int
	 * Creates boolean array with total number of rows and columns
	 */
	public NonogramMakerModel(int numRows, int numCols) throws IllegalArgumentException{
		
		if(numRows <= 0 || numCols <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.numRows = numRows;
		this.numCols = numCols;
		grid = new boolean[numRows*numCols];
	}
		
	/**
	 * 
	 * @param file given file
	 * @throws IOException 
	 * Creates nonogram with file
	 */
	public NonogramMakerModel(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
			
		try {
			
			line = br.readLine();
			String[] dimension = line.split(" ");
			int rowNum = Integer.parseInt(dimension[0]);
			int colNum = Integer.parseInt(dimension[1]);
			this.numRows = rowNum;
			this.numCols = colNum;
			
			if(rowNum > 0 && colNum > 0) {
				grid = new boolean[rowNum*colNum];
			}	
			else {
				throw new IllegalArgumentException();
			}
			int ind = rowNum + colNum;
			
			for(int i = 0; i < ind; i ++) {
				br.readLine();
			}
			for(int i = 0; i < rowNum; i++) {
				line = br.readLine();
				char[] values = line.toCharArray();
				for(int j = 0; j < colNum; j++) {
					if(Character.compare(values[j], EMPTY_CELL_CHAR) == 0) {
						grid[i*colNum + j] = false;
					}
					else if(Character.compare(values[j], FILLED_CELL_CHAR) == 0) {
						grid[i*colNum + j] = true;
					}
				}
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	/**
	 * 
	 * @param filename given filename
	 * @throws IOException
	 * NonogramMakerModel constructor filename
	 */
	public NonogramMakerModel(String filename) throws IOException {
		this(new File(filename));
	}
	
	/**
	 * getGrid method
	 * @return
	 * copy of grid array
	 * 
	 */
	public boolean[] getGrid() {
		return Arrays.copyOf(grid, grid.length);
		}
		
	/**
	 * getCell method
	 * @param rowIdx row index
	 * @param colIdx column index
	 * @return
	 * cell state at index
	 */
	public boolean getCell(int rowIdx, int colIdx) {
		return grid[rowIdx*numCols+colIdx];
	}
		
	/**
	 * setCell method
	 * @param rowIdx row index
	 * @param colIdx column index
	 * @param state true or false
	 * Updates the state of the cell
	 */
	public void setCell(int rowIdx, int colIdx, boolean state) {
			
		grid[rowIdx*numCols+colIdx] = state;
	}
		
	/**
	 * getNumRows method
	 * @return
	 * number of rows
	 */
	public int getNumRows() {
		return numRows;
		}
		
	/**
	 * getNumCols method
	 * @return
	 * number of columns
	 */
	public int getNumCols() {
		return numCols;
		}
	
	/**
	 * project method
	 * @param cells boolean array of cell states
	 * @return
	 * an integer list of the Nonogram numbers
	 */
	public static List<Integer> project(boolean[] cells){
			
		List<Integer> nonoNum = new ArrayList<>();
			
		int count = 0;
		for(int i = 0; i < cells.length; i++) {	
			if(cells[i] == true) {
				count++;
			}
			if(cells[i] == false && count > 0) {
				nonoNum.add(count);
				count = 0;
			}
		}
		if(count == 0 && nonoNum.size() == 0) {
			nonoNum.add(0);
		}
		else if (cells[cells.length-1] == true) {
			nonoNum.add(count);
		}
			return nonoNum;
		}
		
	/**
	 * projectRow method
	 * @param rowIdx row index
	 * @return
	 * the nonogram numbers in the row at the given index
	 */
	public List<Integer> projectRow(int rowIdx){
			
		boolean[] rowPro = new boolean[numCols];
		for(int i = 0; i < numCols ; i++) {
			rowPro[i] = getCell(rowIdx, i);
		}
		return project(rowPro);
	}
		
	/**
	 * projectCol method
	 * @param colIdx column index
	 * @return
	 * the nonogram numbers in the column at the given index
	 */
	public List<Integer> projectCol(int colIdx){
		
		boolean[] colPro = new boolean[numRows];
		for(int i = 0; i < numRows ; i++) {
			colPro[i] = getCell(i, colIdx);
		}
		return project(colPro);
	}
		
	/**
	 * saveToFile method
	 * @param filename given filename
	 * @throws IOException
	 * saves the output of the toString method
	 */
	public void saveToFile(String filename) throws IOException {
			
		File file = new File(filename);	
		FileWriter writer = new FileWriter(file);
		writer.write(toString());	
		writer.close();
	}
		
	/**
	 * toString method
	 * returns a string representation of the puzzle
	 */
	public String toString() {
		
		ArrayList<String> lines = new ArrayList<String>();
		String s = Integer.toString(getNumRows()) + " " + Integer.toString(getNumCols()) + System.lineSeparator();
		lines.add(s);
		
		for(int i = 0; i < numRows; i++) {
			
			lines.add(projectRow(i).toString().replaceAll("[\\[\\],]","").trim() + System.lineSeparator());
		}
		for(int i = 0; i < numCols; i++) {
			lines.add(projectCol(i).toString().replaceAll("[\\[\\],]","").trim() + System.lineSeparator());
		}
		
		for(int i = 0; i < numRows; i++) {
			ArrayList<String> values = new ArrayList<String>();
			for(int j = 0; j < numCols; j++) {
				if(getCell(i,j) == false) {
					String f = "0";
					values.add(f);
				}
				else if (getCell(i,j) == true) {
					String t = "1";
					values.add(t);
				}
			}
			lines.add(values.toString().replaceAll("[\\[\\],]\\s","").trim());
		}
		
		String result = "";
		for(int i = 0; i < lines.size(); i++) {
			result += lines.get(i).trim().replaceAll("[\\[\\],]","");
			if(i != lines.size() - 1) result += System.lineSeparator();
		}
		
		return result;
	}	
}
