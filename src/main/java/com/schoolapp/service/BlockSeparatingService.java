package com.schoolapp.service;
//package com.yourapp.blockseparating.service;

//import com.yourapp.blockseparating.dto.BlockSeparatingDTO;

import java.util.List;

import com.schoolapp.dao.BlockSeparatingDTO;

//import com.Crmemp.dto.request.BlockSeparatingDTO;

public interface BlockSeparatingService {

    BlockSeparatingDTO create(BlockSeparatingDTO dto);

    BlockSeparatingDTO update(Long id, BlockSeparatingDTO dto);

    List<BlockSeparatingDTO> getAll();

    BlockSeparatingDTO getById(Long id);

    void delete(Long id);
}

