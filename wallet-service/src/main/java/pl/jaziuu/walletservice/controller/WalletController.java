package pl.jaziuu.walletservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.jaziuu.walletservice.model.Wallet;
import pl.jaziuu.walletservice.repository.WalletRepository;

@RestController
public class WalletController {

    private WalletRepository walletRepository;

    public WalletController(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @PostMapping("{userId}/addWallet")
    public void addWallet(@PathVariable Long userId, @RequestParam String name){
        Wallet wallet = new Wallet(name,userId);
        walletRepository.save(wallet);
        System.out.println("Wallet Added");
    }
}
