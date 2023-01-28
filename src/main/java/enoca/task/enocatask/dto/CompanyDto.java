package enoca.task.enocatask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private String companyName;
    private Set<CompanyEmployeeDto> employees;
    private Long id;
}
