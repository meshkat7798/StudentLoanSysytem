package repository;

import base.repository.BaseEntityRepository;
import entity.person.Person;
@SuppressWarnings("unused")
public interface PersonRepository <T extends Person> extends BaseEntityRepository<T, Integer> {


}
