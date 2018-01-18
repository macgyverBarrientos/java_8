package pe.com.java8.lambda.exercises;

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
}