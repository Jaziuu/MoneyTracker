package pl.jaziuu.apigateway.service;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jaziuu.apigateway.model.Token;
import pl.jaziuu.apigateway.model.User;
import pl.jaziuu.apigateway.repository.TokenRepository;
import pl.jaziuu.apigateway.repository.UserRepository;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class UserService {
    private TokenRepository tokenRepo;

    private MailService mailService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(TokenRepository tokenRepo, MailService mailService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.tokenRepo = tokenRepo;
        this.mailService = mailService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        sendToken(user);
    }

    private void sendToken(User user) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setUser(user);
        tokenRepo.save(token);
        // TODO: 25.04.2020 url to universal .. should work after deploment
        String url = "http://localhost:8081/api/auth/token?value=" + tokenValue;

        try {
            mailService.sendMail(user.getEmail(), "Potwierdź swoj email do aplikacji timetable:", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

}
