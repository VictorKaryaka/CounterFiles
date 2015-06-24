package application.counter;

import java.io.File;

import application.output.Display;
import application.output.OutputFile;

public class CounterFiles implements Runnable {

    // path to folder
    private String path;

    // sequence number of path
    private int sequenceNumber;

    // number of counted files
    private int countedFiles;

    public String getPath() {
        return path;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public int getCountedFiles() {
        return countedFiles;
    }

    public CounterFiles(final int sequenceNumber, final String path) {
        this.sequenceNumber = sequenceNumber;
        this.path = path;
    }

    @Override
    public void run() {
        numberOfFiles(path);
        Display.showResults(this);
        OutputFile.writeCsvFile(this);
    }

    /**
     * Counts the number of files
     *
     * @param Path
     * @return Integer
     */
    private Integer numberOfFiles(final String Path) {
        File file = new File(Path);
        File[] files = file.listFiles();

        for (File path : files) {
            if (ApplicationLogic.isInterrupt() == true) {
                break;
            }
            if (path.isDirectory()) {
                numberOfFiles(path.getPath());
            }
            if (path.isFile()) {
                countedFiles++;
            }
        }
        return countedFiles;
    }
}
