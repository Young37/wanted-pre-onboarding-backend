package younghk37.shop.wanted.recruitment.domain.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class RecruitmentAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long companyId;
    private String companyName;
    private String positionName;
    private Integer rewardAmount;
    private String content;
    private String nation;
    private String region;
}
