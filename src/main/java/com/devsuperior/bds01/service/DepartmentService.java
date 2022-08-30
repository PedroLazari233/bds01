package com.devsuperior.bds01.service;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> findAll(){
        List<Department> departmentList = departmentRepository.findAll(Sort.by("name"));
        return departmentList.stream().map(department -> new DepartmentDTO(department)).collect(Collectors.toList());
    }
}
