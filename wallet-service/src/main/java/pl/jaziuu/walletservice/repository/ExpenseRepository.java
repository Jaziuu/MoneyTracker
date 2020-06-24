package pl.jaziuu.walletservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jaziuu.walletservice.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
