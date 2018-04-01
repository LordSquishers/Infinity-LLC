package engine.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple file API for easy file management.
 * @author BrusselSprout
 */
public class FileManager {

    //this code will only deal with the save data and not resources.
    public static final String DATA_FOLDER_LOCATION = "infinity-data/saves";
    public static final String DATA_FILE_EXT = ".ifn";

    /**
     * Reads the given file and gives you the data
     * @param filename File name of the file
     * @return ArrayList of the lines
     */
    public static List<String> readFile(String filename) {
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
            System.err.println("[ERROR] Could not read file " + filename + DATA_FILE_EXT);
        }

        return input;
    }

    /**
     * Simple way to check if the file exists
     * @param filename Filename
     * @return if the file exists
     */
    public static boolean doesFileExist(String filename) {
        return new File(DATA_FOLDER_LOCATION + "/" + filename + DATA_FILE_EXT).exists();
    }

    /**
     * Writes to a file. Be sure to use the return value to ensure proper code.
     * @param filename filename
     * @param text text to write
     * @return if the writing was a success
     */
    public static boolean writeToFile(String filename, List<String> text, boolean overwrite) {
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
            System.err.println("[ERROR] Could not write to file " + filename + DATA_FILE_EXT);
        }

        return success;
    }

    /**
     * Deletes a given file.
     * @param fileName file to delete
     * @return whether or not the deletion was a success.
     */
    public static boolean deleteFile(String fileName) {
        //Using File to delete the file.
        File file = new File(DATA_FOLDER_LOCATION + "/" + fileName + DATA_FILE_EXT);
        return file.delete();
    }

    /**
     * Lists all files contained in a directory (includes sub-directories)
     * @author StackOverflow
     * @param folderPath the path of the folder
     * @return a list of file names. (with extensions)
     */
    public static List<String> listFilesForFolder(String folderPath) {
        List<String> files = new ArrayList<>();
        File folder = new File(folderPath);

        //Iterates through all files
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry.getPath());
            } else {
                files.add(fileEntry.getName());
            }
        }

        return files;
    }

}
