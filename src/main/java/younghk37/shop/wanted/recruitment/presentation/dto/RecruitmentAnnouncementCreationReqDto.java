package younghk37.shop.wanted.recruitment.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import younghk37.shop.wanted.recruitment.domain.entity.RecruitmentAnnouncement;

@Builder
@Getter
@Setter
public class RecruitmentAnnouncementCreationReqDto {
    @JsonProperty("company_id")
    private Long companyId;
    @JsonProperty("position_name")
    private String positionName;
    @JsonProperty("reward_amount")
    private Integer rewardAmount;
    private String title;
    private String content;
    private String nation;
    private String region;
    @JsonProperty("skill_name")
    private String skillName;

    public RecruitmentAnnouncement toEntity() {
        return RecruitmentAnnouncement.builder()
                .companyId(companyId)
                .positionName(positionName)
                .rewardAmount(rewardAmount)
                .title(title)
                .content(content)
                .nation(nation)
                .region(region)
                .build();
    }
}