package net.javaguide.ems.service.impl;

import java.util.List;
import java.util.stream.Collector;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguide.ems.Mapper.EmployeeMapper;
import net.javaguide.ems.dto.EmployeeDto;
import net.javaguide.ems.entity.Employee;
import net.javaguide.ems.exception.ResourceNotFoundException;
import net.javaguide.ems.repository.EmployeeRepository;
import net.javaguide.ems.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeerepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'createEmployee'");

        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = employeerepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeerepository.findById(employeeId)
            .orElseThrow(() ->
             new ResourceNotFoundException("Employee is not exits with given id : " + employeeId ));
              
        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    
    public List <EmployeeDto> getAllEmployees(){
       List<Employee> employees =  employeerepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.maptoEmployeeDto(employee) )
            .toList();
    }
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");

        Employee employee = employeerepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee is not with gieven id : " + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

       Employee updatedEmployeeObj =  employeerepository.save(employee);

        return EmployeeMapper.maptoEmployeeDto(updatedEmployeeObj);
    }
    @Override
    public void deleteEmployee(Long employeeId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");

        Employee employee = employeerepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee is not with gieven id : " + employeeId));
        

        employeerepository.deleteById(employeeId);

    }
    
}
