package pl.jaziuu.walletservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jaziuu.walletservice.model.Wallet;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    public List<Wallet> getAllByUserId(Long userId);
    public Optional<Wallet> getById(Long walletId);
}
