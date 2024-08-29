package com.collectFingers.controller;

import com.collectFingers.dto.FingerPrintDto;
import com.collectFingers.service.FingerPrintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fingerprints")
public class FingerPrintController {

    private final FingerPrintService fingerPrintService;

    public FingerPrintController(FingerPrintService fingerPrintService) {
        this.fingerPrintService = fingerPrintService;
    }

    @PostMapping("/upload")
    public ResponseEntity<FingerPrintDto> uploadFingerprint(@RequestBody FingerPrintDto fingerPrintDto) {
        FingerPrintDto response = fingerPrintService.saveFingerprint(fingerPrintDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/uploadMultiple")
    public ResponseEntity<List<FingerPrintDto>> uploadFingerprints(@RequestBody List<FingerPrintDto> fingerPrintDtos) {
        List<FingerPrintDto> response = fingerPrintService.saveFingerprints(fingerPrintDtos);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
