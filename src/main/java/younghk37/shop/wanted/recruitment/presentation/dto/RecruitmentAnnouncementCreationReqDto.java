package younghk37.shop.wanted.recruitment.presentation.dto;

import lombok.*;
import younghk37.shop.wanted.recruitment.domain.entity.RecruitmentAnnouncement;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecruitmentAnnouncementCreationReqDto {
    private Long company_id;
    private String position_name;
    private Integer reward_amount;
    private String content;
    private String nation;
    private String region;

    public RecruitmentAnnouncement toEntity() {
        return RecruitmentAnnouncement.builder()
                .companyId(company_id)
                .positionName(position_name)
                .rewardAmount(reward_amount)
                .content(content)
                .nation(nation)
                .region(region)
                .build();
    }
}