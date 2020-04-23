package nl.sapperheroes.service;

import nl.sapperheroes.Mock.MockDatabase;
import nl.sapperheroes.model.jobs.Job;
import nl.sapperheroes.model.user.Client;
import nl.sapperheroes.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    private MockDatabase mockDatabase;

    @Autowired
    public void setMockDatabase(MockDatabase mockDatabase) {
        this.mockDatabase = mockDatabase;
    }

    public Job createJob(Job job, int clientId) {
        User user = mockDatabase.getUser(clientId);
        {
            if (user.getId() == clientId && user.getClass().equals(Client.class)) {
                Client client = (Client) user;
                client.setJob(job);
            }
            return job;
        }

    }

    public Job getJob(int jobId){
       return mockDatabase.getJob(jobId);
    }
}

