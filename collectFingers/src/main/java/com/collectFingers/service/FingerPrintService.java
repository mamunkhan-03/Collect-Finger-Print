package com.collectFingers.service;

import com.collectFingers.dto.FingerPrintDto;

import java.util.List;

public interface FingerPrintService {

    FingerPrintDto saveFingerprint(FingerPrintDto fingerPrintDto);

    List<FingerPrintDto> saveFingerprints(List<FingerPrintDto> fingerPrintDtos);
}

