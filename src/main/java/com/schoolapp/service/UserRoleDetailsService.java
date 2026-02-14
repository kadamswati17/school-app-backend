package com.schoolapp.service;

//import com.Crmemp.dto.request.UserRoleDetailsDto;
//import com.Crmemp.entity.UserRoleDetails;
//import com.Crmemp.repository.UserRoleDetailsRepository;

import org.springframework.stereotype.Service;

import com.schoolapp.dao.UserRoleDetailsDto;
import com.schoolapp.entity.UserRoleDetails;
import com.schoolapp.repository.UserRoleDetailsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleDetailsService {

    private final UserRoleDetailsRepository repo;

    public UserRoleDetailsService(UserRoleDetailsRepository repo) {
        this.repo = repo;
    }

    // CREATE / UPDATE
    public UserRoleDetailsDto save(UserRoleDetailsDto dto) {

        UserRoleDetails entity =
                dto.getId() != null
                        ? repo.findById(dto.getId()).orElse(new UserRoleDetails())
                        : new UserRoleDetails();

        entity.setUsername(dto.getUsername());
        entity.setRootName(dto.getRootName());
        entity.setGstNo(dto.getGstNo());
        entity.setAddress(dto.getAddress());
        entity.setState(dto.getState());
        entity.setCity(dto.getCity());
        entity.setDist(dto.getDist());
        entity.setTq(dto.getTq());
        entity.setBalance(dto.getBalance());

        return toDto(repo.save(entity));
    }

    // READ ALL
    public List<UserRoleDetailsDto> getAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    // DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // DTO MAPPER
    private UserRoleDetailsDto toDto(UserRoleDetails u) {
        UserRoleDetailsDto dto = new UserRoleDetailsDto();
        dto.setId(u.getId());
        dto.setUsername(u.getUsername());
        dto.setRootName(u.getRootName());
        dto.setGstNo(u.getGstNo());
        dto.setAddress(u.getAddress());
        dto.setState(u.getState());
        dto.setCity(u.getCity());
        dto.setDist(u.getDist());
        dto.setTq(u.getTq());
        dto.setBalance(u.getBalance());
        return dto;
    }
    
}
