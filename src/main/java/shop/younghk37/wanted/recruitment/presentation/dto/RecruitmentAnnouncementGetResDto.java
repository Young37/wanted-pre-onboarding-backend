package shop.younghk37.wanted.recruitment.presentation.dto;

import lombok.*;

@Builder
@Getter
@Setter
public class RecruitmentAnnouncementGetResDto {
    private Long id;
    private Long company_id;
    private String company_name;
    private String position_name;
    private Integer reward_amount;
    private String title;
    private String content;
    private String nation;
    private String region;
    private String skill_name;
}