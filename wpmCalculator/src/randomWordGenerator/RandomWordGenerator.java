package randomWordGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RandomWordGenerator {
    private String apiUrl;
    private String[] generatedWords;
    private int currentIndex;

    public RandomWordGenerator(String apiUrl, int wordCount) {
        this.apiUrl = apiUrl;
        this.generatedWords = new String[wordCount];
        this.currentIndex = 0;
    }

    public String getRandomWord() {
        if (currentIndex >= generatedWords.length) {
            return null;
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = reader.readLine();
            connection.disconnect();

            if (result != null) {
                result = result.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
                generatedWords[currentIndex++] = result;
                return result;
            } else {
                return null; 
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }

    public String[] getGeneratedWords() {
        return generatedWords;
    }
}

