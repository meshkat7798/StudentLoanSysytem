package utility;
import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

import javax.persistence.EntityManager;

@SuppressWarnings("unused")
public class ApplicationContext {

    private static final EntityManager entityManager;
    private static final AddressRepository ADDRESS_REPOSITORY;
    private static final CreditCardRepository CREDIT_CARD_REPOSITORY;
    private static final InstallmentRepository INSTALLMENT_REPOSITORY;
    private static final SpouseRepository SPOUSE_REPOSITORY;
    private static final StudentRepository STUDENT_REPOSITORY;
    private static final LoanRepository LOAN_REPOSITORY;

    private static final AddressService ADDRESS_SERVICE;
    private static final CreditCardService CREDIT_CARD_SERVICE;
    private static final InstallmentService INSTALLMENT_SERVICE;
    private static final SpouseService SPOUSE_SERVICE;
    private static final StudentService STUDENT_SERVICE;
    private static final LoanService LOAN_SERVICE;


    static {
        entityManager = EntityMangerProvider.getEntityManager();
        ADDRESS_REPOSITORY = new AddressRepositoryImpl(entityManager);
        CREDIT_CARD_REPOSITORY = new CreditCardRepositoryImpl(entityManager);
        INSTALLMENT_REPOSITORY = new InstallmentRepositoryImpl(entityManager);
        LOAN_REPOSITORY = new LoanRepositoryImpl(entityManager);
        SPOUSE_REPOSITORY = new SpouseRepositoryImpl(entityManager);
        STUDENT_REPOSITORY = new StudentRepositoryImpl(entityManager);

        ADDRESS_SERVICE = new AddressServiceImpl(ADDRESS_REPOSITORY);
        CREDIT_CARD_SERVICE = new CreditCardServiceImpl(CREDIT_CARD_REPOSITORY);
        INSTALLMENT_SERVICE = new InstallmentServiceImpl(INSTALLMENT_REPOSITORY);
        LOAN_SERVICE = new LoanServiceImpl(LOAN_REPOSITORY);
        SPOUSE_SERVICE = new SpouseServiceImpl(SPOUSE_REPOSITORY);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY);
    }


    public static AddressService getAddressService() {
        return ADDRESS_SERVICE;
    }

    public static CreditCardService getCreditCardService() {
        return CREDIT_CARD_SERVICE;
    }

    public static InstallmentService getInstallmentService() {
        return INSTALLMENT_SERVICE;
    }

    public static LoanService getLoanService() {
        return LOAN_SERVICE;
    }

    public static SpouseService getSpouseService() {
        return SPOUSE_SERVICE;
    }

    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }
}

