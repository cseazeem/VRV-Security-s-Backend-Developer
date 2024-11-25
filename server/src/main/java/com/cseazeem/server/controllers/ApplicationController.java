package com.cseazeem.server.controllers;

import com.cseazeem.server.models.Application;
import com.cseazeem.server.dtos.ApplicationRequest;
import com.cseazeem.server.services.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${api.endpoints.base-url}/applications")
@CrossOrigin("*")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/new-application")
    public ResponseEntity<?> save(
            @RequestParam Long userId,
            @RequestParam Long jobId,
            @RequestBody ApplicationRequest applicationRequest
    ) {
        try {
            Application application = applicationService.save(userId, jobId, applicationRequest);
            return ResponseEntity.ok(application);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get-application")
    public ResponseEntity<?> get(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(applicationService.get(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/applications")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(applicationService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
