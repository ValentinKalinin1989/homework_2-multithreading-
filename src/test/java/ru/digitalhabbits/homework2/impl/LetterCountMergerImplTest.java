package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.*;

class LetterCountMergerImplTest {

    @Test
    void merge_two_map_to_one() {
        var letterCountMergerImpl = new LetterCountMergerImpl();

        Map<Character, Long> firstMap = new HashMap<>();
        Map<Character, Long> secondMap = new HashMap<>();

        firstMap.put('a', 4L);
        firstMap.put('b', 4L);
        firstMap.put('c', 4L);
        firstMap.put('d', 4L);

        secondMap.put('b', 1L);
        secondMap.put('a', 4L);
        secondMap.put('g', 1L);
        secondMap.put('v', 1L);

        Map<Character, Long> countMap = letterCountMergerImpl.merge(firstMap, secondMap);

        assertThat(countMap).containsOnly(
                entry('a', 8L),
                entry('b', 5L),
                entry('c', 4L),
                entry('d', 4L),
                entry('g', 1L),
                entry('v', 1L)
        );
    }

}