package com.schoolapp.repository;

//package com.Crmemp.repository;

//package com.Crmemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.schoolapp.entity.AutoclaveCycle;

//import com.Crmemp.entity.AutoclaveCycle;

public interface AutoclaveRepository extends JpaRepository<AutoclaveCycle, Long> {

  @Query(value = "SELECT autoclave_no FROM autoclave_cycle ORDER BY id DESC LIMIT 1", nativeQuery = true)
  String findLastAutoclaveNo();
  @Query("""
		   SELECT DISTINCT a FROM AutoclaveCycle a
		   JOIN a.wagons w
		   WHERE
		       w.eBatch = :batchNo
		       OR w.mBatch = :batchNo
		       OR w.wBatch = :batchNo
		""")
		AutoclaveCycle findByAnyBatch(Integer batchNo);



}


