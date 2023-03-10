package enoca.task.enocatask.models;

import jakarta.persistence.*;
import lombok.Data;


@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

}
