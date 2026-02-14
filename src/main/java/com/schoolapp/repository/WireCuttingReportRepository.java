package com.schoolapp.repository;

//package com.Crmemp.repository;

//import com.Crmemp.entity.WireCuttingReport;
import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolapp.entity.WireCuttingReport;

public interface WireCuttingReportRepository
        extends JpaRepository<WireCuttingReport, Long> {
	boolean existsByBatchNo(String batchNo);
	WireCuttingReport findByBatchNo(String batchNo);

}

