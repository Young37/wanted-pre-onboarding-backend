package shop.younghk37.wanted.recruitment.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
public class JobApplicationCreationReqDto {
    @JsonProperty("resume_id")
    private Long resumeId;
    @JsonProperty("recruitment_announcement_id")
    private Long recruitmentAnnouncementId;
}