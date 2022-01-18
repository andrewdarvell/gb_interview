package ru.darvell.gb.interview.hibernate.students.dao;

import ru.darvell.gb.interview.hibernate.students.component.HibernateSessionFactoryManager;

import java.io.Serializable;
import java.util.Optional;

public class AbstractCrudDao<E> {


    public void addOrUpdate(E entity) {
        var session = HibernateSessionFactoryManager.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();

    }

    public <I extends Serializable> Optional<E> getById(Class<E> entityClass, I id) {

        var session = HibernateSessionFactoryManager.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            return Optional.ofNullable(session.get(entityClass, id));
        } finally {
            session.getTransaction().rollback();
        }

    }

    public void delete(E entity) {
        var session = HibernateSessionFactoryManager.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }
}

