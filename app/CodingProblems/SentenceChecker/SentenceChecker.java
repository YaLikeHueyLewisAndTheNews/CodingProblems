package app.CodingProblems.SentenceChecker;

import java.util.*;
import java.util.stream.IntStream;
import java.lang.Character;
 

public class SentenceChecker {

    private final static ArrayList<Character> separators = new ArrayList<Character>(Arrays.asList(',',';',':'));

    private final static ArrayList<Character> terminalMarks = new ArrayList<Character>(Arrays.asList('.','?','!','‽'));


    private static boolean isUpperCaseLetter(Character letter){
        //System.out.println(Character.isLetter(letter) && Character.isUpperCase(letter));
        return Character.isLetter(letter) && Character.isUpperCase(letter);
    }

    private static boolean isLowerCaseLetter(Character letter){
        //System.out.println(Character.isLetter(letter) && Character.isLowerCase(letter));
        return Character.isLetter(letter) && Character.isLowerCase(letter);
    }


    /**
     * Checks to see if it's a lower case letter, separator, or terminalMark
     */
    private static boolean isValidCharacter(Character letter){
        return isLowerCaseLetter(letter) || separators.contains(letter) || terminalMarks.contains(letter);
    }

    private static boolean isSpace(Character letter){
        return letter.compareTo(' ') == 0;
    }

    public static void main(String[] args){

        String sentence = "H .,.,., this is a sentence .";
        
        System.out.println(isValidSentence(sentence));

    }

    private static boolean isValidSentence(String sentence){
        for(int i = 0; i < sentence.length(); i++){
            Character charAtIndex = sentence.charAt(i);
            System.out.println(charAtIndex);
            if(i == 0){
                if(!isUpperCaseLetter(charAtIndex)){
                    return false;
                }
            }else if(i == 1){
                if(!isLowerCaseLetter(charAtIndex) && !isSpace(charAtIndex)){
                    return false;
                }
            }else if(i == sentence.length() - 1){
                if(!terminalMarks.contains(charAtIndex)){
                    return false;
                }else if(terminalMarks.contains(charAtIndex) && !isValidCharacter(sentence.charAt(i-1))){
                    return false;
                }
            }else{
                if(isSpace(charAtIndex)){
                    if(isSpace(sentence.charAt(i+1))){
                        return false;
                    }
                }else if(!isValidCharacter(charAtIndex)){
                    return false;
                }
            }
        }
        return true;
    }
}