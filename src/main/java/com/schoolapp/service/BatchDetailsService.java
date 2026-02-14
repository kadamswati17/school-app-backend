package com.schoolapp.service;

import java.util.List;

import com.schoolapp.dao.BatchHeaderDto;
import com.schoolapp.entity.BatchDetails;

//import com.Crmemp.dto.request.BatchHeaderDto;
//import com.Crmemp.entity.BatchDetails;

public interface BatchDetailsService {

    BatchDetails createBatch(BatchDetails batch);

    List<BatchHeaderDto> getAllBatches();

    // Approve workflow (expects bactno, userId, role)
    BatchDetails approveBatch(Long bactno, Long userId, String role);

    // Reject workflow (expects bactno, userId, role, optional reason)
    BatchDetails rejectBatch(Long bactno, Long userId, String role, String reason);

    // Admin / L1 allowed to update batch header (basic fields)
    BatchDetails updateBatch(Long bactno, BatchDetails update, Long userId, String role);

    // Admin / L1 allowed to delete batch
    void deleteBatch(Long bactno, Long userId, String role);

//    byte[] generateBatchReport(Long bactno);
}
