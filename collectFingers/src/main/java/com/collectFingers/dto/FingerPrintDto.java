package com.collectFingers.dto;

import lombok.Data;

@Data
public class FingerPrintDto {

        private Long fingerId;
        private String isoData;
        private String rawData;
        private int height;
        private int width;

}
