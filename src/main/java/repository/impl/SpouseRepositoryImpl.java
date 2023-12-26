package repository.impl;

import entity.person.Spouse;
import repository.SpouseRepository;

import javax.persistence.EntityManager;
@SuppressWarnings("unused")
public class SpouseRepositoryImpl extends PersonRepositoryImpl<Spouse> implements SpouseRepository {
    public SpouseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Spouse> getEntityClass() {
        return Spouse.class;
    }
}
