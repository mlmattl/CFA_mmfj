package model.user;

import model.MatchingClass;
import model.jobs.Job;
import model.jobs.JobType;
import org.springframework.beans.factory.annotation.Autowired;

public class DamselInDistress extends User {

    MatchingClass matchingClass;
    private Job job;


    @Autowired
    public void setMatchingClass(MatchingClass matchingClass) {
        this.matchingClass = matchingClass;
    }

    public Job getJob() {
        return job;
    }

    public void createJob(JobType type) {
        this.job = new Job(type);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

