package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.CreditCard;
import entity.Installment;
import entity.person.Student;
import repository.CreditCardRepository;

import javax.persistence.EntityManager;
@SuppressWarnings("unused")
public class CreditCardRepositoryImpl extends BaseEntityRepositoryImpl<CreditCard, Integer> implements CreditCardRepository {
    public CreditCardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }

    @Override
    public Boolean isSameCard(int studentId, String cardNumber) {
        try {
            return entityManager.createQuery("""
                            SELECT COUNT(c.cardNumber) FROM CreditCard c WHERE c.studentId = :studentId AND c.cardNumber = :cardNumber
                            """, Long.class)
                    .setParameter("studentId", studentId)
                    .setParameter("cardNumber", cardNumber)
                    .getSingleResult() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
