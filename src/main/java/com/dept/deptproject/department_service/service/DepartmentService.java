package com.dept.deptproject.department_service.service;

import com.dept.deptproject.department_service.dto.DepartmentDto;

public interface DepartmentService {
	
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
