package nl.sapperheroes.model.user;

import nl.sapperheroes.Mock.MockDatabase;
import nl.sapperheroes.model.jobs.Job;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;


public class Client extends User {

    private MockDatabase mockDatabase;
    private Job job;

    @Autowired
    public void setMockDatabase(MockDatabase mockDatabase) {
        this.mockDatabase = mockDatabase;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

