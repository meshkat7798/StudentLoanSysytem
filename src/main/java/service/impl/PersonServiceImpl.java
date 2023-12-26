package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.person.Person;
import repository.PersonRepository;
import service.PersonService;

@SuppressWarnings("unused")
public class PersonServiceImpl<T extends Person, R extends PersonRepository<T>> extends BaseEntityServiceImpl<T, Integer, R> implements PersonService<T> {
    public PersonServiceImpl(R repository) {
        super(repository);
    }




}
