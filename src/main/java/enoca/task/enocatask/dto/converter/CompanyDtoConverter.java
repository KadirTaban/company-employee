package enoca.task.enocatask.dto.converter;

import enoca.task.enocatask.models.Company;
import enoca.task.enocatask.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyDtoConverter {
    private final CompanyEmployeeDtoConverter companyEmployeeDtoConverter;

    public CompanyDto convertToCompanyDto(Company from){
        return CompanyDto.builder()
                .companyName(from.getCompanyName())
                .employees(from.getEmployees() == null ? null :
                        from.getEmployees().stream()
                                .map(companyEmployeeDtoConverter::convertToDto)
                                .collect(Collectors.toSet()))
                .id(from.getId())
                .build();

    }

}