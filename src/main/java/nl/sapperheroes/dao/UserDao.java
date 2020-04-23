package nl.sapperheroes.dao;

import nl.sapperheroes.model.jobs.Job;
import nl.sapperheroes.model.user.Client;
import nl.sapperheroes.model.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDao extends GenericDao{


    public User findUserById(Integer id) {
        return em.find(User.class, id);
    }

    public User saveOrUpdateUser(User user){
        System.out.println(user);
        return em.merge(user);
    }

    public void deleteUser(Integer id) {
        em.remove(em.find(User.class, id));
    }

    public List<User> listAllUsers() {
        CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

}
