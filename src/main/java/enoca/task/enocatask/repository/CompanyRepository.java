package enoca.task.enocatask.repository;

import enoca.task.enocatask.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Boolean existsByCompanyName(String companyName);
}
