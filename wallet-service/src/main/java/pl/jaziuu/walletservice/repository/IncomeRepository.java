package pl.jaziuu.walletservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jaziuu.walletservice.model.Income;

import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {
    Optional<Income> findById(Long id);
}
