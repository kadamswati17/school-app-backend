package com.schoolapp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapp.entity.SellOrder;

//import com.Crmemp.entity.SellOrder;

@Repository
public interface SellOrderRepository extends JpaRepository<SellOrder, Long> {

    Optional<SellOrder> findById(Long id);
}
