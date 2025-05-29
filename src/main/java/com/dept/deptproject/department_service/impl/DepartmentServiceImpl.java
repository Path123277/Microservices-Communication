package com.dept.deptproject.department_service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dept.deptproject.department_service.dto.DepartmentDto;
import com.dept.deptproject.department_service.entity.Department;
import com.dept.deptproject.department_service.repository.DepartmentRepository;
import com.dept.deptproject.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

    	  Department department=new Department(
    			  departmentDto.getId(),
    			  departmentDto.getDepartmentName(),
    			  departmentDto.getDepartmentDescription(),
    			  departmentDto.getDepartmentCode()  
    			  );
    		
          Department savedDepartment = departmentRepository.save(department);

    	System.out.println("Department services");
        // convert department dto to department jpa entity
        //Department department = DepartmentMapper.mapToDepartment(departmentDto);
        //Department savedDepartment = departmentRepository.save(department);
        //DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
          DepartmentDto  savedDepartmentDto=new DepartmentDto(
        		  savedDepartment.getId(),
        		  savedDepartment.getDepartmentName(),
        		  savedDepartment.getDepartmentDescription(),
        		  savedDepartment.getDepartmentCode()
        		  );
        		  
        return savedDepartmentDto;
    }

  @Override
  public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);
       
        DepartmentDto departmentDto =new DepartmentDto(
        		department.getId(),
        		department.getDepartmentName(),
        		department.getDepartmentDescription(),
        		department.getDepartmentCode()
        		
        		);
               
        
        //DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    } 
}
