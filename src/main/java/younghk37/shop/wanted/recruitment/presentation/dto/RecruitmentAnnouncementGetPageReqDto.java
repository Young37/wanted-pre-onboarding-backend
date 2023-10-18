package younghk37.shop.wanted.recruitment.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
public class RecruitmentAnnouncementGetPageReqDto {
    @JsonProperty("page_range")
    private Integer pageRange;

}