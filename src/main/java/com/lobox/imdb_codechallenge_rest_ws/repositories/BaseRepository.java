package com.lobox.imdb_codechallenge_rest_ws.repositories;

import jakarta.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;

public abstract class BaseRepository {

    protected org.apache.logging.log4j.Logger log = LogManager.getLogger(this.getClass());

    private EntityManager entityManager;
}
