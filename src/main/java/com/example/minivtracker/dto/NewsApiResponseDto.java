package com.example.minivtracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsApiResponseDto {
    private String status;
    private Integer totalResults;
    private List<String> articles;
}
