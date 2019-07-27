package tdd.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StringCalculatorTest {

    private StringCalculator underTest;

    @BeforeEach
    void setUp(){
        underTest = new StringCalculator();
    }


    @Test
    void GiveEmptyStringExpectZero(){

        // Given
        String givenString = "";
        int expectedResult = 0;

        // When
        int actual = underTest.add(givenString);

        // Then
        assertEquals(expectedResult, actual);

    }

    @Test
    void GiveSingleNumberGetNumberAsInt(){

        // Given
        String givenString = "4";
        int expectedResult = 4;

        // When
        int actualResult = underTest.add(givenString);

        // Then
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void GiveTwoStringsWithCommaAndExpectSumOfNumbers(){

        // Given
        String givenString = "4,6";
        int expectedResult = 10;

        // When
        int actualResult = underTest.add(givenString);

        // Then
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void EmptyStringAndValueAndExpectValue(){

        // Given
        String givenString = ",8";
        int expectedResult = 8;

        // When
        int actualResult = underTest.add(givenString);

        // Then
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void ThreeCommasWith2ValuesExpectSum(){

        // Given
        String givenString = ",,8,2";
        int expectedResult = 10;

        // When
        int actualResult = underTest.add(givenString);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void ExpectExceptionWhenGivenOtherCharacterThanComma(){

        // Given
        String givenString = "8.2";

        // Then
        assertThrows(NumberFormatException.class, () -> underTest.add(givenString));
    }

    @Test
    void GiveNewLinesInStringAndRemoveThen(){

        // Given
        String givenString = "1\n2,3";
        int expectedResult = 6;

        // When
        int actualResult = underTest.add(givenString);

        // Then
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void AllowForDelimitersToBeIncluded(){

        // Given
        String givenString = "//;\n1;2";
        int expectedResult = 3;

        // When
        int actualResult = underTest.add(givenString);

        // Then
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void UseFullStopAsDelimiter(){

        // Given
        String givenString = "//.2.5.6.9.10";
        int expectedResult = 32;

        // When
        int actualResult = underTest.add(givenString);

        // Then
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void useStarAsDelimiter(){

        // Given
        String givenString = "//*1*2*3*4*5";
        int expectedResult = 15;

        // When
        int actualResult = underTest.add(givenString);

        // Then
        assertEquals(expectedResult, actualResult);

    }
}
