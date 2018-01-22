package pe.com.java8.lambda.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

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

    /**
     * Select the set of words from the input list whose length is greater than
     * to the word's position (starting from zero) in the list.
     */
    @Test
    public void ex11_selectByLengthAndPosition() {

        List<String> result = exercises.ex11_selectByLengthAndPosition(dummyMock.inputListFour());

        Assert.assertEquals("[alfa, bravo, charlie, delta, foxtrot]", result.toString());
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
    public void ex12_listDifference() {
        List<Integer> result = exercises.ex12_listDifference(dummyMock.inputListIntegerOne(),dummyMock.inputListIntegerTwo()); // TODO
        Assert.assertEquals("[1, -6, 3, -7, 3, 1, 1, -2, 3, -5]", result.toString());
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
    @Test
    public void ex13_stringsToCharacters() {

        List<Character> result = exercises.ex13_stringsToCharacters(dummyMock.inputListFive());

        Assert.assertEquals("[a, l, f, a, b, r, a, v, o, c, h, a, r, l, i, e]", result.toString());
        Assert.assertTrue(result.stream().allMatch(x -> x instanceof Character));
    }
    /* Hint 1:
     * Use Stream.flatMap().
     */
    /* Hint 2:
     * Pay attention to the return type of String.chars() and boxing conversion.
     */

    /**
     * Collect all the words from the text file into a list.
     * Use String.split(REGEXP) to split a string into words.
     * REGEXP is defined at the bottom of this file.
     *
     * @throws IOException
     */
    @Test
    public void ex14_listOfAllWords() throws IOException {
        final String regexp = "[- .:,]+"; // for splitting into words
        List<String> output = exercises.ex14_listOfAllWords(dummyMock.z_setUpBufferedReader(),regexp);

        Assert.assertEquals(
                Arrays.asList(
                        "From", "fairest", "creatures", "we", "desire", "increase",
                        "That", "thereby", "beauty's", "rose", "might", "never", "die",
                        "But", "as", "the", "riper", "should", "by", "time", "decease",
                        "His", "tender", "heir", "might", "bear", "his", "memory",
                        "But", "thou", "contracted", "to", "thine", "own", "bright", "eyes",
                        "Feed'st", "thy", "light's", "flame", "with", "self", "substantial", "fuel",
                        "Making", "a", "famine", "where", "abundance", "lies",
                        "Thy", "self", "thy", "foe", "to", "thy", "sweet", "self", "too", "cruel",
                        "Thou", "that", "art", "now", "the", "world's", "fresh", "ornament",
                        "And", "only", "herald", "to", "the", "gaudy", "spring",
                        "Within", "thine", "own", "bud", "buriest", "thy", "content",
                        "And", "tender", "churl", "mak'st", "waste", "in", "niggarding",
                        "Pity", "the", "world", "or", "else", "this", "glutton", "be",
                        "To", "eat", "the", "world's", "due", "by", "the", "grave", "and", "thee"),
                output);
    }
    /* Hint:
     * Use Stream.flatMap().
     */

    /**
     * Read the words from the text file, and create a list containing the words
     * of length 8 or longer, converted to lower case, and sorted alphabetically.
     *
     * @throws IOException
     */
    @Test
    public void ex15_longLowerCaseSortedWords() throws IOException {
        final String regexp = "[- .:,]+"; // for splitting into words
        List<String> output = exercises.ex15_longLowerCaseSortedWords(dummyMock.z_setUpBufferedReader(),regexp) ;//

        Assert.assertEquals(
                Arrays.asList(
                        "abundance", "beauty's", "contracted", "creatures",
                        "increase", "niggarding", "ornament", "substantial"),
                output);
    }
    /* Hint:
     * Use Stream.sorted().
     */

    /**
     * Read the words from the text file, and create a list containing the words
     * of length 8 or longer, converted to lower case, and sorted reverse alphabetically.
     * (Same as above except for reversed sort order.)
     *
     * @throws IOException
     */
    @Test
    public void ex16_longLowerCaseReverseSortedWords() throws IOException {
        final String regexp = "[- .:,]+"; // for splitting into words
        List<String> result = exercises.ex16_longLowerCaseReverseSortedWords(dummyMock.z_setUpBufferedReader(),regexp);

        Assert.assertEquals(
                Arrays.asList(
                        "substantial", "ornament", "niggarding", "increase",
                        "creatures", "contracted", "beauty's", "abundance"),
                result);
    }
    /* Hint:
     * Use Comparator.reverseOrder().
     */

    /**
     * Read words from the text file, and sort unique, lower-cased words by length,
     * then alphabetically within length, and place the result into an output list.
     *
     * @throws IOException
     */
    @Test
    public void ex17_sortedLowerCaseDistinctByLengthThenAlphabetically() throws IOException {
        final String regexp = "[- .:,]+"; // for splitting into words
        List<String> result = exercises.ex17_sortedLowerCaseDistinctByLengthThenAlphabetically(dummyMock.z_setUpBufferedReader(),regexp);
        Assert.assertEquals(
                Arrays.asList(
                        "a", "as", "be", "by", "in", "or", "to", "we",
                        "and", "art", "bud", "but", "die", "due", "eat", "foe",
                        "his", "now", "own", "the", "thy", "too", "bear", "else",
                        "eyes", "from", "fuel", "heir", "lies", "only",
                        "pity", "rose", "self", "that", "thee", "this", "thou",
                        "time", "with", "churl", "cruel", "flame", "fresh", "gaudy",
                        "grave", "might", "never", "riper", "sweet", "thine",
                        "waste", "where", "world", "bright", "desire", "famine",
                        "herald", "mak'st", "making", "memory", "should", "spring",
                        "tender", "within", "buriest", "content", "decease",
                        "fairest", "feed'st", "glutton", "light's", "thereby", "world's", "beauty's",
                        "increase", "ornament", "abundance", "creatures", "contracted", "niggarding",
                        "substantial"),
                result);
    }
    /* Hint 1:
     * Use Stream.distinct().
     */
    /* Hint 2:
     * Use Comparator.theComparing().
     */

    /**
     * Count the total number of words and the number of distinct, lower case
     * words in the text file, in one pass.
     */
    @Test
    public void ex18_countTotalAndDistinctWords() throws IOException {
        final String regexp = "[- .:,]+"; // for splitting into words
        List<Long> result = exercises.ex18_countTotalAndDistinctWords(dummyMock.z_setUpBufferedReader(),regexp);
        long distinctCount = result.get(0); // TODO
        long totalCount = result.get(1); // TODO

        Assert.assertEquals("distinct count", 81, distinctCount);
        Assert.assertEquals("total count", 107, totalCount);
    }
    /* Hint 1:
     * Use Stream.peek().
     */
    /* Hint 2:
     * Use LongAdder or AtomicLong/AtomicInteger to allow peek() to have side effects.
     */
}
