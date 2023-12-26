package service;

import base.service.BaseEntityService;
import entity.CreditCard;
import entity.person.Student;

@SuppressWarnings("unused")
public interface CreditCardService extends BaseEntityService<CreditCard,Integer> {
    Boolean isSameCard(int studentId, String cardNumber);
}
