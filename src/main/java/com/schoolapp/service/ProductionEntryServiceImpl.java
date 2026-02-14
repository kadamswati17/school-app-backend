package com.schoolapp.service;

//import com.Crmemp.dto.request.ProductionEntryRequest;
//import com.Crmemp.dto.request.ProductionImportRequest;
//import com.Crmemp.dto.request.ProductionImportResponse;
//import com.Crmemp.dto.request.ProductionImportResult;
//import com.Crmemp.entity.ProductionEntry;
//import com.Crmemp.enums.Role;
//import com.Crmemp.repository.ProductionEntryRepository;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import com.schoolapp.dao.ProductionEntryRequest;
import com.schoolapp.dao.ProductionImportRequest;
import com.schoolapp.dao.ProductionImportResponse;
import com.schoolapp.dao.ProductionImportResult;
import com.schoolapp.entity.CastingHallReport;
import com.schoolapp.entity.CubeTestEntity;
import com.schoolapp.entity.ProductionEntry;
import com.schoolapp.entity.RejectionDataEntity;
import com.schoolapp.entity.WireCuttingReport;
import com.schoolapp.repository.CastingHallReportRepository;
import com.schoolapp.repository.CubeTestRepository;
import com.schoolapp.repository.ProductionEntryRepository;
import com.schoolapp.repository.RejectionDataRepository;
import com.schoolapp.repository.WireCuttingReportRepository;
import com.schoolapp.entity.AutoclaveCycle;
import com.schoolapp.entity.BlockSeparating;
import com.schoolapp.repository.AutoclaveRepository;
import com.schoolapp.repository.BlockSeparatingRepository;

//import java.sql.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductionEntryServiceImpl implements ProductionEntryService {

    private final ProductionEntryRepository repository;

    private final CastingHallReportRepository castingRepo;
    private final WireCuttingReportRepository cuttingRepo;
    private final BlockSeparatingRepository blockRepo;
    private final AutoclaveRepository autoclaveRepo;
    private final CubeTestRepository cubeTestRepo;
    private final RejectionDataRepository rejectionRepo;


    public ProductionEntryServiceImpl(
            ProductionEntryRepository repository,
            CastingHallReportRepository castingRepo,
            WireCuttingReportRepository cuttingRepo,
            BlockSeparatingRepository blockRepo,
            AutoclaveRepository autoclaveRepo,
            CubeTestRepository cubeTestRepo,
            RejectionDataRepository rejectionRepo
    ) {
        this.repository = repository;
        this.castingRepo = castingRepo;
        this.cuttingRepo = cuttingRepo;
        this.blockRepo = blockRepo;
        this.autoclaveRepo = autoclaveRepo;
        this.cubeTestRepo = cubeTestRepo;
        this.rejectionRepo = rejectionRepo;
    }





    @Override
    public ProductionEntry save(ProductionEntryRequest r) {

//        ProductionEntry e = new ProductionEntry();
//        mapRequestToEntity(r, e);
        ProductionEntry e = new ProductionEntry();
        mapRequestToEntity(r, e);
        e.setApprovalStage("NONE");

        // 1️⃣ Save first to generate ID
        ProductionEntry saved = repository.save(e);

        // 2️⃣ Set batchNo = id
        saved.setBatchNo(String.valueOf(saved.getId()));

        // 3️⃣ Save again
        return repository.save(saved);
    }


    @Override
    public ProductionEntry update(Long id, ProductionEntryRequest r) {

        ProductionEntry e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Production entry not found"));

        mapRequestToEntity(r, e);

        return repository.save(e);
    }

    private void mapRequestToEntity(ProductionEntryRequest r, ProductionEntry e) {

        e.setShift(r.shift);
//        e.setBatchNo(r.batchNo);

        e.setSiloNo1(r.siloNo1);
        e.setLiterWeight1(r.literWeight1);
        e.setFaSolid1(r.faSolid1);

        e.setSiloNo2(r.siloNo2);
        e.setLiterWeight2(r.literWeight2);
        e.setFaSolid2(r.faSolid2);

        // 🔥 AUTO TOTAL SOLID
        double totalSolid =
                (r.faSolid1 != null ? r.faSolid1 : 0) +
                (r.faSolid2 != null ? r.faSolid2 : 0);
        e.setTotalSolid(totalSolid);

        e.setWaterLiter(r.waterLiter);
        e.setCementKg(r.cementKg);
        e.setLimeKg(r.limeKg);
        e.setGypsumKg(r.gypsumKg);
        e.setSolOilKg(r.solOilKg);
        e.setAiPowerGm(r.aiPowerGm);
        e.setTempC(r.tempC);

        e.setCastingTime(r.castingTime);
        e.setProductionTime(r.productionTime);
        e.setProductionRemark(r.productionRemark);
        e.setRemark(r.remark);

        e.setUserId(r.userId);
        e.setBranchId(r.branchId);
        e.setOrgId(r.orgId);
    }

    @Override
    public List<ProductionEntry> getAll() {
        return repository.findAll();
    }

    @Override
    public ProductionEntry getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Production entry not found"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
