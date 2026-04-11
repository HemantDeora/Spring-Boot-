package com.training.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Updatecoursedto {
    private String courseName;
    private String courseDuration;
    private String courseTime;

}
