package com.ayush.springaop.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Long id;
    private String fullName;
}
