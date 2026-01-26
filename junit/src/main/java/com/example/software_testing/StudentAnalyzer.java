package com.example.software_testing;

import java.util.List;
import java.util.stream.Collectors;

public class StudentAnalyzer {
    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * @param scores danh sách điểm số từ 0 đến 10
     * @return số học sinh đạt loại Giỏi (>= 8.0)
     * - Bỏ qua điểm âm hoặc lớn hơn 10 (coi là dữ liệu sai)
     * - Nếu danh sách rỗng, trả về 0
     */
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }
        return (int) scores.stream()
                .filter(score -> score != null && score >= 8.0 && score <= 10.0)
                .count();
    }

    /**
     * Tính điểm trung bình hợp lệ (từ 0 đến 10)
     * @param scores danh sách điểm
     * @return điểm trung bình của các điểm hợp lệ
     */
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }
        List<Double> validScores = scores.stream()
                .filter(score -> score != null && score >= 0.0 && score <= 10.0)
                .collect(Collectors.toList());

        if (validScores.isEmpty()) {
            return 0;
        }

        double sum = validScores.stream().mapToDouble(Double::doubleValue).sum();
        return sum / validScores.size();
    }
}

