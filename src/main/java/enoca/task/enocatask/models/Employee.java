package enoca.task.enocatask.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString()
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Employee extends BaseEntity {
    private String fullName;
    @Column(unique = true)
    private String email;
    private int age;
    @CreationTimestamp
    private LocalDateTime entryDate;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="company_id")
    @JsonBackReference
    private Company company;


}