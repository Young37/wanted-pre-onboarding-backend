package younghk37.shop.wanted.recruitment.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import younghk37.shop.wanted.recruitment.application.service.RecruitmentService;
import younghk37.shop.wanted.recruitment.presentation.dto.RecruitmentAnnouncementCreationReqDto;
import younghk37.shop.wanted.recruitment.presentation.dto.RecruitmentAnnouncementModifyReqDto;

@RestController
@RequiredArgsConstructor
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @PostMapping("recruitment-announcement")
    public ResponseEntity<?> createRecruitmentAnnouncement(@RequestBody RecruitmentAnnouncementCreationReqDto reqDto) {
        recruitmentService.createRecruitmentAnnouncement(reqDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("recruitment-announcement/{id}")
    public ResponseEntity<?> createRecruitmentAnnouncement(@PathVariable Long id, @RequestBody RecruitmentAnnouncementModifyReqDto reqDto) {
        recruitmentService.modifyRecruitmentAnnouncement(id, reqDto);
        return ResponseEntity.ok(null);
    }
}