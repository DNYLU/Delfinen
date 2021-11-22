package dolphin;

import java.io.File;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;

//David
public class FileManager {
    private String path;

    public FileManager(String path) {
        this.path = path;
    }

    private boolean writeToCsv(String source, boolean append) {
        File file = new File(this.path);
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(file, append);
            //joins an array that is split with " " together with an ","
            String toFile = String.join(",", source.split("\s+"));

            fileWriter.write(toFile);
            //The fileWriter instance has to close() after having write() for it to actually write to a file
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean writeLineToCsv(String source) {
        return this.writeToCsv(source, true);
    }

    public boolean overWriteFile(String source) {
        return this.writeToCsv(source, false);
    }

    public ArrayList<String[]> readMembersFromCsv() {
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
}
