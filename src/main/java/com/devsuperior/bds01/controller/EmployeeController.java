package com.devsuperior.bds01.controller;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.service.DepartmentService;
import com.devsuperior.bds01.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll(Pageable pageable){
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));
        Page<EmployeeDTO> list = employeeService.findAllPaged(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insertEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeDTO = employeeService.insertEmployee(employeeDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employeeDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(employeeDTO);
    }
}
