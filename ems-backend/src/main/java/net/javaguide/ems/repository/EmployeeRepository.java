package net.javaguide.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguide.ems.entity.Employee;;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
