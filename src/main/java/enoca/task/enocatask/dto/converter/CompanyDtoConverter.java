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

                .id(from.getId())
                .build();

    }

}