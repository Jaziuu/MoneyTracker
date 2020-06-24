package pl.jaziuu.walletservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.jaziuu.walletservice.model.Expense;
import pl.jaziuu.walletservice.model.Income;
import pl.jaziuu.walletservice.model.Wallet;
import pl.jaziuu.walletservice.repository.ExpenseRepository;
import pl.jaziuu.walletservice.repository.IncomeRepository;
import pl.jaziuu.walletservice.repository.WalletRepository;

@Service
public class DbInit implements CommandLineRunner {


   private WalletRepository walletRepository;
   private IncomeRepository incomeRepository;
   private ExpenseRepository expenseRepository;

    public DbInit(WalletRepository walletRepository, IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.walletRepository = walletRepository;
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }


    @Override
    public void run(String... args) throws Exception {


//        Wallet wallet = new Wallet("Admin wallet",1L);
//        Income income = new Income();
//        income.setWalletId(wallet.getId());
//        income.setAmount(222);
//        income.setDescription("Test");
//        income.setTitle("Title test");
//        incomeRepository.save(income);
//        var walletIncomes = wallet.getIncomes();
//        walletIncomes.add(income);
//        wallet.setIncomes(walletIncomes);
//
//        Expense expense = new Expense();
//        expense.setWalletId(wallet.getId());
//        expense.setAmount(2323);
//        expense.setDescription("TestExpense");
//        expense.setTitle("ExTestTitle");
//        expenseRepository.save(expense);
//
//        var walletExpenses = wallet.getExpenses();
//        walletExpenses.add(expense);
//        wallet.setExpenses(walletExpenses);
//
//        walletRepository.save(wallet);

    }
}
