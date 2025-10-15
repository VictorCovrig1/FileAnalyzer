package Models;

import java.util.Set;

public class AdvancedAnalyzerResult extends AnalyzerResult {


    public AdvancedAnalyzerResult(int wordNumber, int linesNumber, int characterNumber, String mostUsedWords,
                                  long maxWordFrequency, Set<String> shortestWords, Set<String> longestWords) {
        super(wordNumber, linesNumber, characterNumber, mostUsedWords, maxWordFrequency, shortestWords, longestWords);


    }
}
