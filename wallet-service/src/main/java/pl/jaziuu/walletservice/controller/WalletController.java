package pl.jaziuu.walletservice.controller;

import org.springframework.web.bind.annotation.*;
import pl.jaziuu.walletservice.controller.viewmodel.ExpenseViewModel;
import pl.jaziuu.walletservice.controller.viewmodel.IncomeViewModel;
import pl.jaziuu.walletservice.model.Expense;
import pl.jaziuu.walletservice.model.Income;
import pl.jaziuu.walletservice.model.Wallet;
import pl.jaziuu.walletservice.repository.ExpenseRepository;
import pl.jaziuu.walletservice.repository.IncomeRepository;
import pl.jaziuu.walletservice.repository.WalletRepository;

import java.util.List;

@RestController
public class WalletController {

    private WalletRepository walletRepository;
    private IncomeRepository incomeRepository;
    private ExpenseRepository expenseRepository;

    public WalletController(WalletRepository walletRepository, IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.walletRepository = walletRepository;
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }

    @PostMapping("{userId}/addWallet")
    public void addWallet(@PathVariable Long userId, @RequestParam String name){
        Wallet wallet = new Wallet(name,userId);
        walletRepository.save(wallet);
        System.out.println("Wallet Added");
    }

    @GetMapping("getWallets/{userId}")
    public List<Wallet> getWalletsByUserId(@PathVariable Long userId){
        return walletRepository.getAllByUserId(userId);
    }

    @GetMapping("getWalletById/{walletId}")
    public Wallet getWalletById(@PathVariable Long walletId){
         var wallet = walletRepository.getById(walletId);
         if(wallet.isEmpty()){
             return null;
         }
         return wallet.get();
    }

    @PostMapping("addIncome/{walletId}")
    public void addIncome(@PathVariable Long walletId, @RequestBody IncomeViewModel incomeViewModel){
        // TODO: 6/24/2020 create service
        Income income = new Income();
        income.setTitle(incomeViewModel.getTitle());
        income.setDescription(incomeViewModel.getDescription());
        income.setAmount(incomeViewModel.getAmount());
        income.setDate(incomeViewModel.getDate());
        income.setWalletId(walletId);
        income.setIncomeType(incomeViewModel.getIncomeType());
        incomeRepository.save(income);
        var wallet = walletRepository.getById(walletId);
        if(wallet.isPresent()) {
            var walletIncomes = wallet.get().getIncomes();
            walletIncomes.add(income);
            wallet.get().setIncomes(walletIncomes);
            walletRepository.save(wallet.get());
        }
    }

    @PostMapping("updateIncome/{incomeId}")
    public void updateIncome(@PathVariable Long incomeId, @RequestBody IncomeViewModel incomeViewModel){
        var optionalIncome = incomeRepository.findById(incomeId);
        if(optionalIncome.isPresent()){
            // TODO: 6/24/2020 to service
            var income = optionalIncome.get();
            income.setTitle(incomeViewModel.getTitle());
            income.setDescription(incomeViewModel.getDescription());
            income.setAmount(incomeViewModel.getAmount());
            income.setDate(incomeViewModel.getDate());
            income.setIncomeType(incomeViewModel.getIncomeType());
            incomeRepository.save(income);
        }
    }



    @PostMapping("addExpense/{walletId}")
    public void addExpense(@PathVariable Long walletId, @RequestBody ExpenseViewModel expenseViewModel){
        // TODO: 6/24/2020 create service
        Expense expense = new Expense();
        expense.setTitle(expenseViewModel.getTitle());
        expense.setDescription(expenseViewModel.getDescription());
        expense.setAmount(expenseViewModel.getAmount());
        expense.setDate(expenseViewModel.getDate());
        expense.setWalletId(walletId);
        expense.setExpenseType(expenseViewModel.getExpenseType());
        expenseRepository.save(expense);
        var wallet = walletRepository.getById(walletId);
        if(wallet.isPresent()) {
            var walletExpenses = wallet.get().getExpenses();
            walletExpenses.add(expense);
            wallet.get().setExpenses(walletExpenses);
            walletRepository.save(wallet.get());
        }
    }

    @PostMapping("updateExpense/{expenseId}")
    public void updateExpense(@PathVariable Long expenseId, @RequestBody ExpenseViewModel expenseViewModel){
        var optionalExpense = expenseRepository.findById(expenseId);
        if(optionalExpense.isPresent()){
            // TODO: 6/24/2020 to service
            var expense = optionalExpense.get();
            expense.setTitle(expenseViewModel.getTitle());
            expense.setDescription(expenseViewModel.getDescription());
            expense.setAmount(expenseViewModel.getAmount());
            expense.setDate(expenseViewModel.getDate());
            expense.setExpenseType(expenseViewModel.getExpenseType());
            expenseRepository.save(expense);
        }
    }


}
