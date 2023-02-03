package enoca.task.enocatask.service;

import enoca.task.enocatask.dto.EmployeeDto;
import enoca.task.enocatask.dto.converter.EmployeeDtoConverter;
import enoca.task.enocatask.exception.CompanyEmployeeNotFoundException;
import enoca.task.enocatask.exception.GenericException;
import enoca.task.enocatask.models.Company;
import enoca.task.enocatask.models.Employee;
import enoca.task.enocatask.repository.EmployeeRepository;
import enoca.task.enocatask.dto.request.CreateEmployeeRequest;
import enoca.task.enocatask.dto.request.UpdateEmployeeRequest;
import enoca.task.enocatask.service.abstracts.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeServiceImpl {
   private final EmployeeRepository employeeRepository;
   private final CompanyService companyService;
   private final EmployeeDtoConverter employeeDtoConverter;



   @Override
   public EmployeeDto findEmployeeById(Long Id){
       return employeeDtoConverter.convertToEmployeeDto(employeeRepository.findById(Id).orElseThrow());
   }
   @Override
    public EmployeeDto createEmployee(CreateEmployeeRequest request){
       var isAlreadyExists = employeeRepository.existsByEmail(request.getEmail());
       if(isAlreadyExists){
           throw GenericException.builder()
                   .httpStatus(HttpStatus.FOUND)
                   .errorMessage(request.getEmail()+ " has already exists")
                   .build();
       }
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
    @Override
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
    @Override
    public EmployeeDto getEmployeeById(Long id){
        return findEmployeeById(id);
    }

    public String deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
        return "employee has deleted succesfully ";
    }
    @Override
    public List<EmployeeDto> listAllEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeDtoConverter::convertToEmployeeDto)
                .collect(Collectors.toList());
    }
}
