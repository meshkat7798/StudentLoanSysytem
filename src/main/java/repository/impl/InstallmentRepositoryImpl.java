package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Installment;
import repository.InstallmentRepository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("unused")
public class InstallmentRepositoryImpl extends BaseEntityRepositoryImpl<Installment, Integer> implements InstallmentRepository {
    public InstallmentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Installment> getEntityClass() {
        return Installment.class;
    }

    @Override
    public List<Object[]> paidInstallments(int loanId) {
        try {
            List<Object[]> results = entityManager.createQuery("""
                            SELECT i.number, i.loanId, i.paymentDueDate FROM Installment i
                            WHERE i.ispaid = true AND i.loanId = :loanId
                            """, Object[].class)
                    .setParameter("loanId", loanId)
                    .getResultList();
            for (Object[] result : results) {
                int numberOfInstallment = (int) result[0];
                int installmentLoanId = (int) result[1];
                LocalDate dueDate = (LocalDate) result[2];
            }
            return results;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Object[]> unpaidInstallments(int loanId) {
        try {
            List<Object[]> results = entityManager.createQuery("""
                            SELECT i.number, i.loanId, i.paymentDate, i.amount FROM Installment i
                            WHERE i.ispaid = false AND i.loanId = :loanId
                            """, Object[].class)
                    .setParameter("loanId", loanId)
                    .getResultList();

            for (Object[] result : results) {
                int numberOfInstallment = (int) result[0];
                int installmentLoanId = (int) result[1];
                LocalDate dueDate = (LocalDate) result[2];
                double installmentAmount = (double) result[3];
            }
            return results;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Installment findByNumber(Integer number , Integer loanId) {
        try {
            String hql = "FROM Installment i WHERE i.number = :number AND i.loanId = :loanId";
            TypedQuery<Installment> query = entityManager.createQuery(hql, getEntityClass());
            query.setParameter("number", number);
            query.setParameter("loanId", loanId);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
