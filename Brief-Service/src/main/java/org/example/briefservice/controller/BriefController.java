package org.example.briefservice.controller;

import org.example.briefservice.model.Brief;
import org.example.briefservice.service.BriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/briefs")

public class BriefController {


    private final BriefService briefService;

    public BriefController(BriefService briefService) {
        this.briefService = briefService;
    }

    @PostMapping
    public ResponseEntity<Brief> create(@RequestBody Brief brief) {
        return ResponseEntity.ok(briefService.saveBrief(brief));
    }
}
