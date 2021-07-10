package com.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class FirstNonRepeatedChars {
    public static void main(String[] args) {
        String str = "ceaddbbcaae";
        char nonRepeatedCharacter = findFirstNonRepeatedCharacter(str);
        System.out.println(nonRepeatedCharacter);
    }

    private static char findFirstNonRepeatedCharacter(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Optional<Integer> tempCount = Optional.ofNullable(countMap.get(str.charAt(i)));
            if(tempCount.isPresent()){
                countMap.put(str.charAt(i), tempCount.get() + 1);
            } else {
                countMap.put(str.charAt(i), 1);
            }
        }

        AtomicReference<Character> result = new AtomicReference<>(' ');
        countMap.forEach((character, integer) -> {
            if(integer == 1) {
                result.set(character);
            }
        });
        return result.get();
    }
}
