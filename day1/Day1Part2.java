package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) {
        try {
          File input = new File("day1/input.txt");
          PriorityQueue<Integer> topCalories = new PriorityQueue<Integer>((a, b) -> b - a);
          int currentMax = 0;
          Scanner inputReader = new Scanner(input);
          while (inputReader.hasNextLine()) {
            String data = inputReader.nextLine();
            if ("".equals(data)) {
							topCalories.add(currentMax);
              currentMax = 0;
            }
            else {
              currentMax += Long.parseLong(data);
            }
          }
          inputReader.close();
					int[] top3 = new int[]{topCalories.poll(), topCalories.poll(), topCalories.poll()};
					System.out.println(top3[0] + "," + top3[1] + "," + top3[2]);
          System.out.println(top3[0] + top3[1] + top3[2]);
        } catch (FileNotFoundException e) {
          System.out.println("Missing input.txt file.");
          e.printStackTrace();
        }
      }
}
