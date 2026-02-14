package com.schoolapp.repository;

//package com.Crmemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schoolapp.entity.CubeTestEntity;

//import com.Crmemp.entity.CubeTestEntity;

public interface CubeTestRepository extends JpaRepository<CubeTestEntity, Long> {
	 CubeTestEntity findByBatchNo(String batchNo);
}

