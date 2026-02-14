package com.schoolapp.repository;

//import com.Crmemp.entity.ProductionEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapp.entity.ProductionEntry;

@Repository
public interface ProductionEntryRepository extends JpaRepository<ProductionEntry, Long> {
}
