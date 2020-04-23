package nl.sapperheroes.Mock;

import nl.sapperheroes.model.jobs.Job;
import nl.sapperheroes.model.user.Client;
import nl.sapperheroes.model.user.Hero;
import nl.sapperheroes.model.user.User;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MockDatabase {

//    public MockDatabase() {
//        createUserDatabase();
//    }

    private List<User> userList = new LinkedList<>();
    private List<Job> jobList = new LinkedList<>();

    public Job getJob(int jobId) {
        return jobList.stream().filter(job -> job.getId() == jobId).collect(Collectors.toList()).get(0);
    }

    public void addJobToList(Job job) {
        jobList.add(job);
    }

    public User getUser(int userId) {
        for (User user : userList) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    public void addUserToList(User user) {
        userList.add(user);
    }

    public List<User> getClientList() {
        return userList.stream().filter(user -> user.getClass().equals(Client.class)).collect(Collectors.toList());

    }

    public List<User> getHeroList() {
        return userList.stream().filter(user -> user.getClass().equals(Hero.class)).collect(Collectors.toList());
    }


    public void createUserDatabase() {
        User client1 = new Client();
        User client2 = new Client();

        client1.setCity("Bilthoven");
        client1.setCountry("Holland");
        client1.setFirstName("Martijn");
        client1.setLastName("Louzada");
        addUserToList(client1);

        User hero1 = new Hero();
        User hero2 = new Hero();

        hero1.setId(1);
        hero1.setFirstName("");
        hero1.setLastName("Meert");
        addUserToList(hero1);
    }
}