package enoca.task.enocatask.dto.converter;

import enoca.task.enocatask.dto.EmployeeCompanyDto;
import enoca.task.enocatask.models.Company;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCompanyDtoConverter {
    public EmployeeCompanyDto convertToDto(Company from){
        return EmployeeCompanyDto.builder()
                .companyName(from.getCompanyName())
                .id(from.getId())
                .build();
    }

}
