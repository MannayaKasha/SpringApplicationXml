package org.mannayakasha.dao;

import org.mannayakasha.model.Ingestion;

import java.util.List;

public interface IngestionDao {

    void addIngestion(Ingestion ingestion);

    void updateIngestion(Ingestion ingestion);

    void removeIngestion(int id);

    Ingestion getIngestionById(int id);

    List<Ingestion> listIngestion();
}
