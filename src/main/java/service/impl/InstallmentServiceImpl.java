package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Installment;
import repository.InstallmentRepository;
import service.InstallmentService;
import java.util.List;

@SuppressWarnings("unused")
public class InstallmentServiceImpl extends BaseEntityServiceImpl<Installment, Integer, InstallmentRepository> implements InstallmentService {
    public InstallmentServiceImpl(InstallmentRepository repository) {
        super(repository);
    }

    @Override
    public List<Object[]> paidInstallments(int loanId) {
        return repository.paidInstallments(loanId);
    }

    @Override
    public List<Object[]> unpaidInstallments(int loanId) {
        return repository.unpaidInstallments(loanId);
    }

    @Override
    public Installment findByNumber(Integer number, Integer loanId) {
        return repository.findByNumber(number,loanId);
    }


}
