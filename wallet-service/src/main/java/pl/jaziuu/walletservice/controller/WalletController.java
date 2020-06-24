package pl.jaziuu.walletservice.controller;

import org.springframework.web.bind.annotation.*;
import pl.jaziuu.walletservice.model.Wallet;
import pl.jaziuu.walletservice.repository.WalletRepository;

import java.util.List;

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

    @GetMapping("{userId}/getWallets")
    public List<Wallet> getWallets(@PathVariable Long userId){
        return walletRepository.getAllByUserId(userId);
    }
}
