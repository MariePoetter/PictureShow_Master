package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.Picture;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by poetterm on 02.10.2014.
 */
@ApplicationScoped
    public class PictureDao extends JpaDao<UuidId,Picture> {
    public PictureDao() {
        super(Picture.class);
    }

    @SuppressWarnings("unchecked")
    public Collection<Picture> findByTitle(String title) {
        Query query = entityManager.createQuery("select p from PICTURE p where p.title = :title");
        query.setParameter("title", title);
        return (Collection<Picture>)query.getResultList();
    }
}
