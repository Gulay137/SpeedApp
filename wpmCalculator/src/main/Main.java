package main;
import randomWordGenerator.RandomWordGenerator;
import calculator.TypingSpeedCalculator;


public class Main {
	
    public static void main(String[] args) {
        String wordAPIUrl = "https://random-word-api.herokuapp.com/word";
        int wordCount = 13;

        RandomWordGenerator wordGenerator = new RandomWordGenerator(wordAPIUrl, wordCount);
        TypingSpeedCalculator typingSpeedCalculator = new TypingSpeedCalculator(wordGenerator);

        typingSpeedCalculator.calculateTypingSpeed();
    }
} 

