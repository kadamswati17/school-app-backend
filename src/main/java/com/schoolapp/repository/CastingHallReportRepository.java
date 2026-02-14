package com.schoolapp.repository;

//package com.Crmemp.repository;

//import com.Crmemp.entity.CastingHallReport;
import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolapp.entity.CastingHallReport;

public interface CastingHallReportRepository
        extends JpaRepository<CastingHallReport, Long> {
	 boolean existsByBatchNo(String batchNo);
	 CastingHallReport findByBatchNo(String batchNo);

}
