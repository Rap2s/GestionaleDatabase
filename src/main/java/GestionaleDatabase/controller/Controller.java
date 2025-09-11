package GestionaleDatabase.controller;

import GestionaleDatabase.entity.AdministratorEntity;
import GestionaleDatabase.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AdministratorEntity> login(@RequestParam String username, @RequestParam String password) {
        AdministratorEntity utente = new AdministratorEntity();
        utente = administratorService.login(username, password);

        if (utente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    @PostMapping("/registrazione")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AdministratorEntity> registrazione(@RequestParam String nome, @RequestParam String cognome, @RequestParam(required = false) String email, @RequestParam(required = false) String cellulare) {
        AdministratorEntity admin = new AdministratorEntity();
        admin = administratorService.registrazione(nome, cognome, email, cellulare);

        if (admin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
}
