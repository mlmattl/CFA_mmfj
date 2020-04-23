package model.user;

import model.jobs.Job;
import model.jobs.JobType;
import java.util.List;
import java.util.stream.Collectors;

public class Hero extends User {

    private List<JobType> offeredJobTypes;
    private List<Job> jobs;

    public List<JobType> getOfferedJobTypes() {
        return offeredJobTypes;
    }

    public void setOfferedJobTypes(List<JobType> offeredJobTypes) {
        this.offeredJobTypes = offeredJobTypes;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Job> jobsDone(){
        return jobs.stream().filter(Job::isCompleted).collect(Collectors.toList());
    }

    public List<Job> jobsToDo(){
        return jobs.stream().filter(job -> !job.isCompleted()).collect(Collectors.toList());
    }


    public void offeredJobsType(JobType type){
        offeredJobTypes.add(type);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
