package shop.younghk37.wanted.recruitment.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.younghk37.wanted.recruitment.domain.entity.RecruitmentAnnouncementSkill;

@Repository
public interface RecruitmentAnnouncementSkillRepository extends JpaRepository<RecruitmentAnnouncementSkill, Long> {
    RecruitmentAnnouncementSkill findByRecruitmentAnnouncementId(Long recruitmentAnnouncementId);
    void deleteByRecruitmentAnnouncementId(Long recruitmentAnnouncementId);
}