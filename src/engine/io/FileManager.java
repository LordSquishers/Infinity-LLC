package engine.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    //TODO- comment this code

    public static final String DATA_FOLDER_LOCATION = "infinity-data";
    public static final String DATA_FILE_EXT = ".ifn";

    /**
     * Reads the given file and gives you the data
     * @param filename File name of the file
     * @return ArrayList of the lines
     */
    public List<String> readFile(String filename) {
        List<String> input = new ArrayList<>();

        try {
            //Initiating variables
            FileReader fileReader = new FileReader(new File(DATA_FOLDER_LOCATION + "/" + filename + DATA_FILE_EXT));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //File reading
            String currentLine;
            while((currentLine = bufferedReader.readLine()) != null) {
                input.add(currentLine);
            }

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("[ERROR] Could not read file " + filename + ".ifn");
        }

        return input;
    }

    /**
     * Simple way to check if the file exists
     * @param filename Filename
     * @return if the file exists
     */
    public boolean doesFileExist(String filename) {
        return new File(DATA_FOLDER_LOCATION + "/" + filename + DATA_FILE_EXT).exists();
    }

    /**
     * Writes to a file. Be sure to use the return value to ensure proper code.
     * @param filename filename
     * @param text text to write
     * @return if the writing was a success
     */
    public boolean writeToFile(String filename, List<String> text, boolean overwrite) {
        boolean success = false; // end result variable

        File file = new File(DATA_FOLDER_LOCATION + "/" + filename + DATA_FILE_EXT);
        File saveDirectory = new File(DATA_FOLDER_LOCATION);

        boolean fileExists = file.exists();
        List<String> existingData = new ArrayList<>();

        //If this file exists, read the data already existing
        if(!overwrite && fileExists) existingData = readFile(filename);

        try {
            //If there is no directory, make a directory
            if(!saveDirectory.exists()) saveDirectory.mkdirs();

            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            //If there was data in the file, write the old data back into the file
            if(!overwrite && fileExists) {
                for(String line: existingData) printWriter.println(line);
            }

            //Prints the new data to the file
            for(String line: text) printWriter.println(line);

            printWriter.close();
            success = true;
        } catch (IOException e) {
            System.err.println("[ERROR] Could not write to file " + filename + ".ifn");
        }

        return success;
    }

}
