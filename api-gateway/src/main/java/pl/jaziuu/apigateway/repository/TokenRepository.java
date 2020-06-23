package pl.jaziuu.apigateway.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import pl.jaziuu.apigateway.model.Token;

public interface TokenRepository  extends JpaRepository<Token, Long> {
    Token findByValue(String value);
}
