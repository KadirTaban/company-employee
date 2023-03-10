package enoca.task.enocatask.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "company")
@Data
@ToString()
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Company extends BaseEntity {

    @Column(unique = true)
    private String companyName;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY,orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Employee> employees;



}
