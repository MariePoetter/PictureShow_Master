package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.Build;
import de.dhbw.pictureshow.domain.User;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by poetterm on 23.09.2014.
 */
@ApplicationScoped
public class BildDao extends JpaDao<UuidId,Build> {

    public BildDao() {
        super(Build.class);
    }

    public List<Build> findByUser(User user) {
        TypedQuery<Build> query = entityManager.createQuery(
                "SELECT b FROM Build b WHERE b.user= :user", Build.class);
        query.setParameter("user",user);

        return query.getResultList();



    }
}


