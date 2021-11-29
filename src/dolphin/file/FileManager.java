package dolphin.file;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * used to write and read members from a specified file
 * @author David
 */
public class FileManager {
    private String path;

    public FileManager(String path) {
        this.path = path;
    }

    /**
     * @param source the string that will be written to a file, each white space will be replaced by a comma
     * @param append a boolean value that determines if the source should be added to the file or overwrite the file
     * @return a boolean, true if the file was created and false if not
     */
    private boolean writeToCsv(String source, boolean append) {
        String[] path = this.path.split("/");
        File file = new File(this.path);
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(file, append);
            //joins an array that is split with " " together with an ","
            String toFile = String.join(",", source.split("\s+"));

            fileWriter.write(toFile + "\n");
            //The fileWriter instance has to close() after having write() for it to actually write to a file
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * @param source the string that will be written to a file, each white space will be replaced by a comma
     * @return a boolean, true if the file was created and false if not
     */
    public boolean writeLineToCsv(String source) {
        return this.writeToCsv(source, true);
    }

    /**
     * @param source the string that will be written to a file, each white space will be replaced by a comma
     * @return a boolean, true if the file was created and false if not
     */
    public boolean overwriteFile(String source) {
        return this.writeToCsv(source, false);
    }

    /**
     * @return all the members from the file, each member is represented as a string array inside an ArrayList
     */
    public ArrayList<String[]> readLinesFromCsv() {
        File file = new File(this.path);
        Scanner scanner;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return null;
        }

        ArrayList<String[]> members = new ArrayList<>();

        while (scanner.hasNextLine()) {
            members.add(scanner.nextLine().split(","));
        }
        return members;
    }

    public boolean createFolder() {
        File file = new File(this.path);
        boolean dirCreated = file.mkdir();
        System.out.println(dirCreated);
        return dirCreated;
    }
}
