package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day3Part1 {
    static String PRIORITIES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static HashMap<Character, Integer> CODE_TO_PRIORITY = new HashMap<Character, Integer>(){{
        for (int i = 0; i < PRIORITIES.length(); i++) {
            put(PRIORITIES.charAt(i), i+1);
        }
    }};

    public static void main(String[] args) {
        try {
            File input = new File("day3/input.txt");
            long sum = 0;
            Scanner inputReader = new Scanner(input);
            while (inputReader.hasNextLine()) {
                String data = inputReader.nextLine();
                HashSet<Character> backpack1 = getBackpackItems(data.substring(0, data.length() / 2));
                HashSet<Character> backpack2 = getBackpackItems(data.substring(data.length() / 2));
                List<Character> common = backpack1.stream().filter(backpack2::contains).collect(Collectors.toList());
                if (common.size() == 0) System.err.println("No common items found.");
                sum += CODE_TO_PRIORITY.get(common.get(0));
            }
            inputReader.close();
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("Missing input.txt file.");
            e.printStackTrace();
        }
    }

    static HashSet<Character> getBackpackItems(String data) {
        ArrayList<Character> backpackItems = data.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(ArrayList::new));
        HashSet<Character> backpack = new HashSet<Character>(backpackItems);
        return backpack;
    }
}