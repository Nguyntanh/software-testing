package com.example.software_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTests {

    private StudentAnalyzer analyzer = new StudentAnalyzer();

    @Test
    public void testCountExcellentStudents_NormalCase_MixedScores() {
        // Danh sách có nhiều điểm hợp lệ và không hợp lệ
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0, 10.0, 5.0, 8.0);
        assertEquals(4, analyzer.countExcellentStudents(scores)); // 9.0, 8.5, 10.0, 8.0
    }

    @Test
    public void testCountExcellentStudents_NormalCase_AllValid() {
        // Danh sách toàn bộ hợp lệ
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.5, 10.0, 8.0);
        assertEquals(4, analyzer.countExcellentStudents(scores)); // 9.0, 8.5, 10.0, 8.0
    }

    @Test
    public void testCountExcellentStudents_BoundaryCase_EmptyList() {
        // Danh sách trống
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_BoundaryCase_OnlyZeroOrTen() {
        // Danh sách chỉ chứa giá trị 0 hoặc 10
        List<Double> scores = Arrays.asList(0.0, 10.0, 0.0, 10.0);
        assertEquals(2, analyzer.countExcellentStudents(scores)); // 10.0, 10.0
    }

    @Test
    public void testCountExcellentStudents_EdgeCase_InvalidScores() {
        // Có điểm < 0 hoặc > 10 (phải bỏ qua)
        List<Double> scores = Arrays.asList(-5.0, 15.0, 9.0, 8.0);
        assertEquals(2, analyzer.countExcellentStudents(scores)); // 9.0, 8.0
    }

    @Test
    public void testCountExcellentStudents_NullScoresInList() {
        List<Double> scores = Arrays.asList(9.0, null, 8.0, 7.0);
        assertEquals(2, analyzer.countExcellentStudents(scores)); // 9.0, 8.0
    }

    // --- Tests for calculateValidAverage ---

    @Test
    public void testCalculateValidAverage_NormalCase_MixedScores() {
        // Danh sách có nhiều điểm hợp lệ và không hợp lệ
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0, 10.0, 5.0);
        // Valid scores: 9.0, 8.5, 7.0, 10.0, 5.0
        // Sum: 39.5, Count: 5, Average: 7.9
        assertEquals(7.9, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_NormalCase_AllValid() {
        // Danh sách toàn bộ hợp lệ
        List<Double> scores = Arrays.asList(9.0, 8.0, 7.0, 10.0, 5.0);
        // Sum: 39.0, Count: 5, Average: 7.8
        assertEquals(7.8, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_BoundaryCase_EmptyList() {
        // Danh sách trống
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);
    }

    @Test
    public void testCalculateValidAverage_BoundaryCase_OnlyZeroOrTen() {
        // Danh sách chỉ chứa giá trị 0 hoặc 10
        List<Double> scores = Arrays.asList(0.0, 10.0, 0.0, 10.0);
        // Sum: 20.0, Count: 4, Average: 5.0
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_EdgeCase_OnlyInvalidScores() {
        // Chỉ có điểm không hợp lệ
        List<Double> scores = Arrays.asList(-5.0, 15.0, -1.0, 11.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_NullScoresInList() {
        List<Double> scores = Arrays.asList(9.0, null, 8.0, 7.0);
        // Valid scores: 9.0, 8.0, 7.0
        // Sum: 24.0, Count: 3, Average: 8.0
        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_SingleValidScore() {
        List<Double> scores = Arrays.asList(7.5);
        assertEquals(7.5, analyzer.calculateValidAverage(scores), 0.01);
    }
}