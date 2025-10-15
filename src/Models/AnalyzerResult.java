package Models;

import java.util.Set;

public class AnalyzerResult {
    private int wordNumber;
    private int linesNumber;
    private int characterNumber;
    private String mostUsedWords;
    private long maxWordFrequency;
    private Set<String> shortestWords;
    private Set<String> longestWords;


    public AnalyzerResult(int wordNumber, int linesNumber, int characterNumber, String mostUsedWords,
                          long maxWordFrequency, Set<String> shortestWords, Set<String> longestWords) {
        this.wordNumber = wordNumber;
        this.linesNumber = linesNumber;
        this.characterNumber = characterNumber;
        this.mostUsedWords = mostUsedWords;
        this.maxWordFrequency = maxWordFrequency;
        this.shortestWords = shortestWords;
        this.longestWords = longestWords;
    }


    public int getWordNumber() {
        return wordNumber;
    }

    public void setWordNumber(int wordNumber) {
        this.wordNumber = wordNumber;
    }

    public int getLinesNumber() {
        return linesNumber;
    }

    public void setLinesNumber(int linesNumber) {
        this.linesNumber = linesNumber;
    }

    public String getMostUsedWords() {
        return mostUsedWords;
    }

    public void setMostUsedWords(String mostUsedWords) {
        this.mostUsedWords = mostUsedWords;
    }

    public long getMaxWordFrequency() {
        return maxWordFrequency;
    }

    public void setMaxWordFrequency(long maxWordFrequency) {
        this.maxWordFrequency = maxWordFrequency;
    }

    public Set<String> getShortestWords() {
        return shortestWords;
    }

    public void setShortestWords(Set<String> shortestWords) {
        this.shortestWords = shortestWords;
    }

    public Set<String> getLongestWords() {
        return longestWords;
    }

    public void setLongestWords(Set<String> longestWords) {
        this.longestWords = longestWords;
    }

    public int getCharacterNumber() {
        return characterNumber;
    }

    public void setCharacterNumber(int characterNumber) {
        this.characterNumber = characterNumber;
    }
}