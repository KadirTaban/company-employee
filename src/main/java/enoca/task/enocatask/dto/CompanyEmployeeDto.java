package enoca.task.enocatask.dto;

import enoca.task.enocatask.models.Company;
import enoca.task.enocatask.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEmployeeDto {
    private Long id;
    private String fullName;
    private String email;
    private LocalDateTime entryDate;
    private int age;
}
