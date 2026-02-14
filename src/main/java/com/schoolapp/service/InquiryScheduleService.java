package com.schoolapp.service;

//package com.Crmemp.service;
//
//import com.Crmemp.dto.InquiryScheduleDto;
import java.util.List;

import com.schoolapp.dao.InquiryScheduleDto;

//import com.Crmemp.dto.request.InquiryScheduleDto;

public interface InquiryScheduleService {

    InquiryScheduleDto save(InquiryScheduleDto dto);

    InquiryScheduleDto update(Long id, InquiryScheduleDto dto);

    List<InquiryScheduleDto> getAll();

    InquiryScheduleDto getById(Long id);

    void delete(Long id);
}
