package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.*;

class LetterCounterImplTest {

    @Test
    void count_character_in_string() {
        var letterCounterImpl = new LetterCounterImpl();
        Map<Character, Long> countMap = letterCounterImpl.count("aaaaffghjkkkl");

        assertThat(countMap).containsOnly(
                entry('a', 4L),
                entry('f', 2L),
                entry('g', 1L),
                entry('h', 1L),
                entry('j', 1L),
                entry('k', 3L),
                entry('l', 1L)
        );
    }
}