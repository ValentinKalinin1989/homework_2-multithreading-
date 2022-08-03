package ru.digitalhabbits.homework2.impl;

import java.io.File;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

import ru.digitalhabbits.homework2.FileLetterCounter;
import ru.digitalhabbits.homework2.FileReader;
import ru.digitalhabbits.homework2.LetterCountMerger;
import ru.digitalhabbits.homework2.LetterCounter;

public class AsyncFileLetterCounter implements FileLetterCounter {

    private final Map<Character, Long> resultMap = new ConcurrentHashMap<>();
    private final FileReader fileReader = new FileReaderImpl();
    private final LetterCounter letterCounter = new LetterCounterImpl();
    private final LetterCountMerger letterCountMerger = new LetterCountMergerImpl();

    @Override
    public Map<Character, Long> count(File input) {

         fileReader.readLines(input).parallel()
                .forEach(str -> CompletableFuture.supplyAsync(() -> letterCounter.count(str))
                        .thenAcceptAsync(map -> letterCountMerger.merge(resultMap, map)));

        return resultMap;
    }
}
