package younghk37.shop.wanted.recruitment.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecruitmentAnnouncementGetPageResDto {
    private Long company_id;
    private String company_name;
    private String position_name;
    private Integer reward_amount;
    private String content;
    private String nation;
    private String region;
}