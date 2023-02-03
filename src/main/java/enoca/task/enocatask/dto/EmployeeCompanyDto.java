package enoca.task.enocatask.dto;

import enoca.task.enocatask.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCompanyDto {
    private String companyName;
    private Long id;
}
