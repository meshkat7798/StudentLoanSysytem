package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.person.Person;
import repository.PersonRepository;

import javax.persistence.EntityManager;

@SuppressWarnings("unused")
public abstract  class PersonRepositoryImpl <T extends Person> extends BaseEntityRepositoryImpl<T, Integer> implements PersonRepository<T> {
    public PersonRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
}


