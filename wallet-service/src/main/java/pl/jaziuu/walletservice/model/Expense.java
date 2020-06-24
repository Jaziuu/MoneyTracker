package pl.jaziuu.walletservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private Long walletId;
    private Date date;

    private String title;
    private String description;
    private double amount;
}
