package enoca.task.enocatask.repository;

import enoca.task.enocatask.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Boolean existsByEmail(String email);
    @Query("SELECT e FROM Employee e WHERE e.company.id = ?1 ")
    List<Employee> getByCompanyId(Long id);

    Employee findEmployeeById(Long id);
    @Modifying
    @Query("DELETE FROM Employee e WHERE e.id = ?1 ")
    void deleteById(Long id);



}
