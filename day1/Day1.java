package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
  public static void main(String[] args) {
    try {
      File input = new File("day1/input.txt");
      long max = 0, currentMax = 0;
      Scanner inputReader = new Scanner(input);
      while (inputReader.hasNextLine()) {
        String data = inputReader.nextLine();
        if ("".equals(data)) {
          max = Math.max(max, currentMax);
          currentMax = 0;
        }
        else {
          currentMax += Integer.parseInt(data);
        }
      }
      inputReader.close();
      System.out.println(max);
    } catch (FileNotFoundException e) {
      System.out.println("Missing input.txt file.");
      e.printStackTrace();
    }
  }
}