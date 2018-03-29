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
            FileReader fileReader = new FileReader(new File(DATA_FOLDER_LOCATION + "/" + filename + DATA_FILE_EXT));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

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
     * Writes to a file
     * @param filename filename
     * @param text text to write
     * @return if the writing was a success
     */
    public boolean writeToFile(String filename, List<String> text, boolean overwrite) {
        File file = new File(DATA_FOLDER_LOCATION + "/" + filename + DATA_FILE_EXT);
        File saveDirectory = new File(DATA_FOLDER_LOCATION);

        boolean success = false;
        boolean fileExists = file.exists();
        List<String> existingData = new ArrayList<>();

        if(!overwrite && fileExists) existingData = readFile(filename);

        try {
            if(!saveDirectory.exists()) saveDirectory.mkdirs();

            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            if(!overwrite && fileExists) {
                for(String line: existingData) printWriter.println(line);
            }

            for(String line: text) printWriter.println(line);

            printWriter.close();
            success = true;
        } catch (IOException e) {
            System.err.println("[ERROR] Could not write to file " + filename + ".ifn");
        }

        return success;
    }

}
