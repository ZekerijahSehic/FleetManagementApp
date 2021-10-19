package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.JobTitle;
import com.zekerijah.fleetmanagement.repository.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    public List<JobTitle> getJobsTitles() {
        return jobTitleRepository.findAll();
    }

    public void saveJobTitle(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    public Optional<JobTitle> getJobTitleById(Integer id) {
        return jobTitleRepository.findById(id);
    }

    public void deleteJobTitleById(Integer id) {
        jobTitleRepository.deleteById(id);
    }
}
