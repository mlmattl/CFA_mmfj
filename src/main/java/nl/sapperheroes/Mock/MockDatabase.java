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
        User hero3 = new Hero();
        User hero4 = new Hero();

        hero1.setId(0);
        hero1.setFirstName("Frank");
        hero1.setLastName("Meert");
        hero1.setCity("Utrecht");
        hero1.setCountry("Holland");
        hero1.setEmail("frank@meert.com");
        hero1.setStreet("straat");
        hero1.setHouseNumber(5);
        hero1.setPostalCode("1234 AB");
        hero1.setPhoneNumber("1234567890");
        hero1.setPassword("password");

        hero2.setId(2);
        hero2.setFirstName("Roy");
        hero2.setLastName("van Straten");
        hero2.setCity("Velsenbroek");
        hero2.setCountry("Holland");
        hero2.setEmail("roy@straten.nl");
        hero2.setStreet("avenue");
        hero2.setHouseNumber(420);
        hero2.setPostalCode("2341 BA");
        hero2.setPhoneNumber("1234567890");
        hero2.setPassword("password");

        hero3.setId(4);
        hero3.setFirstName("Costas");
        hero3.setLastName("de Griek");
        hero3.setCity("Utrecht");
        hero3.setCountry("Holland");
        hero3.setEmail("costas@deGriek.com");
        hero3.setStreet("boulevard");
        hero3.setHouseNumber(101);
        hero3.setPostalCode("3412 AA");
        hero3.setPhoneNumber("1234567890");
        hero3.setPassword("password");

        hero4.setId(6);
        hero4.setFirstName("Diogo");
        hero4.setLastName("Rolo");
        hero4.setCity("Utrecht");
        hero4.setCountry("Holland");
        hero4.setEmail("Diogo@Rolo.com");
        hero4.setStreet("Park");
        hero4.setHouseNumber(89);
        hero4.setPostalCode("2341 BB");
        hero4.setPhoneNumber("1234567890");
        hero4.setPassword("password");










    }
}