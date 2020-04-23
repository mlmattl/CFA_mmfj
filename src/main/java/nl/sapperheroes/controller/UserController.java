package nl.sapperheroes.controller;

import nl.sapperheroes.model.jobs.Job;
import nl.sapperheroes.model.user.Client;
import nl.sapperheroes.model.user.Hero;
import nl.sapperheroes.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nl.sapperheroes.service.JobService;
import nl.sapperheroes.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private JobService jobService;

    @Autowired
    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    @Autowired
    public void setUserCreatorService(UserService userService) {
        this.userService = userService;
    }



    @RequestMapping(method = RequestMethod.POST, path = {"hero/", "/hero"})
    public ResponseEntity<User> createHero(@RequestBody Hero user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"client/", "/client"})
    public ResponseEntity<User> createClient(@RequestBody Client user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/job/{jobId}/hero/{heroId}")
    public ResponseEntity<User> jobConnectingToHero(@PathVariable int heroId, @PathVariable int jobId) {
        Job job = jobService.getJob(jobId);
        userService.addJobtoHeroJobList(job, heroId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId) {
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/heroList")
    public ResponseEntity<List<User>> getHeroList() {
        List<User> heros = userService.getHeroList();
        return new ResponseEntity<>(heros, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/clientList")
    public ResponseEntity<List<User>> getClientList() {
        List<User> clients = userService.getClientList();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
