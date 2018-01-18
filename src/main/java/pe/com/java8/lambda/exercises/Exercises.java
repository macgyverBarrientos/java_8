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
        //assertEquals("[BRAVO, CHARLIE, DELTA, FOXTROT]", result.toString());
    }
    /* Hint 1:
     * Use filter() and map().
     */
    /* Hint 2:
     * Use Use collect() to create the result list.
     */


}

