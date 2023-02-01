package enoca.task.enocatask.service.abstracts;

import enoca.task.enocatask.dto.CompanyDto;
import enoca.task.enocatask.dto.EmployeeDto;
import enoca.task.enocatask.dto.request.CreateCompanyRequest;
import enoca.task.enocatask.dto.request.UpdateCompanyRequest;
import enoca.task.enocatask.models.Company;

import java.util.List;

public interface CompanyServiceImpl {
    Company findCompanyById(Long Id);

    CompanyDto createCompany(CreateCompanyRequest request);

    List<EmployeeDto> listCompanyEmployee(Long id);

    List<CompanyDto> listCompanyAll();

    CompanyDto updateCompanyById(Long id, UpdateCompanyRequest request);

    String deleteCompanyById(Long id);
}
