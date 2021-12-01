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
 *
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

    public void editMember(int id, String source) {
        File tempFile = new File("temp.csv");
        File file = new File(this.path);
        FileWriter fileWriter;
        Scanner scanner;


        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return;
        }

        try {
            fileWriter = new FileWriter(tempFile, true);
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                String[] memberArray = scanner.nextLine().split(",");
                int memberId = Integer.parseInt(memberArray[0]);

                if (id == memberId) {
                    fileWriter.write(source + "\n");
                } else {
                    fileWriter.write(scanner.nextLine());
                }
            }
            fileWriter.close();
        } catch (IOException ignored) {

        }

        scanner.close();
        boolean fileDeleted = file.delete();
        boolean fileRenamed = tempFile.renameTo(file);

        if (!fileDeleted) {
            System.out.println("old file not deleted");
        }
        if (!fileRenamed) {
            System.out.println("Temporary file not renamed to old file");
        }
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
        scanner.close();
        return members;
    }

    /**
     * If the folder already exists then it will not be created again
     */
    public void createFolder() {
        File file = new File(this.path);
        if (!file.exists()) {
            boolean test = file.mkdir();
            System.out.println(test);
        }
    }

    public void setPath(String path) {
        this.path = path;
    }
}
