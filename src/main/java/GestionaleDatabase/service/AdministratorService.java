package GestionaleDatabase.service;

import GestionaleDatabase.entity.AdministratorEntity;
import GestionaleDatabase.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;

@Service
public class AdministratorService {

    int i = 0;

    @Autowired
    AdministratorRepository administratorRepository;

    public AdministratorEntity login(String username, String password) {
        Optional<AdministratorEntity> adminOptional = administratorRepository.findByUsernameAndPassword(username, password);

        if (!adminOptional.isPresent()) {
            return null;
        }
        return adminOptional.get();
    }

    public AdministratorEntity registrazione(String nome, String cognome, String email, String cellulare) {
        i++;
        AdministratorEntity adminRegistrato =  new AdministratorEntity();
        adminRegistrato.setNome(nome);
        adminRegistrato.setCognome(cognome);
        adminRegistrato.setUsername(nome + "_" + cognome + i);
        adminRegistrato.setPassword(generatePassword());

        if (email != null) {
            adminRegistrato.setEmail(email);
        }

        if (cellulare != null) {
            adminRegistrato.setCellulare(cellulare);
        }

        administratorRepository.save(adminRegistrato);
        return adminRegistrato;
    }

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvwxyz"
            + "0123456789"
            + "!@#$%^&*()-_=+[]{}";
    private static final int PASSWORD_LENGTH = 10;

    public static String generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }
}