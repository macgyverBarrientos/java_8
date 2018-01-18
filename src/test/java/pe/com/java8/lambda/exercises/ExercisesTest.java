package pe.com.java8.lambda.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
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

    /**
     * Join the second letters of words 1 through 4 of the list (inclusive,
     * counting from zero), separated by commas, into a single string.
     */
    @Test
    public void ex07_joinStreamRange() {
        String result = exercises.ex07_joinStreamRange(dummyMock.inputListThree()); // TODO

        Assert.assertEquals("r,h,e,c", result);
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
    @Test
    public void ex08_countLinesInFile() throws IOException {
        long count = exercises.ex08_countLinesInFile(dummyMock.z_setUpBufferedReader());

        Assert.assertEquals(14, count);
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
    @Test
    public void ex09_findLengthOfLongestLine() throws IOException {
        int longestLength = exercises.ex09_findLengthOfLongestLine(dummyMock.z_setUpBufferedReader()); // TODO

        Assert.assertEquals(53, longestLength);
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
    @Test
    public void ex10_findLongestLine() throws IOException {
        String longest = exercises.ex10_findLongestLine(dummyMock.z_setUpBufferedReader()); // TODO
        Assert.assertEquals("Feed'st thy light's flame with self-substantial fuel,", longest);
    }
    /* Hint 1:
     * Use Stream.max() with a Comparator.
     */
    /* Hint 2:
     * Use static methods on Comparator to help create a Comparator instance.
     */

}
