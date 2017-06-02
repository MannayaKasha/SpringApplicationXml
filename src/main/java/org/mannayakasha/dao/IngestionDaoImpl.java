package org.mannayakasha.dao;

import org.hibernate.Session;
import org.mannayakasha.model.Ingestion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class IngestionDaoImpl implements IngestionDao {
    private static final Logger logger = LoggerFactory.getLogger(IngestionDaoImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addIngestion(Ingestion ingestion) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(ingestion);
        logger.info("Ingestion successfully saved. Ingestion details: " + ingestion);
    }

    @Override
    public void updateIngestion(Ingestion ingestion) {
        Session session = entityManager.unwrap(Session.class);
        session.update(ingestion);
        logger.info("Ingestion successfully updated. Ingestion details: " + ingestion);
    }

    @Override
    public void removeIngestion(int id) {
        Session session = entityManager.unwrap(Session.class);
        Ingestion ingestion = (Ingestion) session.load(Ingestion.class, new Integer(id));

        if(ingestion != null){
            session.delete(ingestion);
        }
        logger.info("Ingestion successfully removed. Ingestion details: " + ingestion);
    }

    @Override
    public Ingestion getIngestionById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Ingestion ingestion = (Ingestion) session.load(Ingestion.class, new Integer(id));
        logger.info("Ingestion successfully loaded. Ingestion details: " + ingestion);

        return ingestion;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ingestion> listIngestion() {
        Session session = entityManager.unwrap(Session.class);
        List<Ingestion> ingestionList = session.createQuery("from Ingestion").list();

        for(Ingestion ingestion: ingestionList){
            logger.info("Ingestion list: " + ingestion);
        }

        return ingestionList;
    }
}
