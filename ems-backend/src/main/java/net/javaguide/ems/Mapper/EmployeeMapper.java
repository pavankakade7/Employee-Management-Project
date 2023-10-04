package net.javaguide.ems.Mapper;

import net.javaguide.ems.dto.EmployeeDto;
import net.javaguide.ems.entity.Employee;

public class EmployeeMapper {
    
    public static EmployeeDto maptoEmployeeDto (Employee employee)
    {
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );
    }

    public static Employee maptoEmployee (EmployeeDto employeeDto)
    {
        return new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail()
        );
    }
}
