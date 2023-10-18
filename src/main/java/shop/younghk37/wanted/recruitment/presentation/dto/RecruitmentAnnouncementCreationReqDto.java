package shop.younghk37.wanted.recruitment.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import shop.younghk37.wanted.recruitment.domain.entity.RecruitmentAnnouncement;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
public class RecruitmentAnnouncementCreationReqDto {
    @NotNull
    @JsonProperty("company_id")
    private Long companyId;
    @NotBlank
    @JsonProperty("position_name")
    private String positionName;
    @NotNull
    @Min(value = 0, message = "0 이상의 정수가 아닙니다")
    @JsonProperty("reward_amount")
    private Integer rewardAmount;
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private String nation;
    @NotNull
    private String region;
    @NotNull
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