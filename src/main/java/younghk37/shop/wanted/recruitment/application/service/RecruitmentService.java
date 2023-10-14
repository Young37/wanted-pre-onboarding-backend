package younghk37.shop.wanted.recruitment.application.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import younghk37.shop.wanted.recruitment.domain.entity.Company;
import younghk37.shop.wanted.recruitment.domain.entity.RecruitmentAnnouncement;
import younghk37.shop.wanted.recruitment.domain.repository.CompanyRepository;
import younghk37.shop.wanted.recruitment.domain.repository.RecruitmentAnnouncementRepository;
import younghk37.shop.wanted.recruitment.presentation.dto.RecruitmentAnnouncementCreationReqDto;
import younghk37.shop.wanted.recruitment.presentation.dto.RecruitmentAnnouncementModifyReqDto;

@Service
@RequiredArgsConstructor
public class RecruitmentService {
    private final CompanyRepository companyRepository;
    private final RecruitmentAnnouncementRepository recruitmentAnnouncementRepository;

    public void createRecruitmentAnnouncement(RecruitmentAnnouncementCreationReqDto reqDto) {
        RecruitmentAnnouncement recruitmentAnnouncement = reqDto.toEntity();
        Company company = companyRepository.findById(reqDto.getCompany_id())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다(company_id):" + reqDto.getCompany_id()));
        
        recruitmentAnnouncement.setCompanyName(company.getName());
        recruitmentAnnouncementRepository.save(recruitmentAnnouncement);
    }

    @Transactional(rollbackFor = Exception.class)
    public void modifyRecruitmentAnnouncement(Long id, RecruitmentAnnouncementModifyReqDto reqDto) {

        RecruitmentAnnouncement announcement = recruitmentAnnouncementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다(id): " + id));

        announcement.setPositionName(reqDto.getPosition_name());
        announcement.setRewardAmount(reqDto.getReward_amount());
        announcement.setContent(reqDto.getContent());
        announcement.setNation(reqDto.getNation());
        announcement.setRegion(reqDto.getRegion());

        recruitmentAnnouncementRepository.save(announcement);
    }
}