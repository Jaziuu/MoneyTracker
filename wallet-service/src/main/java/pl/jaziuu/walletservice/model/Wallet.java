package pl.jaziuu.walletservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "wallets")
public class Wallet {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long userId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wallet_incomes",
            joinColumns = @JoinColumn(name = "wallet_id"),
            inverseJoinColumns = @JoinColumn(name = "income_id"))
    private List<Income> incomes = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wallet_expenses",
            joinColumns = @JoinColumn(name = "wallet_id"),
            inverseJoinColumns = @JoinColumn(name = "expense_id"))
    private List<Expense> expenses = new ArrayList<>();
//    private List<Saving> savings;
//    private List<Transfer> transfers;


    public Wallet(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }
}
