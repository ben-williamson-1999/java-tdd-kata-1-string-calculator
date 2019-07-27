package tdd.kata;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers){

        if(numbers.isEmpty()){
            return 0;
        }

        String delimiter = determineDelimiter(numbers);

        numbers = cleanseString(numbers, delimiter);

        if(numbers.contains(String.valueOf(delimiter.charAt(delimiter.length() - 1)))){
            return Arrays.stream(numbers.split(delimiter)).mapToInt(this::add).sum();
        } else {
            return Integer.parseInt(numbers);
        }

    }

    private String cleanseString(String inputString, String delimiter){
        return inputString.trim()
                .replaceAll("\n", delimiter)
                .replaceAll("//", "");
    }

    private String determineDelimiter(String inputString){
        if(inputString.contains("//")){
            return "\\" + inputString.charAt(2);
        } else {
            return ",";
        }

    }
}

// On Task 5.