package com.collectFingers.repository;

import com.collectFingers.entity.FingerPrint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FingerPrintRepository extends JpaRepository<FingerPrint, Long> {
}
