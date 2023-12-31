package shop.younghk37.wanted.recruitment.domain.entity;

import lombok.*;
import shop.younghk37.wanted.recruitment.presentation.dto.RecruitmentAnnouncementGetPageResDto;
import shop.younghk37.wanted.recruitment.presentation.dto.RecruitmentAnnouncementGetResDto;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class RecruitmentAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long companyId;
    private String companyName;
    private String positionName;
    private Integer rewardAmount;
    private String title;
    private String content;
    private String nation;
    private String region;

    public RecruitmentAnnouncementGetPageResDto toRecruitmentAnnouncementGetPageResDto() {
        return RecruitmentAnnouncementGetPageResDto.builder()
                .id(id)
                .company_id(companyId)
                .company_name(companyName)
                .position_name(positionName)
                .reward_amount(rewardAmount)
                .title(title)
                .nation(nation)
                .region(region)
                .build();
    }

    public RecruitmentAnnouncementGetResDto toRecruitmentAnnouncementGetResDto() {
        return RecruitmentAnnouncementGetResDto.builder()
                .id(id)
                .company_id(companyId)
                .company_name(companyName)
                .position_name(positionName)
                .reward_amount(rewardAmount)
                .title(title)
                .content(content)
                .nation(nation)
                .region(region)
                .build();
    }

}
