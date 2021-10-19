package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.JobTitle;
import com.zekerijah.fleetmanagement.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobs-titles")
    public String getJobsTitle(Model model){
        List<JobTitle> jobTitleList = jobTitleService.getJobsTitles();
        model.addAttribute("jobsTitles", jobTitleList);
        return "job_title";
    }

    @PostMapping("/jobs-titles/add-new")
    public String addJobTitle(JobTitle jobTitle){
        jobTitleService.saveJobTitle(jobTitle);
        return "redirect:/jobs-titles";
    }

    @RequestMapping("/jobs-titles/find-by-id")
    @ResponseBody
    public Optional<JobTitle> getJobTitle(Integer id){
        return jobTitleService.getJobTitleById(id);
    }

    @RequestMapping(value = "/jobs-titles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateJobTitle(JobTitle jobTitle) {
        jobTitleService.saveJobTitle(jobTitle);
        return "redirect:/jobs-titles";
    }

    @RequestMapping(value = "/jobs-titles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteJobTitle(Integer id){
        jobTitleService.deleteJobTitleById(id);
        return "redirect:/jobs-titles";
    }
}
