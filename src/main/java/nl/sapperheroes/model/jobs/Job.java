package nl.sapperheroes.model.jobs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Job {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private JobType type;
    private String description;
    private boolean completed;
    private Date jobTimeAndDate;

    public Job(){};

    public Job(JobType type) {
        id++;
        this.type = type;
    }

    public Date getJobTimeAndDate() {
        return jobTimeAndDate;
    }

    public void setJobTimeAndDate(Date jobTimeAndDate) {
        this.jobTimeAndDate = jobTimeAndDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
