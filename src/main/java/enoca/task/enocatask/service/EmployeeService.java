package enoca.task.enocatask.service;

import enoca.task.enocatask.dto.EmployeeDto;
import enoca.task.enocatask.dto.converter.CompanyEmployeeDtoConverter;
import enoca.task.enocatask.dto.converter.EmployeeDtoConverter;
import enoca.task.enocatask.models.Company;
import enoca.task.enocatask.models.Employee;
import enoca.task.enocatask.repository.EmployeeRepository;
import enoca.task.enocatask.dto.request.CreateEmployeeRequest;
import enoca.task.enocatask.dto.request.UpdateEmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
   private final EmployeeRepository employeeRepository;
   private final CompanyService companyService;
   private final EmployeeDtoConverter employeeDtoConverter;

   public EmployeeDto findEmployeeById(Long Id){
       return employeeDtoConverter.convertToEmployeeDto(employeeRepository.findById(Id).orElseThrow());
   }

    public EmployeeDto createEmployee(CreateEmployeeRequest request){
       Company company = companyService.findCompanyById(request.getCompanyId());

        Employee employee = new Employee().builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .company(company)
                .age(request.getAge())
                .build();
        company.getEmployees().add(employee);
        return employeeDtoConverter.convertToEmployeeDto(employeeRepository.save(employee));

    }

    public EmployeeDto updateEmployeeById(Long id, UpdateEmployeeRequest request){
       Employee employee = employeeRepository.findEmployeeById(id);
       Employee updatedEmployee = new Employee().builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .age(request.getAge()).build();
       employee.setFullName(updatedEmployee.getFullName());
       employee.setAge(updatedEmployee.getAge());
       employee.setEmail(updatedEmployee.getEmail());

       return employeeDtoConverter.convertToEmployeeDto(employeeRepository.save(employee));
}

    public EmployeeDto getEmployeeById(Long id){
        return findEmployeeById(id);
    }

    public String deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
        return "employee has deleted succesfully ";
    }

    public List<EmployeeDto> listAllEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeDtoConverter::convertToEmployeeDto)
                .collect(Collectors.toList());
    }
}
