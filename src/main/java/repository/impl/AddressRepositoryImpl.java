package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Address;
import repository.AddressRepository;

import javax.persistence.EntityManager;
@SuppressWarnings("unused")
public class AddressRepositoryImpl extends BaseEntityRepositoryImpl<Address, Integer> implements AddressRepository {
    public AddressRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }
//
//    @Override
//    public Address fidById(Integer id) {
//        try {
//            return entityManager.createQuery("""
//                            FROM Address a WHERE a.id = :id
//                            """, Address.class)
//                    .setParameter("id", id)
//                    .getSingleResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
