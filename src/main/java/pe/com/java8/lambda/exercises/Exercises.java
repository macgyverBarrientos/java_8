package pe.com.java8.lambda.exercises;

/*
 * LAMBDA PROGRAMMING LABORATORY
 *
 * For each exercise, develop a solution using Java SE 8 Lambda/Streams
 * and remove the @Ignore tag. Then run the tests.
 *
 *
 *
 * Several of the exercises read data from a text file. The field named
 * "reader" is a BufferedReader which will be opened for you on the text file.
 * In any exercise that refers to reading from the text file, you can simply
 * use the "reader" variable without worry about opening or closing it.
 * This is setup by JUnit using the @Before and @After methods at the bottom of
 * this file. The text file is "SonnetI.txt" (Shakespeare's first sonnet) which
 * is located at the root of this NetBeans project.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static java.util.stream.Collectors.partitioningBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Exercises {

    
// ========================================================
// DEFAULT METHODS
// ========================================================

    
    /**
     * Create a string that consists of the first letters of each
     * word in the input list.
     */
    public String ex01_accumulateFirstLetters(List<String> inputList){
        if (inputList==null && inputList.isEmpty()){
            return null;
        }
        StringBuilder builder = new StringBuilder();
        inputList.forEach(a ->builder.append(a.charAt(0)));
        return builder.toString();
    }

    /**
     * Remove the words that have odd lengths from the list.
     */
    public List<String> ex02_removeOddLengthWords(List<String> input) {
        input.removeIf(a -> a.length()%2==1);
        return input;
    }
    /* Hint
     * Use Collection.removeIf().
     */

    /**
     * Replace every word in the list with its upper case equivalent.
     */
    public List<String> ex03_upcaseAllWords(List<String> input) {
        input.replaceAll(a->a.toUpperCase());
        return input;
    }
    /* Hint:
     * Use List.replaceAll().
     */
    public String ex04_stringifyMap(Map<String,Integer> input) {
        StringBuilder builder = new StringBuilder();
        input.forEach( (K,V)-> builder.append(K).append(V));
        return builder.toString();
    }
    /* Hint:
     * Use Map.forEach()
     */

    /**
     * Given a list of words, create a map whose keys are the first letters of
     * each words, and whose values are the sum of the lengths of those words.
     */
    public Map<String, Integer> ex05_mapOfStringLengths( List<String> inputList) {
        Map<String, Integer> result = new TreeMap<>();
        inputList.forEach(a -> {
            result.merge(a.charAt(0)+"",a.length(),(x,y)->{
                if (result.get(a.charAt(0)+"")==null){
                    return x.toString().length();
                }else{
                    return result.get(a.charAt(0)+"") + y;
                }
            });
        });
        return result;
    }
    /* Hint:
     * Use Map.merge() within Iterable.forEach().
     */

    // ========================================================
// SIMPLE STREAM PIPELINES
// ========================================================


    /**
     * Given a list of words, create an output list that contains
     * only the odd-length words, converted to upper case.
     */
    public List<String> ex06_upcaseOddLengthWords(List<String> inputList) {
        List<String> result = inputList
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.toString().length()%2==1)
                .collect(Collectors.toList());
        return result;
    }
    /* Hint 1:
     * Use filter() and map().
     */
    /* Hint 2:
     * Use Use collect() to create the result list.
     */

    /**
     * Join the second letters of words 1 through 4 of the list (inclusive,
     * counting from zero), separated by commas, into a single string.
     */
    public String ex07_joinStreamRange(List<String> inputList) {

        String result = inputList.stream().
                skip(1).
                limit(4).map(a->a.charAt(1)+"").
                collect(Collectors.joining(",")); // TODO
        return result;
    }
    /* Hint 1:
     * Use Stream.skip() and Stream.limit().
     */
    /* Hint 2:
     * Use Use Collectors.joining().
     */

    /**
     * Count the number of lines in the text file. (Remember to
     * use the BufferedReader named "reader" that has already been
     * opened for you.)
     *
     * @throws IOException
     */
    public long ex08_countLinesInFile( BufferedReader bufferedReader) throws IOException {
        long count = bufferedReader.lines().count(); // TODO
        return count;
    }
    /* Hint 1:
     * Use BufferedReader.lines() to get a stream of lines.
     */
    /* Hint 2:
     * Use Use Stream.count().
     */

    /**
     * Find the length of the longest line in the text file.
     *
     * @throws IOException
     */
    public int ex09_findLengthOfLongestLine(BufferedReader inputReader) throws IOException {
        int longestLength = inputReader.lines().mapToInt(String::length).max().getAsInt(); // TODO
        return longestLength;
    }
    /* Hint 1:
     * Use Stream.mapToInt() to convert to IntStream.
     */
    /* Hint 2:
     * Look at java.util.OptionalInt to get the result.
     */

    /**
     * Find the longest line in the text file.
     *
     * @throws IOException
     */
    public String ex10_findLongestLine(BufferedReader inputReader) throws IOException {
        String longest = inputReader.lines().max(Comparator.comparing(String::length)).get(); // TODO
        return longest;
    }
    /* Hint 1:
     * Use Stream.max() with a Comparator.
     */
    /* Hint 2:
     * Use static methods on Comparator to help create a Comparator instance.
     */

    /**
     * Select the set of words from the input list whose length is greater than
     * to the word's position (starting from zero) in the list.
     */
    public List<String> ex11_selectByLengthAndPosition(List<String> inputList) {
        List<String> result = IntStream.
                range(0,inputList.size()).
                filter(i->inputList.get(i).length()>i).
                mapToObj(inputList::get).collect(Collectors.toList());

        return result;
    }
    /* Hint:
     * Instead of a stream of words (Strings), run an IntStream of positions.
     */

    /**
     * Given two lists of Integer, compute a third list where each element is the
     * difference between the corresponding elements of the two input lists
     * (first minus second).
     */
    @Test
    public List<Integer> ex12_listDifference(List<Integer> inputListOne, List<Integer> inputListTwo) {
        List<Integer> result = IntStream
                .range(0,inputListOne.size())
                .mapToObj(i -> inputListOne.get(i) - inputListTwo.get(i))
                .collect(Collectors.toList());
        return result;
    }
    /* Hint 1:
     * Run an IntStream of list positions (indexes).
     */
    /* Hint 2:
     * Deal with boxed Integers either by casting or by using mapToObj().
     */

    // ========================================================
// INTERMEDIATE STREAM PIPELINES
// ========================================================


    /**
     * Convert a list of strings into a list of characters.
     */
    public List<Character> ex13_stringsToCharacters(List<String> inputList) {
        List<Character> result = inputList
                .stream()
                .flatMap(x -> x.chars().mapToObj(c -> {
                    return (char) c;
                })).collect(Collectors.toList());
        return result;
    }
    /* Hint 1:
     * Use Stream.flatMap().
     */
    /* Hint 2:
     * Pay attention to the return type of String.chars() and boxing conversion.
     */

    //static final String REGEXP = "[- .:,]+"; // for splitting into words
    /**
     * Collect all the words from the text file into a list.
     * Use String.split(REGEXP) to split a string into words.
     * REGEXP is defined at the bottom of this file.
     *
     * @throws IOException
     */
    public List<String> ex14_listOfAllWords(BufferedReader inputReader, String regexp) throws IOException {
        List<String> output = inputReader
                .lines().map(x->x.split(regexp))
                .flatMap(Arrays::stream).collect(Collectors.toList());

       return output;
    }
    /* Hint:
     * Use Stream.flatMap().
     */
}

