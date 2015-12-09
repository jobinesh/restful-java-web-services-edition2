/*
 * Copyright © 2015 Packt Publishing  - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.packtpub.rest.appendix.patch.demo.service;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * Base class for JAP entity resources
 * @author Jobinesh
 */
public abstract class JPAResource<T> {

    private Class<T> entityClass;

    public JPAResource(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public T edit(T entity) {
        getEntityManager().merge(entity);
        return entity;
    }

    public T save(T entity) {
        getEntityManager().merge(entity);
        return entity;
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
