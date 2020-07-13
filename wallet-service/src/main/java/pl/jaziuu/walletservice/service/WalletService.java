package pl.jaziuu.walletservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jaziuu.walletservice.controller.viewmodel.ExpenseViewModel;
import pl.jaziuu.walletservice.controller.viewmodel.IncomeViewModel;
import pl.jaziuu.walletservice.model.Expense;
import pl.jaziuu.walletservice.model.Income;
import pl.jaziuu.walletservice.model.Wallet;
import pl.jaziuu.walletservice.repository.ExpenseRepository;
import pl.jaziuu.walletservice.repository.IncomeRepository;
import pl.jaziuu.walletservice.repository.WalletRepository;

import java.util.List;

@Service
public class WalletService {
    private WalletRepository walletRepository;
    private IncomeRepository incomeRepository;
    private ExpenseRepository expenseRepository;

    public WalletService(WalletRepository walletRepository, IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.walletRepository = walletRepository;
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }


    public void addWallet(Long userId, String name) {
        Wallet wallet = new Wallet(name, userId);
        walletRepository.save(wallet);
        System.out.println("Wallet Added");
    }

    public List<Wallet> getWalletsByUserId(Long userId){
        return walletRepository.getAllByUserId(userId);
    }

    public Wallet getWalletById(Long walletId){
        var wallet = walletRepository.getById(walletId);
        if(wallet.isEmpty()){
            return null;
        }
        return wallet.get();
    }


    public void addIncome( Long walletId,  IncomeViewModel incomeViewModel){
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

    public void updateIncome( Long incomeId,  IncomeViewModel incomeViewModel){
        var optionalIncome = incomeRepository.findById(incomeId);
        if(optionalIncome.isPresent()){

            var income = optionalIncome.get();
            income.setTitle(incomeViewModel.getTitle());
            income.setDescription(incomeViewModel.getDescription());
            income.setAmount(incomeViewModel.getAmount());
            income.setDate(incomeViewModel.getDate());
            income.setIncomeType(incomeViewModel.getIncomeType());
            incomeRepository.save(income);
        }
    }




    public void addExpense(Long walletId, ExpenseViewModel expenseViewModel){
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


    public void updateExpense( Long expenseId, ExpenseViewModel expenseViewModel){
        var optionalExpense = expenseRepository.findById(expenseId);
        if(optionalExpense.isPresent()){
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
