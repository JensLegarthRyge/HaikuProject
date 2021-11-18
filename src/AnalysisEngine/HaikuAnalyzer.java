package AnalysisEngine;

public class HaikuAnalyzer {

    public boolean isVowel(char charToCheck) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        for (char currentVowel : vowels) {
            if (charToCheck == currentVowel) {
                return true;
            }
        }
        return false;
    }

    private String[] stringToWordArray(String sentence) {
        String[] stringSplit = sentence.split("\\s+");
        return stringSplit;
    }

    public int getSyllableCountFromWord(String stringToAnalyze) {
        int syllableCount = 0;
        int stringLength = stringToAnalyze.length();
        stringToAnalyze = stringToAnalyze.toLowerCase();

        for (int i = 0; i < stringToAnalyze.length(); i++) {
            char charToAnalyze = stringToAnalyze.charAt(i);
            if (isVowel(charToAnalyze)){
                syllableCount++;
                try{
                    if (isVowel(stringToAnalyze.charAt(i+1))){
                        syllableCount-=1;
                    }
                } catch (IndexOutOfBoundsException ignored){}
            }
        } return syllableCount;
    }

    public int getSyllableCountFromSentence (String sentence){
        int syllableCount = 0;
        String[] wordArray = stringToWordArray(sentence);
        for (String word : wordArray) {
            syllableCount += getSyllableCountFromWord(word);
        }
        return syllableCount;
    }

    public boolean isHaikuPoem(HaikuPoem haikuPoem){
        int firstLineSyllables = getSyllableCountFromSentence(haikuPoem.getHaikuBody(0));
        int secondLineSyllables = getSyllableCountFromSentence(haikuPoem.getHaikuBody(1));
        int thirdLineSyllables = getSyllableCountFromSentence(haikuPoem.getHaikuBody(2));

        if (firstLineSyllables == 5 && secondLineSyllables == 7 && thirdLineSyllables == 5){
            return true;
        } else
            return false;
    }
}
