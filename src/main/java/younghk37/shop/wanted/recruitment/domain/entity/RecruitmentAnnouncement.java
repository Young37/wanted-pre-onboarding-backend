package younghk37.shop.wanted.recruitment.domain.entity;

import lombok.*;
import younghk37.shop.wanted.recruitment.presentation.dto.RecruitmentAnnouncementGetPageResDto;
import younghk37.shop.wanted.recruitment.presentation.dto.RecruitmentAnnouncementGetResDto;

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
                .content(content)
                .nation(nation)
                .region(region)
                .build();
    }

}
