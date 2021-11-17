import java.io.File;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;

public class FileManager {
    private String path;

    public FileManager(String path) {
        this.path = path;
    }

    public boolean writeLineToCsv(String source) {
        File file = new File(this.path);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            //joins an array that is split with " " together with an ","
            String toFile = String.join(",", source.split(" "));

            fileWriter.write(toFile);
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }

        return true;
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
