package younghk37.shop.wanted.recruitment.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import younghk37.shop.wanted.recruitment.domain.entity.RecruitmentAnnouncement;

import javax.persistence.criteria.CriteriaBuilder;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecruitmentAnnouncementGetPageReqDto {
    @JsonProperty("page_range")
    private Integer pageRange;

}