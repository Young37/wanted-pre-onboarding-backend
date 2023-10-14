package younghk37.shop.wanted.recruitment.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import younghk37.shop.wanted.recruitment.domain.entity.RecruitmentAnnouncement;

@Repository
public interface RecruitmentAnnouncementRepository extends JpaRepository<RecruitmentAnnouncement, Long> {
}