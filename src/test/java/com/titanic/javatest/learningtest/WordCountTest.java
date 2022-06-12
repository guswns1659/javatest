package com.titanic.javatest.learningtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCountTest {

    @DisplayName("한 줄 파일의 라인 수, 단어 수, 글자 수를 리턴한다.")
    @Test
    void simpleFile() {
        String location = "/Users/jack/Playground/simpletxt.txt";
        assertThat(Word.count(location)).isEqualTo(List.of(1, 2, 11));
    }

    @DisplayName("여러 라인 파일의 라인 수, 단어 수, 글자 수를 리턴한다.")
    @Test
    void fileGiven_ReturnWordCount() {
        String location = "/Users/jack/Playground/wordcount.txt";
        assertThat(Word.count(location)).isEqualTo(List.of(44, 810, 4922));
    }
}

class Word {
    private static final String DELIMITER = "\\s+|\t";
    private static final int NEWLINE_BYTE = 1;

    public static List<Integer> count(String location) {
        try (BufferedReader br = new BufferedReader(new FileReader(location))) {
            String line;
            int lineCount = 0;
            int wordCount = 0;
            int byteCount = 0;
            while ((line = br.readLine()) != null) {
                lineCount++;
                wordCount += getWordCountFromALine(line);
                byteCount += getByteCountFromALine(line);
            }
            return List.of(lineCount, wordCount, byteCount);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return List.of(0, 0, 0);
    }

    private static int getByteCountFromALine(String line) {
        return line.getBytes().length + NEWLINE_BYTE;
    }

    private static int getWordCountFromALine(String line) {
        return line.split(DELIMITER).length;
    }
}

