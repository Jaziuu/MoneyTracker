package pl.jaziuu.walletservice.controller.viewmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeExpenseViewModel {

    private Date date;
    private String title;
    private String description;
    private double amount;

}
