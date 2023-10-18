package younghk37.shop.wanted.recruitment.presentation.dto;

import lombok.*;

@Builder
@Getter
@Setter
public class RecruitmentAnnouncementModifyReqDto {
    private String position_name;
    private int reward_amount;
    private String title;
    private String content;
    private String nation;
    private String region;
    private String skill_name;

//    public RecruitmentAnnouncement toEntity() {
//        return RecruitmentAnnouncement.builder()
//                .positionName(position_name)
//                .rewardAmount(reward_amount)
//                .content(content)
//                .nation(nation)
//                .region(region)
//                .build();
//    }
}


