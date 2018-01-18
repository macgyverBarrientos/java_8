package pe.com.java8.lambda.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created on 16/01/2018.
 *
 * @author Entelgy
 */
public class ExercisesTest {
    private Exercises exercises;
    private DummyMock dummyMock;

    @Before
    public void init(){
        exercises = new Exercises();
        dummyMock = new DummyMock();
    }

    @Test
    public void ex01_accumulateFirstLettersTest(){
        String result = exercises.ex01_accumulateFirstLetters(dummyMock.inputList());
        Assert.assertEquals("abcdef", result);
    }

    @Test
    public void ex02_removeOddLengthWordsTest(){
        List<String> result = exercises.ex02_removeOddLengthWords(dummyMock.inputList());
        Assert.assertEquals("[alfa, echo]", result.toString());
    }

    @Test
    public void ex03_upcaseAllWordsTest(){
        List<String> result = exercises.ex03_upcaseAllWords(dummyMock.inputList());
        Assert.assertEquals("[ALFA, BRAVO, CHARLIE, DELTA, ECHO, FOXTROT]", result.toString());
    }

    /**
     * Convert every key-value pair of a map into a string and append them all
     * into a single string, in iteration order.
     */
    @Test
    public void ex04_stringifyMap() {
        String result = exercises.ex04_stringifyMap(dummyMock.inputMap());
        Assert.assertEquals("a1b2c3", result);
    }
    /* Hint:
     * Use Map.forEach()
     */

    /**
     * Given a list of words, create a map whose keys are the first letters of
     * each words, and whose values are the sum of the lengths of those words.
     */
    @Test
    public void ex05_mapOfStringLengths() {
        Map<String,Integer> result = exercises.ex05_mapOfStringLengths(dummyMock.inputListTwo());
        Assert.assertEquals("{a=23, b=20, c=26}", result.toString());
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
    @Test
    public void ex06_upcaseOddLengthWords() {
        List<String> result = exercises.ex06_upcaseOddLengthWords(dummyMock.inputListThree()); // TODO

        Assert.assertEquals("[BRAVO, CHARLIE, DELTA, FOXTROT]", result.toString());
    }
    /* Hint 1:
     * Use filter() and map().
     */
    /* Hint 2:
     * Use Use collect() to create the result list.
     */
}
