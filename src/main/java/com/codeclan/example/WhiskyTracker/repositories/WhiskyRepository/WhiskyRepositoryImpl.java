package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findAllWhiskyByDistilleryAndAge(String distillery, int age){
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distilleries", "distilleriesAlias");
            cr.add(Restrictions.eq("distilleries.name", distillery));
            cr.add(Restrictions.eq("distilleries.age", age));

            result = cr.list();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Transactional
    public List<Whisky> findAllWhiskyByRegion(String region){
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distilleries", "distilleriesAlias");
            cr.add(Restrictions.eq("distilleriesAlias.region", region));

            result = cr.list();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
