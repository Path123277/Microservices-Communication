package com.dept.deptproject.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dept.deptproject.department_service.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findByDepartmentCode(String departmentCode);

}
