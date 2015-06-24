package application.counter;

import application.input.KeyListener;
import application.output.OutputFile;

public class Main {
	
	public static void main(String[] args) {
		// get program arguments
		String input = args[0];
		String output = args[1];
		
		// clear .csv file
		OutputFile.clearCSV(output);
	
		// create key listener in thread
		Thread keyListener = new Thread(new KeyListener());
		keyListener.start();
		
		ApplicationLogic appLogic = new ApplicationLogic(input, output);
		appLogic.createThreadsForCountFiles();
	}
}
