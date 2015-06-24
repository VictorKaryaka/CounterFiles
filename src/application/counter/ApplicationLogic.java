package application.counter;

import application.input.InputFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationLogic {

    private static InputFile inFile;
    private static String outFile;

    // folder path
    private String path;

    private List<Thread> counterThreads;

    // flag of count completion
    private static boolean interrupt = false;

    public static boolean isInterrupt() {
        return interrupt;
    }

    public static void setInterrupt(boolean interrupt) {
        ApplicationLogic.interrupt = interrupt;
    }

    public static String getOutFile() {
        return outFile;
    }

    public ApplicationLogic(final String inputPaths, final String outFile) {
        inFile = new InputFile();
        this.path = inputPaths;
        this.counterThreads = new ArrayList<Thread>();
        ApplicationLogic.outFile = outFile;
    }

    public void createThreadsForCountFiles() {
        try {
            int numberOfSequence = 0;
            // if the input file is empty
            if (inFile.parseInputFile(path).size() == 0) {
                System.out.println("No paths");
                return;
            }
            for (String path : inFile.parseInputFile(this.path)) {
                numberOfSequence++;
                counterThreads.add(new Thread(new CounterFiles(
                        numberOfSequence, path), path));
            }

            // starting threads
            for (Thread thread : counterThreads) {
                thread.start();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException " + ex);
        }
    }
}
