package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WorkHours {


    public String minWork(String s) throws IOException {
        Path path = Path.of(s);
        int minLineIndex = 0;
        int hours = Integer.MAX_VALUE;
        String result = "";
        List<String> lines = Files.readAllLines(path);
        for (int i = 0; i < lines.size(); i++){
            String[] parts = lines.get(i).split(",");
            if (Integer.parseInt(parts[1]) < hours){
                hours = Integer.parseInt(parts[1]);
                minLineIndex = i;
            }
        }
        String[] minLineParts = lines.get(minLineIndex).split(",");
        result = minLineParts[0] + ": " + minLineParts[2];
        return result;
    }

    public static void main(String[] args) throws IOException {
        WorkHours workHours = new WorkHours();
        String result = workHours.minWork("src/test/resources/hu/nive/ujratervezes/zarovizsga/workhours/workhours.txt");
        System.out.println(result);
    }
}

