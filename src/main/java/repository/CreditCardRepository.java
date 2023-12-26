package repository;

import base.repository.BaseEntityRepository;
import entity.CreditCard;
import entity.person.Student;

@SuppressWarnings("unused")
public interface CreditCardRepository extends BaseEntityRepository<CreditCard, Integer> {
    Boolean isSameCard(int studentId, String cardNumber);
}
