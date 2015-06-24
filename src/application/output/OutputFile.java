package application.output;

import application.counter.ApplicationLogic;
import application.counter.CounterFiles;
import com.csvreader.CsvWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFile {
    /**
     * Clear .csv file
     *
     * @param outputFile
     * @return void
     * @exception IOException
     */
    public static void clearCSV(String outputFile) {
        try {
            FileWriter fstream = new FileWriter(outputFile);
            BufferedWriter bufstream = new BufferedWriter(fstream);
            bufstream.write("");
            bufstream.close();
        } catch (IOException ex) {
            System.out.println("File not found " + ex);
        }
    }

    /**
     * Write paths and counted the number of files to .csv file
     * @param counter
     */
    public static void writeCsvFile(CounterFiles counter) {
        try {
            CsvWriter csvOutput = new CsvWriter(new FileWriter(ApplicationLogic.getOutFile(), true), ';');
            csvOutput.write(counter.getPath());
            csvOutput.write(Integer.toString(counter.getCountedFiles()));
            csvOutput.endRecord();
            csvOutput.close();
        } catch (IOException e) {
            System.out.println("IOException" + e);
        }
    }
}
