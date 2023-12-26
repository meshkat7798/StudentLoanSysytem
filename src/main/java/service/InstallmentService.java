package service;

import base.service.BaseEntityService;
import entity.Installment;
import java.util.List;

@SuppressWarnings("unused")
public interface InstallmentService extends BaseEntityService<Installment,Integer> {
    List<Object[]> paidInstallments(int loanId);

    List<Object[]> unpaidInstallments(int loanId);

    Installment findByNumber(Integer number, Integer loanId);

}
