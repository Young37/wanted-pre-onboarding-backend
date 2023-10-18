package shop.younghk37.wanted.recruitment.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.younghk37.wanted.recruitment.domain.entity.*;
import shop.younghk37.wanted.recruitment.domain.repository.*;
import shop.younghk37.wanted.recruitment.exception.IllegalRequestException;
import shop.younghk37.wanted.recruitment.presentation.dto.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecruitmentService {
    private final CompanyRepository companyRepository;
    private final RecruitmentAnnouncementRepository recruitmentAnnouncementRepository;
    private final RecruitmentAnnouncementSkillRepository recruitmentAnnouncementSkillRepository;
    private final ResumeRepository resumeRepository;
    private final JobApplicationRepository jobApplicationRepository;

    @Transactional(rollbackFor = Exception.class)
    public void createRecruitmentAnnouncement(RecruitmentAnnouncementCreationReqDto reqDto) {
        RecruitmentAnnouncement recruitmentAnnouncement = reqDto.toEntity();
        Company company = companyRepository.findById(reqDto.getCompanyId())
                .orElseThrow(() -> new IllegalRequestException("잘못된 입력입니다(company_id):" + reqDto.getCompanyId()));

        recruitmentAnnouncement.setCompanyName(company.getName());
        recruitmentAnnouncementRepository.save(recruitmentAnnouncement);

        Long recruitmentAnnouncementId = recruitmentAnnouncement.getId();
        RecruitmentAnnouncementSkill recruitmentAnnouncementSkill = RecruitmentAnnouncementSkill.builder()
                        .recruitmentAnnouncementId(recruitmentAnnouncementId)
                        .skillName(reqDto.getSkillName())
                        .build();
        recruitmentAnnouncementSkillRepository.save(recruitmentAnnouncementSkill);
    }

    @Transactional(rollbackFor = Exception.class)
    public void modifyRecruitmentAnnouncement(Long id, RecruitmentAnnouncementModifyReqDto reqDto) {
        RecruitmentAnnouncement announcement = recruitmentAnnouncementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다(id): " + id));

        announcement.setPositionName(reqDto.getPosition_name());
        announcement.setRewardAmount(reqDto.getReward_amount());
        announcement.setTitle(reqDto.getTitle());
        announcement.setContent(reqDto.getContent());
        announcement.setNation(reqDto.getNation());
        announcement.setRegion(reqDto.getRegion());
        recruitmentAnnouncementRepository.save(announcement);

        RecruitmentAnnouncementSkill recruitmentAnnouncementSkill = recruitmentAnnouncementSkillRepository.findByRecruitmentAnnouncementId(id);

        recruitmentAnnouncementSkill.setSkillName(reqDto.getSkill_name());
        recruitmentAnnouncementSkillRepository.save(recruitmentAnnouncementSkill);
    }

    @Transactional(rollbackFor = Exception.class)
    public void removeRecruitmentAnnouncement(Long id) {
        RecruitmentAnnouncement announcement = recruitmentAnnouncementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다(id): " + id));

        recruitmentAnnouncementSkillRepository.deleteByRecruitmentAnnouncementId(id);
        recruitmentAnnouncementRepository.deleteById(id);
    }

    public List<RecruitmentAnnouncementGetPageResDto> getRecruitmentAnnouncementPage(int pageNum, int pageRange) {
        int adjustedPageNum = pageNum - 1;
        Pageable pageable = PageRequest.of(adjustedPageNum, pageRange);

        List<RecruitmentAnnouncement> recruitmentAnnouncementList = recruitmentAnnouncementRepository.findAll(pageable).getContent();

        List<RecruitmentAnnouncementGetPageResDto> dtos = recruitmentAnnouncementList.stream()
                .map(RecruitmentAnnouncement::toRecruitmentAnnouncementGetPageResDto)
                .collect(Collectors.toList());

        return dtos;
    }

    public RecruitmentAnnouncementGetResDto getRecruitmentAnnouncement(Long id) {
        RecruitmentAnnouncement announcement = recruitmentAnnouncementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다(id): " + id));

        RecruitmentAnnouncementSkill recruitmentAnnouncementSkill = recruitmentAnnouncementSkillRepository.findByRecruitmentAnnouncementId(id);

        RecruitmentAnnouncementGetResDto result = announcement.toRecruitmentAnnouncementGetResDto();
        result.setSkill_name(recruitmentAnnouncementSkill.getSkillName());
        return result;
    }

    public void createJobApplication(JobApplicationCreationReqDto reqDto) {
        Resume resume = resumeRepository.findById(reqDto.getResumeId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다(resume_id): " + reqDto.getResumeId()));

        RecruitmentAnnouncement recruitmentAnnouncement = recruitmentAnnouncementRepository.findById(reqDto.getRecruitmentAnnouncementId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다(recruitment_announcement_id): " + reqDto.getRecruitmentAnnouncementId()));

        JobApplication jobApplication = JobApplication.builder()
                        .resumeId(reqDto.getResumeId())
                        .recruitmentAnnouncementId(reqDto.getRecruitmentAnnouncementId())
                        .build();

        jobApplicationRepository.save(jobApplication);
    }
}