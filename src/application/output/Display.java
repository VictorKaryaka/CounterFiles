package application.output;

import application.counter.ApplicationLogic;
import application.counter.CounterFiles;
import java.util.Formatter;

public class Display {

	static {
		Formatter fmt = new Formatter();
		System.out.println("<<< WELCOME TO COUNTER FILES >>>");
		System.out.println("Press <Esc> to cancel");
		System.out.println("Press  <Q>  to exit");
		System.out
				.println("--------------------------------------------------------");
		fmt.format("%-4s| %-10s| %-21s ", "#", "Number of files", "Paths");
		System.out.println(fmt);
		System.out
				.println("--------------------------------------------------------");
		fmt.close();
	}

	public static void showResults(CounterFiles counter) {
		Formatter fmt = new Formatter();
		if (ApplicationLogic.isInterrupt() == false) {
			fmt.format("%-4d| %-15d| %-22s", counter.getSequenceNumber(),
					counter.getCountedFiles(), counter.getPath());
			System.out.println(fmt);
		} else {
			fmt.format("%-4d| %-15d| %-22s %-10s", counter.getSequenceNumber(),
					counter.getCountedFiles(), counter.getPath(), "Cancelled");
			System.out.println(fmt);
		}
		fmt.close();
	}
}
