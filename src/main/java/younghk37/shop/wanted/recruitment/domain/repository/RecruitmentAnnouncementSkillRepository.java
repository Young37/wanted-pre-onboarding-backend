package younghk37.shop.wanted.recruitment.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import younghk37.shop.wanted.recruitment.domain.entity.RecruitmentAnnouncementSkill;

@Repository
public interface RecruitmentAnnouncementSkillRepository extends JpaRepository<RecruitmentAnnouncementSkill, Long> {
    RecruitmentAnnouncementSkill findByRecruitmentAnnouncementId(Long recruitmentAnnouncementId);
    void deleteByRecruitmentAnnouncementId(Long recruitmentAnnouncementId);
}