package enoca.task.enocatask.service.abstracts;

import enoca.task.enocatask.dto.EmployeeDto;
import enoca.task.enocatask.dto.request.CreateEmployeeRequest;
import enoca.task.enocatask.dto.request.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeServiceImpl {
    EmployeeDto findEmployeeById(Long Id);

    EmployeeDto createEmployee(CreateEmployeeRequest request);

    EmployeeDto updateEmployeeById(Long id, UpdateEmployeeRequest request);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> listAllEmployee();
}