//    @Override
//    public ProductionEntry approve(Long productionId, Long userId, String role) {
//
//        ProductionEntry entry = repository.findById(productionId)
//                .orElseThrow(() -> new RuntimeException("Production entry not found"));
//
//        String stage = entry.getApprovalStage();
//        if (stage == null) stage = "NONE";
//
//        switch (stage) {
//
//            case "NONE":
//                if (!"ROLE_L1".equals(role))
//                    throw new RuntimeException("Only L1 can approve");
//
//                entry.setApprovedByL1(String.valueOf(userId));
//                entry.setApprovalTimeL1(now());      // 🔥 TIME
//                entry.setApprovalStage("L1");
//                break;
//
//            case "L1":
//                if (!"ROLE_L2".equals(role))
//                    throw new RuntimeException("Only L2 can approve");
//
//                entry.setApprovedByL2(String.valueOf(userId));
//                entry.setApprovalTimeL2(now());      // 🔥 TIME
//                entry.setApprovalStage("L2");
//                break;
//
//            case "L2":
//                if (!"ROLE_L3".equals(role))
//                    throw new RuntimeException("Only L3 can approve");
//
//                entry.setApprovedByL3(String.valueOf(userId));
//                entry.setApprovalTimeL3(now());      // 🔥 TIME
//                entry.setApprovalStage("L3");
//                break;
//
//            default:
//                throw new RuntimeException("Already approved");
//        }
//
//        return repository.save(entry);
//    }
    
    @Override
    public ProductionEntry approve(Long productionId) {

        ProductionEntry entry = repository.findById(productionId)
                .orElseThrow(() -> new RuntimeException("Production entry not found"));

        entry.setApprovalStage("APPROVED");

        return repository.save(entry);
    }

    @Override
    public ProductionEntry reject(Long productionId, String reason) {

        ProductionEntry entry = repository.findById(productionId)
                .orElseThrow(() -> new RuntimeException("Production entry not found"));

        entry.setApprovalStage("REJECTED");
        entry.setRejectReason(reason);

        return repository.save(entry);
    }

