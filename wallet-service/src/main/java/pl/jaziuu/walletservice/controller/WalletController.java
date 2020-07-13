package pl.jaziuu.walletservice.controller;

import org.springframework.web.bind.annotation.*;
import pl.jaziuu.walletservice.controller.viewmodel.ExpenseViewModel;
import pl.jaziuu.walletservice.controller.viewmodel.IncomeViewModel;
import pl.jaziuu.walletservice.model.Wallet;
import pl.jaziuu.walletservice.service.WalletService;

import java.util.List;

@RestController
public class WalletController {

    private WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }


    @PostMapping("{userId}/addWallet")
    public void addWallet(@PathVariable Long userId, @RequestParam String name) {
        walletService.addWallet(userId, name);
    }

    @GetMapping("getWallets/{userId}")
    public List<Wallet> getWalletsByUserId(@PathVariable Long userId) {
        return walletService.getWalletsByUserId(userId);
    }

    @GetMapping("getWalletById/{walletId}")
    public Wallet getWalletById(@PathVariable Long walletId) {
        return walletService.getWalletById(walletId);
    }

    @PostMapping("addIncome/{walletId}")
    public void addIncome(@PathVariable Long walletId, @RequestBody IncomeViewModel incomeViewModel) {
        walletService.addIncome(walletId, incomeViewModel);
    }

    @PostMapping("updateIncome/{incomeId}")
    public void updateIncome(@PathVariable Long incomeId, @RequestBody IncomeViewModel incomeViewModel) {

        walletService.updateIncome(incomeId, incomeViewModel);
    }


    @PostMapping("addExpense/{walletId}")
    public void addExpense(@PathVariable Long walletId, @RequestBody ExpenseViewModel expenseViewModel) {
        walletService.addExpense(walletId, expenseViewModel);


    }

    @PostMapping("updateExpense/{expenseId}")
    public void updateExpense(@PathVariable Long expenseId, @RequestBody ExpenseViewModel expenseViewModel) {

        walletService.updateExpense(expenseId,expenseViewModel);
    }


}
