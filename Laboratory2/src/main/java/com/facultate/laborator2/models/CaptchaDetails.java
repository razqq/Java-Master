package com.facultate.laborator2.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CaptchaDetails {
    private String imageBase64;
    private int circlesCount;
}
