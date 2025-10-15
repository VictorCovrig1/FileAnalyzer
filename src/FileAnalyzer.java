import Models.AnalyzerResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileAnalyzer {
    public static AnalyzerResult generateFullReport(String filePath) {
        int wordCounter = 0;
        int lineCounter = 0;
        int characterCounter = 0;

        try {
            var textBuilder = new StringBuilder();
            try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCounter++;
                    textBuilder.append(line).append('\n');
                }
            }
            catch(IOException ex) {
                IO.println("An IO error occurred: " + ex.getMessage());
                return null;
            }

            String fileText = textBuilder.toString();
            List<String> fileWords = Arrays.stream(fileText.split(Constants.SPLIT_REGEX)).toList();
            wordCounter += fileWords.size();
            characterCounter += fileText.trim().length();
            var groupedWordsFreq = fileWords.stream().collect(Collectors.groupingBy(String::toString, Collectors.counting()));
            var mostUsedWordMap = groupedWordsFreq.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);

            String mostUsedWord = "";
            long mostUsedWordFreq = 0;

            if(mostUsedWordMap != null) {
                mostUsedWord = mostUsedWordMap.getKey();
                mostUsedWordFreq = mostUsedWordMap.getValue();
            }

            var groupedWordsLength = fileWords.stream()
                    .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
            var longestWords = groupedWordsLength.entrySet().stream()
                    .max(Map.Entry.comparingByKey()).map(Map.Entry::getValue).orElse(null);
            var shortestWords = groupedWordsLength.entrySet().stream()
                    .min(Map.Entry.comparingByKey()).map(Map.Entry::getValue).orElse(null);

            return new AnalyzerResult(wordCounter, characterCounter, lineCounter,
                            mostUsedWord, mostUsedWordFreq, shortestWords, longestWords);
        }
        catch(Exception ex) {
            IO.println("An exception occurred: " + ex.getMessage());
            return null;
        }
    }
}
