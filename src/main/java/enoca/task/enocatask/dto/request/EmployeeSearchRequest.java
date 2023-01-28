package enoca.task.enocatask.dto.request;

import lombok.Getter;

@Getter
public class EmployeeSearchRequest {
    private Long id;
    private String fullName;
    private String email;
    private int age;
}
