package com.example.abc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Season {
    private int[] max;
    private int[] min;
    private String[] day;
    private int[] avg;
}
