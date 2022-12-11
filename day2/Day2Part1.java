package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2Part1 {

    static final Map<String, Integer> LINE_VALUES = new HashMap<String, Integer>(){{
        put("A X", 3);
        put("A Y", 6);
        put("A Z", 0);
        put("B X", 0);
        put("B Y", 3);
        put("B Z", 6);
        put("C X", 6);
        put("C Y", 0);
        put("C Z", 3);
    }};

    static final Map<String, Integer> SHAPE_VALUES = new HashMap<String, Integer>(){{
        put("X", 1);
        put("Y", 2);
        put("Z", 3);
    }};

    public static void main(String[] args) {
        try {
            File input = new File("day2/input.txt");
            long totalScore = 0;
            Scanner inputReader = new Scanner(input);
            while (inputReader.hasNextLine()) {
                String data = inputReader.nextLine();
                totalScore += LINE_VALUES.get(data);
                totalScore += SHAPE_VALUES.get(data.substring(2, 3));
            }
            inputReader.close();
            System.out.println(totalScore);
        } catch (FileNotFoundException e) {
            System.out.println("Missing input.txt file.");
            e.printStackTrace();
        }
    }

}
