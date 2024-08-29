package com.collectFingers.service.impl;

import com.collectFingers.dto.FingerPrintDto;
import com.collectFingers.entity.FingerPrint;
import com.collectFingers.repository.FingerPrintRepository;
import com.collectFingers.service.FingerPrintService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class FingerPrintServiceImpl implements FingerPrintService {

    private FingerPrintRepository fingerPrintRepository;

    public FingerPrintServiceImpl(FingerPrintRepository fingerPrintRepository) {
        this.fingerPrintRepository = fingerPrintRepository;
    }

    @Override
    public FingerPrintDto saveFingerprint(FingerPrintDto fingerPrintDto) {
        // Decode Base64 encoded strings to byte arrays
        byte[] isoData = Base64.getDecoder().decode(fingerPrintDto.getIsoData());
        byte[] rawData = Base64.getDecoder().decode(fingerPrintDto.getRawData());

        // Create a new Fingerprint entity
        FingerPrint fingerprint = new FingerPrint();
        fingerprint.setIsoData(isoData);
        fingerprint.setRawData(rawData);

        // Correctly set height and width from DTO
        fingerprint.setHeight(fingerPrintDto.getHeight());
        fingerprint.setWidth(fingerPrintDto.getWidth());

        // Save the Fingerprint entity to the database
        FingerPrint savedFingerprint = fingerPrintRepository.save(fingerprint);

        // Map saved entity to DTO
        FingerPrintDto savedDto = new FingerPrintDto();
        savedDto.setIsoData(Base64.getEncoder().encodeToString(savedFingerprint.getIsoData()));
        savedDto.setRawData(Base64.getEncoder().encodeToString(savedFingerprint.getRawData()));
        savedDto.setHeight(savedFingerprint.getHeight());
        savedDto.setWidth(savedFingerprint.getWidth());
        savedDto.setFingerId(savedFingerprint.getFingerId());
        return savedDto;
    }

    @Override
    public List<FingerPrintDto> saveFingerprints(List<FingerPrintDto> fingerPrintDtos) {
        List<FingerPrintDto> savedFingerprints = new ArrayList<>();

        for (FingerPrintDto fingerPrintDto : fingerPrintDtos) {
            // Decode Base64 encoded strings to byte arrays
            byte[] isoData = Base64.getDecoder().decode(fingerPrintDto.getIsoData());
            byte[] rawData = Base64.getDecoder().decode(fingerPrintDto.getRawData());

            // Create a new Fingerprint entity
            FingerPrint fingerprint = new FingerPrint();
            fingerprint.setIsoData(isoData);
            fingerprint.setRawData(rawData);
            fingerprint.setHeight(fingerPrintDto.getHeight());
            fingerprint.setWidth(fingerPrintDto.getWidth());

            // Save the Fingerprint entity to the database
            FingerPrint savedFingerprint = fingerPrintRepository.save(fingerprint);

            // Map saved entity to DTO
            FingerPrintDto savedDto = new FingerPrintDto();
            savedDto.setIsoData(Base64.getEncoder().encodeToString(savedFingerprint.getIsoData()));
            savedDto.setRawData(Base64.getEncoder().encodeToString(savedFingerprint.getRawData()));
            savedDto.setHeight(savedFingerprint.getHeight());
            savedDto.setWidth(savedFingerprint.getWidth());
            savedDto.setFingerId(savedFingerprint.getFingerId());

            savedFingerprints.add(savedDto);
        }

        return savedFingerprints;
    }

}
