package enoca.task.enocatask.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jdk.jfr.Timestamp;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "employee")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Employee extends BaseEntity {
    private String fullName;
    @Column(unique = true)
    private String email;
    private int age;
    @Timestamp
    private LocalDateTime entryDate = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="company_id")
    @JsonBackReference
    private Company company;


}