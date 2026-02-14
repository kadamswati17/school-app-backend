package com.schoolapp.service;

//package com.crmemp.service;

//import com.crmemp.dto.AutoclaveDTO;
import java.util.List;

import com.schoolapp.dao.AutoclaveDTO;

//import com.Crmemp.dto.request.AutoclaveDTO;

public interface AutoclaveService {

    AutoclaveDTO save(AutoclaveDTO dto);

    List<AutoclaveDTO> getAll();

    AutoclaveDTO getById(Long id);

    void delete(Long id);
    AutoclaveDTO update(Long id, AutoclaveDTO dto);

}

