package pl.jaziuu.walletservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jaziuu.walletservice.model.Wallet;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    public List<Wallet> getAllByUserId(Long userId);
}
