package org.mannayakasha.service;

import org.mannayakasha.dao.IngestionDao;
import org.mannayakasha.model.Ingestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngestionServiceImpl implements IngestionService {

    @Autowired
    private IngestionDao ingestionDao;

    public void setIngestionDao(IngestionDao ingestionDao) {
        this.ingestionDao = ingestionDao;
    }

    @Override
    public void addIngestion(Ingestion ingestion) {
        this.ingestionDao.addIngestion(ingestion);
    }

    @Override
    public void updateIngestion(Ingestion ingestion) {
        this.ingestionDao.updateIngestion(ingestion);
    }

    @Override
    public void removeIngestion(int id) {
        this.ingestionDao.removeIngestion(id);
    }

    @Override
    public Ingestion getIngestionById(int id) {
        return this.ingestionDao.getIngestionById(id);
    }

    @Override
    public List<Ingestion> listIngestion() {
        return this.ingestionDao.listIngestion();
    }
}
