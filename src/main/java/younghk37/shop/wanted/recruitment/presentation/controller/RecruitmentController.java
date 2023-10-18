package younghk37.shop.wanted.recruitment.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import younghk37.shop.wanted.recruitment.aop.annotation.ValidAop;
import younghk37.shop.wanted.recruitment.application.service.RecruitmentService;
import younghk37.shop.wanted.recruitment.presentation.dto.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @ValidAop
    @PostMapping("/recruitment-announcement")
    public ResponseEntity<?> createRecruitmentAnnouncement(@Valid @RequestBody RecruitmentAnnouncementCreationReqDto reqDto, BindingResult bindingResult) {
        recruitmentService.createRecruitmentAnnouncement(reqDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/recruitment-announcement/{id}")
    public ResponseEntity<?> createRecruitmentAnnouncement(@PathVariable Long id, @RequestBody RecruitmentAnnouncementModifyReqDto reqDto) {
        recruitmentService.modifyRecruitmentAnnouncement(id, reqDto);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/recruitment-announcement/{id}")
    public ResponseEntity<?> removeRecruitmentAnnouncement(@PathVariable Long id) {
        recruitmentService.removeRecruitmentAnnouncement(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/recruitment-announcement/page/{pageNum}")
    public ResponseEntity<?> getRecruitmentAnnouncementPage(@PathVariable int pageNum, @RequestBody RecruitmentAnnouncementGetPageReqDto recruitmentAnnouncementGetPageReqDto) {
        int pageRange = 10;
        if(recruitmentAnnouncementGetPageReqDto.getPageRange() != null) {
            pageRange = recruitmentAnnouncementGetPageReqDto.getPageRange();
        }

        List<RecruitmentAnnouncementGetPageResDto> result = recruitmentService.getRecruitmentAnnouncementPage(pageNum, pageRange);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/recruitment-announcement/{id}")
    public ResponseEntity<?> getRecruitmentAnnouncement(@PathVariable Long id) {
        RecruitmentAnnouncementGetResDto result = recruitmentService.getRecruitmentAnnouncement(id);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/job-application")
    public ResponseEntity<?> createJobApplication(@RequestBody JobApplicationCreationReqDto reqDto) {
        recruitmentService.createJobApplication(reqDto);
        return ResponseEntity.ok(null);
    }

}