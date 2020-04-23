package nl.sapperheroes.controller;

import nl.sapperheroes.model.jobs.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nl.sapperheroes.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {

    private JobService jobService;

    @Autowired
    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{custId}")
    public ResponseEntity<Job> createJob(@RequestBody Job job, @PathVariable Integer custId){
        jobService.createJob(job, custId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
