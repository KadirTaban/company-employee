package enoca.task.enocatask.dto.converter;

import enoca.task.enocatask.dto.CompanyEmployeeDto;
import enoca.task.enocatask.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class CompanyEmployeeDtoConverter {
    public CompanyEmployeeDto convertToDto(Employee from){
        return CompanyEmployeeDto.builder()
                .id(from.getId())
                .email(from.getEmail())
                .fullName(from.getFullName())
                .build();
    }

}
