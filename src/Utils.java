import Models.AnalyzerResult;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Utils {
    public static String getResultContent(AnalyzerResult result, boolean isCsv) {
        String delimiter = isCsv ? "," : ": ";

        return Arrays.stream(getLabelsAndResults(result, isCsv))
                .map(row -> String.join(delimiter, row))
                .collect(Collectors.joining("\n"));
    }

    public static String[][] getLabelsAndResults(AnalyzerResult result, boolean isCsv) {
        String shortestWords = String.join(", ", result.getShortestWords());
        String longestWords = String.join(", ", result.getLongestWords());

        if(isCsv)
        {
            shortestWords = "\"" + shortestWords + "\"";
            longestWords = "\"" + longestWords + "\"";
        }

        return new String[][] {
                { "Words", String.valueOf(result.getWordNumber()) },
                { "Characters", String.valueOf(result.getCharacterNumber()) },
                { "Lines", String.valueOf(result.getLinesNumber()) },
                { "Most used word / frequency", result.getMostUsedWords() + " / " + result.getMaxWordFrequency() },
                { "Shortest words", shortestWords },
                { "Longest words", longestWords }
        };
    }
}
