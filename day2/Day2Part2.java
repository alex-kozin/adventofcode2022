package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2Part2 {

    static enum Shape {
        ROCK, PAPER, SCISSORS
    };

    static final Map<String, Shape> TO_SHAPE = new HashMap<String, Shape>() {
        {
            put("A", Shape.ROCK);
            put("B", Shape.PAPER);
            put("C", Shape.SCISSORS);
        }
    };

    static final Map<Shape, Integer> SHAPE_VALUES = new HashMap<Shape, Integer>() {
        {
            put(Shape.ROCK, 1);
            put(Shape.PAPER, 2);
            put(Shape.SCISSORS, 3);
        }
    };

    static final Map<String, Integer> OUTCOME_VALUES = new HashMap<String, Integer>() {
        {
            put("X", 0);
            put("Y", 3);
            put("Z", 6);
        }
    };

    static final Map<Shape, Shape> WINS_SHAPE = new HashMap<Shape, Shape>() {
        {
            put(Shape.ROCK, Shape.SCISSORS);
            put(Shape.PAPER, Shape.ROCK);
            put(Shape.SCISSORS, Shape.PAPER);
        }
    };

    static final Map<Shape, Shape> LOOSES_TO_SHAPE = new HashMap<Shape, Shape>() {
        {
            put(Shape.ROCK, Shape.PAPER);
            put(Shape.PAPER, Shape.SCISSORS);
            put(Shape.SCISSORS, Shape.ROCK);
        }
    };

    public static void main(String[] args) {
        try {
            File input = new File("day2/input.txt");
            long totalScore = 0;
            Scanner inputReader = new Scanner(input);
            while (inputReader.hasNextLine()) {
                String data = inputReader.nextLine();
                Shape opponentShape = TO_SHAPE.get(data.substring(0, 1));
                String outcome = data.substring(2, 3);
                switch (outcome) {
                    case "X":
                        Shape loosingShape = WINS_SHAPE.get(opponentShape);
                        totalScore += SHAPE_VALUES.get(loosingShape);
                        break;
                    case "Y":
                        totalScore += SHAPE_VALUES.get(opponentShape);
                        break;
                    case "Z":
                        Shape winnigShape = LOOSES_TO_SHAPE.get(opponentShape);
                        totalScore += SHAPE_VALUES.get(winnigShape);
                        break;
                }
                totalScore += OUTCOME_VALUES.get(data.substring(2, 3));
            }
            inputReader.close();
            System.out.println(totalScore);
        } catch (FileNotFoundException e) {
            System.out.println("Missing input.txt file.");
            e.printStackTrace();
        }
    }

}
