package ru.digitalhabbits.homework2.impl;

import lombok.SneakyThrows;
import ru.digitalhabbits.homework2.FileReader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {

    @SneakyThrows
    @Override
    public Stream<String> readLines(File file) {
        Path path = Paths.get(file.getPath());
        return Files.lines(path);
    }
}