//
//
//    @Override
//    public ProductionEntry reject(Long productionId, Long userId, String role, String reason) {
//
//        ProductionEntry entry = repository.findById(productionId)
//                .orElseThrow(() -> new RuntimeException("Production entry not found"));
//
//        String stage = entry.getApprovalStage();
//        if (stage == null) stage = "NONE";
//
//
//        if ("L3".equals(stage))
//            throw new RuntimeException("Final approved cannot be rejected");
//
//        if (
//            ("NONE".equals(stage) && !"ROLE_L1".equals(role)) ||
//            ("L1".equals(stage) && !"ROLE_L2".equals(role)) ||
//            ("L2".equals(stage) && !"ROLE_L3".equals(role))
//        ) {
//            throw new RuntimeException("No authority to reject");
//        }
//
//        entry.setApprovalStage("NONE");
//        entry.setApprovedByL1(null);
//        entry.setApprovedByL2(null);
//        entry.setApprovedByL3(null);
//        entry.setRejectedBy(String.valueOf(userId));
//        entry.setRejectReason(reason);
//
//        return repository.save(entry);
//    }


    @Override
    public ProductionImportResponse importProduction(
            ProductionImportRequest request) {

        int saved = 0;
        int failed = 0;

        List<ProductionImportResult> results = new ArrayList<>();
        if (request.getProductions() == null || request.getProductions().isEmpty()) {
            throw new RuntimeException("No production data received");
        }
        for (ProductionEntryRequest r : request.getProductions()) {
            try {

                // 🔹 Set system fields if missing
                r.setUserId(request.getUploadedBy());
                r.setBranchId(request.getBranchId());
                r.setOrgId(request.getOrgId());

                // 🔹 USE EXISTING SAVE LOGIC (IMPORTANT)
                ProductionEntry savedEntry = this.save(r);

                results.add(
                    new ProductionImportResult(
                        savedEntry.getBatchNo(),
                        "SUCCESS",
                        null
                    )
                );
                saved++;

            } catch (Exception ex) {

                results.add(
                    new ProductionImportResult(
                        r.getShift(), // fallback identifier
                        "FAILED",
                        ex.getMessage()
                    )
                );
                failed++;
            }
        }

        return new ProductionImportResponse(saved, failed, results);
    }
    @Override
    public Map<String, Object> importExcel(Map<String, Object> body) {

        List<Map<String, Object>> rows =
                (List<Map<String, Object>>) body.get("rows");

        int saved = 0;
        int failed = 0;
        List<Map<String, String>> results = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            try {
                ProductionEntry e = new ProductionEntry();

                // 🔥 Map Excel columns EXACTLY as Excel header names
                e.setShift(get(row, "Shift"));
                e.setBatchNo(get(row, "Batch No"));

                e.setSiloNo1(get(row, "Silo No 1"));
                e.setLiterWeight1(toDouble(row.get("Liter Weight 1")));
                e.setFaSolid1(toDouble(row.get("FA Solid 1")));

                e.setSiloNo2(get(row, "Silo No 2"));
                e.setLiterWeight2(toDouble(row.get("Liter Weight 2")));
                e.setFaSolid2(toDouble(row.get("FA Solid 2")));

                e.setWaterLiter(toDouble(row.get("Water Liter")));
                e.setCementKg(toDouble(row.get("Cement Kg")));
                e.setLimeKg(toDouble(row.get("Lime Kg")));
                e.setGypsumKg(toDouble(row.get("Gypsum Kg")));
                e.setSolOilKg(toDouble(row.get("Sol Oil Kg")));
                e.setAiPowerGm(toDouble(row.get("AI Power gm")));
                e.setTempC(toDouble(row.get("Temperature")));

                e.setCastingTime(get(row, "Casting Time"));
                e.setProductionTime(get(row, "Production Time"));
                e.setProductionRemark(get(row, "Production Remark"));
                e.setRemark(get(row, "Remark"));

                repository.save(e);
                saved++;

                results.add(Map.of("status", "SUCCESS"));

            } catch (Exception ex) {
                failed++;
                results.add(Map.of(
                    "status", "FAILED",
                    "error", ex.getMessage()
                ));
            }
        }

        return Map.of(
            "saved", saved,
            "failed", failed,
            "results", results
        );
    }
    private String get(Map<String, Object> row, String key) {
        Object v = row.get(key);
        return v == null ? null : v.toString();
    }

    private Double toDouble(Object v) {
        if (v == null || v.toString().isEmpty()) return null;
        return Double.parseDouble(v.toString());
    }
    private String now() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    @Override
    public List<Map<String, Object>> getDashboard() {

        List<ProductionEntry> productions = repository.findAll();
        List<Map<String, Object>> list = new ArrayList<>();

        for (ProductionEntry p : productions) {

            Map<String, Object> row = new HashMap<>();

            Date productionTime = p.getCreatedDate();
            Date castingTime = null;
            Date cuttingTime = null;
            Date autoclaveTime = null;
            Date blockTime = null;
            Date cubeTime = null;
            Date rejectionTime = null;

            row.put("batchNo", p.getBatchNo());
            row.put("productionTime", productionTime);

            // 🔹 CASTING
            CastingHallReport casting =
                    castingRepo.findByBatchNo(p.getBatchNo());

            if (casting != null) {
                castingTime = casting.getCreatedDate();
                row.put("castingTime", castingTime);
            }

            // 🔹 CUTTING
            WireCuttingReport cutting =
                    cuttingRepo.findByBatchNo(p.getBatchNo());

            if (cutting != null) {
                cuttingTime = cutting.getCreatedDate();
                row.put("cuttingTime", cuttingTime);
            }

            // 🔹 AUTOCLAVE
            if (p.getBatchNo() != null) {
                try {
                    Integer batch = Integer.valueOf(p.getBatchNo());

                    AutoclaveCycle autoclave =
                            autoclaveRepo.findByAnyBatch(batch);

                    if (autoclave != null) {
                        autoclaveTime = autoclave.getCreatedDate();
                        row.put("autoclaveTime", autoclaveTime);
                    }

                } catch (NumberFormatException ignored) {}
            }

            // 🔹 BLOCK SEPARATING
            BlockSeparating block =
                    blockRepo.findByBatchNumber(p.getBatchNo());

            if (block != null) {
                blockTime = block.getCreatedDate();
                row.put("blockSeparatingTime", blockTime);
            }

            // 🔹 CUBE TEST
            CubeTestEntity cube =
                    cubeTestRepo.findByBatchNo(p.getBatchNo());

            if (cube != null) {
                cubeTime = cube.getCreatedDate();
                row.put("cubeTestTime", cubeTime);
            }

            // 🔹 REJECTION
            RejectionDataEntity rejection =
                    rejectionRepo.findByBatchNo(p.getBatchNo());

            if (rejection != null) {
                rejectionTime = rejection.getCreatedDate();
                row.put("rejectionTime", rejectionTime);
            }

            // ================= DIFF CALCULATION =================

            row.put("prodToCastingDiff", diffMinutes(productionTime, castingTime));
            row.put("castingToCuttingDiff", diffMinutes(castingTime, cuttingTime));
            row.put("cuttingToAutoclaveDiff", diffMinutes(cuttingTime, autoclaveTime));
            row.put("autoclaveToBlockDiff", diffMinutes(autoclaveTime, blockTime));
            row.put("blockToCubeDiff", diffMinutes(blockTime, cubeTime));
            row.put("cubeToRejectionDiff", diffMinutes(cubeTime, rejectionTime));

            // ⭐ ADD ROW
            list.add(row);
        }

        return list;
    }


    private Long diffMinutes(Date start, Date end) {
        if (start == null || end == null) return null;
        return (end.getTime() - start.getTime()) / (1000 * 60);
    }


}