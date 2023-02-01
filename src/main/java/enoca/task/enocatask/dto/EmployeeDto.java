package enoca.task.enocatask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String fullName;
    private String email;
    private int age;
    private LocalDateTime entryDate;
    private EmployeeCompanyDto company;
}
