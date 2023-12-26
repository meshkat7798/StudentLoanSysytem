package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Installment extends BaseEntity<Integer> {
    private LocalDate paymentDate;
    private LocalDate paymentDueDate;
    private Double amount;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Loan loan;

    private boolean ispaid;
    private int number;
    int loanId;

    public Installment(LocalDate paymentDate, Double amount, boolean ispaid, int number) {
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.ispaid = ispaid;
        this.number = number;
    }

}
