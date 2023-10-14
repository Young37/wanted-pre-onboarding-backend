package younghk37.shop.wanted.recruitment.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobApplicationCreationReqDto {
    @JsonProperty("resume_id")
    private Long resumeId;
    @JsonProperty("recruitment_announcement_id")
    private Long recruitmentAnnouncementId;
}