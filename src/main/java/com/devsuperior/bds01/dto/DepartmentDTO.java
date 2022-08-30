package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class DepartmentDTO {

    public Long id;
    public String name;

    public DepartmentDTO(){
    }

    public DepartmentDTO(final Department department){
        this.id = department.getId();
        this.name = department.getName();
    }
}
