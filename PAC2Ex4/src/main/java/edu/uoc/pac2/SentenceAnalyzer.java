package edu.uoc.pac2;

public class SentenceAnalyzer {

    public static String reverseWords(String input) {
        // create a String array of words
        String[] words = input.split(" ");
        // create the final reversed sentenec with StringBuilder
        StringBuilder reversedSentence = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();
            reversedSentence.append(reversedWord).append(" ");
        }
        // delete last "space"
        reversedSentence.setLength(reversedSentence.length() - 1);
        return reversedSentence.toString();
    }

    public static String reverseSentence(String input) {
        //TODO implement
        /*
        reverseSentence: aquest mètode rep un paràmetre text (String),
        la qual conté una frase i retorna aquesta mateixa frase amb l’ordre de les paraules invertit:

Hello, world! → world! Hello,
         */

        return "pep";
    }

    public static String encrypt(String plainText, int shift) {
        //TODO implement
        return "pep";
    }

    public static String decrypt(String encryptedText, int shift) {
        //TODO implement
        return "pep";
    }
}
