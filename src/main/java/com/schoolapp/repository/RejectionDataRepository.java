package com.schoolapp.repository;

//package com.Crmemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolapp.entity.RejectionDataEntity;
//import com.Crmemp.entity.RejectionDataEntity;

public interface RejectionDataRepository extends JpaRepository<RejectionDataEntity, Long> {
	   RejectionDataEntity findByBatchNo(String batchNo);
}

