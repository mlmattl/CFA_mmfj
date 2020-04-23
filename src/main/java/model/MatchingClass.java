package model;

import model.jobs.Job;
import model.user.DamselInDistress;
import model.user.Hero;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MatchingClass {

    private List<Hero> heroList;
    private List<DamselInDistress> damselInDistressList;

    public void addHelperToList(Hero hero) {
        heroList.add(hero);
    }

    public void addDemanderToList(DamselInDistress damselInDistress) {
        damselInDistressList.add(damselInDistress);
    }

    /**
     * create a map with demanders and their potential helpers, based upon jobTypes, not completed
     *
     * @return Hashmap with demanders and helpers
     */
    public Map<DamselInDistress, Hero> createDemandersHelpersMapOnType() {
        Map<DamselInDistress, Hero> map = new HashMap<>();

        for (DamselInDistress damselInDistress : damselInDistressList) {
            for (Hero hero : heroList) {
                List<Job> helperJobs = hero.getJobs();
                for (Job helperJob : helperJobs) {
                    if (damselInDistress.getJob().getType() == helperJob.getType() && !helperJob.isCompleted()) {
                        map.put(damselInDistress, hero);
                    }
                }
            }
        }
        return map;
    }

    public List<Job> createHeroList(DamselInDistress damselInDistress){
        List<Job> jobs = new LinkedList<>();
        for (Hero hero:heroList) {
         jobs = hero.getJobs().stream().filter(job -> job.getType()==damselInDistress.getJob().getType()).collect(Collectors.toList());
        }
        return jobs;
    }

}