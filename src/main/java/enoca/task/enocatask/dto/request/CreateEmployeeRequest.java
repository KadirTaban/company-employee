package enoca.task.enocatask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateEmployeeRequest {
    private Long companyId;
    @NotBlank(message = "fullName can not be empty")//jakarta validation
    private String fullName;
    @NotEmpty
    private String email;
    @NotEmpty
    private int age;
}

