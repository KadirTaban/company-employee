package enoca.task.enocatask.service;

import enoca.task.enocatask.exception.GenericException;
import enoca.task.enocatask.dto.CompanyDto;
import enoca.task.enocatask.dto.EmployeeDto;
import enoca.task.enocatask.dto.converter.CompanyDtoConverter;
import enoca.task.enocatask.models.Company;
import enoca.task.enocatask.repository.CompanyRepository;
import enoca.task.enocatask.repository.EmployeeRepository;
import enoca.task.enocatask.dto.converter.EmployeeDtoConverter;
import enoca.task.enocatask.dto.request.CreateCompanyRequest;
import enoca.task.enocatask.dto.request.UpdateCompanyRequest;
import enoca.task.enocatask.service.abstracts.CompanyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService implements CompanyServiceImpl {
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyDtoConverter companyDtoConverter;
    private final EmployeeDtoConverter employeeDtoConverter;
    @Override
    public Company findCompanyById(Long Id) {
        return companyRepository.findById(Id).orElseThrow(
                () -> GenericException.builder()
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .errorMessage("Id: "+ Id + " address not found")
                        .build());
    }
    @Override
    public CompanyDto createCompany(CreateCompanyRequest request){

        var company = Company.builder()
                .companyName(request.getCompanyName())
                .build();
        return companyDtoConverter.convertToCompanyDto(companyRepository.save(company));

    }
    @Override
    public List<EmployeeDto> listCompanyEmployee(Long id){

        return employeeRepository.getByCompanyId(id) //employeeRepository
                .stream()
                .map(employeeDtoConverter::convertToEmployeeDto)
                .collect(Collectors.toList());

    }
    @Override
    public List<CompanyDto> listCompanyAll(){
        return companyRepository.findAll()
                .stream()
                .map(companyDtoConverter::convertToCompanyDto)
                .collect(Collectors.toList());
    }
    @Override
    public CompanyDto updateCompanyById(Long id, UpdateCompanyRequest request){
        Company company = findCompanyById(id);
        Company updatedCompany = new Company().builder()
                .companyName(request.getCompanyName())
                .build();
        company.setCompanyName(updatedCompany.getCompanyName());
        return companyDtoConverter.convertToCompanyDto(companyRepository.save(company));

    }
    @Override
    public String deleteCompanyById(Long id){
        Company company = findCompanyById(id);
        companyRepository.delete(company);
        return company.getCompanyName()+" has deleted succesfully";
    }




}
