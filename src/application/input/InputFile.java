package application.input;

import java.io.*;
import java.util.ArrayList;

public class InputFile {
    /**
     * Parse input file and return list of paths
     *
     * @param File
     * @return ArrayList<String>
     * @throws FileNotFoundException
     */
    public ArrayList<String> parseInputFile(String File)
            throws FileNotFoundException {
        InputStreamReader inputFile = new InputStreamReader(
                new FileInputStream(File));
        BufferedReader bufRead = new BufferedReader(inputFile);
        String line;
        ArrayList<String> listOfPaths = new ArrayList<String>();
        int indexOfArray = 0;
        try {
            while ((line = bufRead.readLine()) != null) {
                listOfPaths.add(indexOfArray, line);
                indexOfArray++;
            }
            bufRead.close();
        } catch (IOException ex) {
            System.out.println("IO Exception " + ex);
        }
        return listOfPaths;
    }
}
