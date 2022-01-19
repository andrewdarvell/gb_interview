package ru.darvell.gb.interview.hibernate.students.dao;

import ru.darvell.gb.interview.hibernate.students.component.HibernateSessionFactoryManager;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class AbstractCrudDao<E> {


    public void addOrUpdate(E entity) {
        try (var session = HibernateSessionFactoryManager.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        }

    }

    public <I extends Serializable> Optional<E> getById(Class<E> entityClass, I id) {

        try (var session = HibernateSessionFactoryManager.getSessionFactory().openSession()) {
            session.beginTransaction();
            return Optional.ofNullable(session.get(entityClass, id));
        }

    }

    public void delete(E entity) {
        try (var session = HibernateSessionFactoryManager.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }

    public List<E> getAll(Class<E> entityClass, String request) {
        try (var session = HibernateSessionFactoryManager.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<E> entitys = session.createQuery(request, entityClass).getResultList();
            session.getTransaction().commit();
            return entitys;
        }
    }
}

