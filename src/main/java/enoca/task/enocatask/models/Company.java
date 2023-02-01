package enoca.task.enocatask.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
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
