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
        String[] words = input.split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]).append(" ");
        }
        reversedSentence.setLength(reversedSentence.length() - 1);
        return reversedSentence.toString();
    }

    public static String encrypt(String plainText, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);

            if (Character.isLowerCase(ch)) {
                char shiftedChar = (char) (((ch - 'a' + shift) % 26 + 26) % 26 + 'a');
                encryptedText.append(shiftedChar);
            } else if (Character.isUpperCase(ch)) {
                char shiftedChar = (char) (((ch - 'A' + shift) % 26 + 26) % 26 + 'A');
                encryptedText.append(shiftedChar);
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }


    public static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, -shift);
    }
}