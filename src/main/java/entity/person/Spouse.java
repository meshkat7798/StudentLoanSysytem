package entity.person;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Spouse extends Person {
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    private Student student;

    public Spouse(String firstname, String lastname, String fatherName, String motherName, String birthCertificateNumber, String nationalId, String dateOfBirth) {
        super(firstname, lastname, fatherName, motherName, birthCertificateNumber, nationalId, dateOfBirth);
    }
}

