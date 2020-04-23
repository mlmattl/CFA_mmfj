package nl.sapperheroes.service;

import nl.sapperheroes.Mock.MockDatabase;
import nl.sapperheroes.dao.JobDao;
import nl.sapperheroes.dao.UserDao;
import nl.sapperheroes.model.jobs.Job;
import nl.sapperheroes.model.user.Hero;
import nl.sapperheroes.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private MockDatabase mockDatabase;
    private JobDao jobDoa;
    private UserDao userDao;

//    @Autowired
//    public void setMockDatabase(MockDatabase mockDatabase) {
//        this.mockDatabase = mockDatabase;
//    }

    @Autowired
    public void setJobDoa(JobDao jobDoa) {
        this.jobDoa = jobDoa;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

//    public void createUser(User user) {
//        mockDatabase.addUserToList(user);
//        //hibernate shit
//    }
    @Transactional
    public void createUser(User user){
        userDao.saveOrUpdateUser(user);

    }

    public User getUser(int userId) {
        return mockDatabase.getUser(userId);
    }

    public List<User> getHeroList() {
        return mockDatabase.getHeroList();
    }

    public List<User> getClientList() {
        return mockDatabase.getClientList();
    }

    public void addJobtoHeroJobList(Job job, int heroId) {
        List<User> heroList = mockDatabase.getHeroList();
        Hero hero = (Hero) heroList.stream().filter(user -> user.getId() == heroId).collect(Collectors.toList()).get(0);
        hero.setJobToList(job);
    }
}
