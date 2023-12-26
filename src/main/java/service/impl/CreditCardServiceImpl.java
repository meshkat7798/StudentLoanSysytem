package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.CreditCard;
import entity.person.Student;
import repository.CreditCardRepository;
import service.CreditCardService;
@SuppressWarnings("unused")
public class CreditCardServiceImpl extends BaseEntityServiceImpl<CreditCard, Integer, CreditCardRepository> implements CreditCardService {
    public CreditCardServiceImpl(CreditCardRepository repository) {
        super(repository);
    }

    @Override
    public Boolean isSameCard(int studentId, String cardNumber) {
        return repository.isSameCard(studentId,cardNumber);
    }
}
