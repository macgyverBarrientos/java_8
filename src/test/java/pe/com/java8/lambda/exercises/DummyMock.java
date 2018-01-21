package pe.com.java8.lambda.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created on 16/01/2018.
 *
 * @author Entelgy
 */
public class DummyMock {
    public List<String> inputList(){
        List<String> input = new ArrayList<>();
        input.add("alfa");
        input.add("bravo");
        input.add("charlie");
        input.add("delta");
        input.add("echo");
        input.add("foxtrot");
        return input;
    }

    public List<String> inputListTwo(){
        List<String> list = Arrays.asList(
                "aardvark", "bison", "capybara",
                "alligator", "bushbaby", "chimpanzee",
                "avocet", "bustard", "capuchin");
        return list;
    }

    public List<String> inputListThree(){
        List<String> input = new ArrayList<>();
            input.add("alfa");
            input.add("bravo");
            input.add("charlie");
            input.add("delta");
            input.add("echo");
            input.add("foxtrot");

        return input;
    }

    public Map<String, Integer> inputMap(){
        Map<String, Integer> input = new TreeMap<>();
        input.put("c", 3);
        input.put("b", 2);
        input.put("a", 1);
        return input;
    }

    public BufferedReader z_setUpBufferedReader() throws IOException {
        BufferedReader inputFile;
        inputFile = Files.newBufferedReader(
                Paths.get("src\\test\\resources\\SonnetI.txt"), StandardCharsets.UTF_8);
        return inputFile;
    }

    public List<String> inputListFour(){
        List<String> input = new ArrayList<>(Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel"));
        return input;
    }

    public List<Integer> inputListIntegerOne(){
        List<Integer> one = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3);
        return one;
    }

    public List<Integer> inputListIntegerTwo(){
        List<Integer> two = Arrays.asList(2, 7, 1, 8, 2, 8, 1, 8, 2, 8);
        return two;
    }

    public List<String> inputListFive(){
        List<String> input = Arrays.asList("alfa", "bravo", "charlie");
        return input;
    }
}
