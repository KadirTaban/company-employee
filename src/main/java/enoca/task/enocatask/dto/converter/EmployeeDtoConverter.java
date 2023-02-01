package enoca.task.enocatask.dto.converter;

import enoca.task.enocatask.dto.EmployeeDto;
import enoca.task.enocatask.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeDtoConverter {

    private final EmployeeCompanyDtoConverter employeeCompanyDtoConverter;
    public EmployeeDto convertToEmployeeDto(Employee from){
        return EmployeeDto.builder()
                .id(from.getId())
                .email(from.getEmail())
                .fullName(from.getFullName())
                .age(from.getAge())
                .entryDate(from.getEntryDate())
                .company(employeeCompanyDtoConverter.convertToDto(from.getCompany()))
                .build();

    }

}
