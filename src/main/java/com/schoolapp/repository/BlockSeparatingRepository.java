package com.schoolapp.repository;

//package com.Crmemp.repository;
//package com.yourapp.blockseparating.repository;

//import com.yourapp.blockseparating.entity.BlockSeparating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapp.entity.BlockSeparating;

//import com.Crmemp.entity.BlockSeparating;

import java.util.List;

@Repository
public interface BlockSeparatingRepository extends JpaRepository<BlockSeparating, Long> {

  List<BlockSeparating> findByIsActive(int isActive);
  BlockSeparating findByBatchNumber(String batchNumber); 

}

