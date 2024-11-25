package com.cseazeem.server.services;

import com.cseazeem.server.models.Applicant;
import com.cseazeem.server.models.Recruiter;
import com.cseazeem.server.repositories.ApplicantRepository;
import com.cseazeem.server.repositories.RecruiterRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private final ApplicantRepository applicantRepository;
    private final RecruiterRepository recruiterRepository;

    public UserService(ApplicantRepository applicantRepository, RecruiterRepository recruiterRepository) {
        this.applicantRepository = applicantRepository;
        this.recruiterRepository = recruiterRepository;
    }

    public Applicant getApplicant(Long id) {
        return applicantRepository.findById(id).orElse(null);
    }

    public Recruiter getRecruiter(Long id) {
        return recruiterRepository.findById(id).orElse(null);
    }

    public Object getUsers() {
        return Map.of("applicants", applicantRepository.findAll(), "recruiters", recruiterRepository.findAll());
    }
}
