package younghk37.shop.wanted.recruitment.application.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import younghk37.shop.wanted.recruitment.domain.entity.Company;
import younghk37.shop.wanted.recruitment.domain.entity.RecruitmentAnnouncement;
import younghk37.shop.wanted.recruitment.domain.repository.CompanyRepository;
import younghk37.shop.wanted.recruitment.domain.repository.RecruitmentAnnouncementRepository;
import younghk37.shop.wanted.recruitment.presentation.dto.RecruitmentAnnouncementCreationReqDto;
import younghk37.shop.wanted.recruitment.presentation.dto.RecruitmentAnnouncementGetPageResDto;
import younghk37.shop.wanted.recruitment.presentation.dto.RecruitmentAnnouncementModifyReqDto;

import java.util.List;
import java.util.stream.Collectors;

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

    public void removeRecruitmentAnnouncement(Long id) {
        RecruitmentAnnouncement announcement = recruitmentAnnouncementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다(id): " + id));

        recruitmentAnnouncementRepository.deleteById(id);
    }

    public List<RecruitmentAnnouncementGetPageResDto> getRecruitmentAnnouncementPage(int pageNum, int pageRange) {
        int adjustedPageNum = pageNum - 1;
        Pageable pageable = PageRequest.of(adjustedPageNum, pageRange);

        List<RecruitmentAnnouncement> recruitmentAnnouncementList = recruitmentAnnouncementRepository.findAll(pageable).getContent();

        List<RecruitmentAnnouncementGetPageResDto> dtos = recruitmentAnnouncementList.stream()
                .map(this::mapRecruitmentAnnouncementToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    private RecruitmentAnnouncementGetPageResDto mapRecruitmentAnnouncementToDto(RecruitmentAnnouncement announcement) {
        return RecruitmentAnnouncementGetPageResDto.builder()
                .company_id(announcement.getCompanyId())
                .company_name(announcement.getCompanyName())
                .position_name(announcement.getPositionName())
                .reward_amount(announcement.getRewardAmount())
                .content(announcement.getContent())
                .nation(announcement.getNation())
                .region(announcement.getRegion())
                .build();
    }
}