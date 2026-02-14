package com.schoolapp.service;

//import com.Crmemp.dto.request.CastingHallReportRequestDto;
//import com.Crmemp.dto.request.CastingImportRequestDto;
//import com.Crmemp.dto.request.CastingImportResponse;
//import com.Crmemp.dto.response.CastingHallReportResponseDto;
//import com.Crmemp.dto.response.CastingImportResponse;
//import com.Crmemp.entity.CastingHallReport;

import java.util.List;

import com.schoolapp.dao.CastingHallReportRequestDto;
import com.schoolapp.dao.CastingImportRequestDto;
import com.schoolapp.dao.CastingImportResponse;
import com.schoolapp.entity.CastingHallReport;

public interface CastingHallReportService {

	 CastingHallReport save(CastingHallReportRequestDto dto);

	    CastingHallReport update(Long id, CastingHallReportRequestDto dto);

	    void delete(Long id);

	    List<CastingHallReport> getAll();

	    CastingHallReport approve(Long id, Long userId, String role);

	    CastingHallReport reject(Long id, Long userId, String role, String reason);

	    CastingHallReport getById(Long id);
	    CastingImportResponse importCasting(CastingImportRequestDto dto);

}

