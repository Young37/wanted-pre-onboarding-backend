package shop.younghk37.wanted.recruitment.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.younghk37.wanted.recruitment.domain.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}