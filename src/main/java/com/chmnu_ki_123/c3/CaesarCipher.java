package com.chmnu_ki_123.c3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CaesarCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        String encryptedText = "wklv lv d whvw phvvdjh";

        IntStream.range(1, 26).forEach(shift -> {
            String decryptedText = decryptCaesarCipher(encryptedText, shift);
            System.out.println("Shift " + shift + ": " + decryptedText);
        });
    }

    private static String decryptCaesarCipher(String text, int shift) {
        return text.chars()
                .mapToObj(c -> {
                    if (Character.isLetter(c)) {
                        char base = Character.isLowerCase(c) ? 'a' : 'A';
                        return (char) ((c - base - shift + 26) % 26 + base);
                    } else {
                        return (char) c;
                    }
                })
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}