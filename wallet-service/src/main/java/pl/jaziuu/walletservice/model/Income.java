package pl.jaziuu.walletservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Income {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private Long walletId;

    private Date date;

    private String title;
    private String description;
    private double amount;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 30)
    private IncomeType incomeType;
}
