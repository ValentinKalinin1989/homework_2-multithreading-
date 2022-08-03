package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.LetterCounter;

import java.util.HashMap;
import java.util.Map;

public class LetterCounterImpl implements LetterCounter {
    @Override
    public Map<Character, Long> count(String input) {
        Map<Character, Long> counterMap = new HashMap<>();
        for(Character charKey: input.toCharArray()) {
            counterMap.merge(charKey, 1L, Long::sum);
        }
        return counterMap;
    }
}
