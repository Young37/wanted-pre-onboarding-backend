package younghk37.shop.wanted.recruitment.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import younghk37.shop.wanted.recruitment.domain.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}