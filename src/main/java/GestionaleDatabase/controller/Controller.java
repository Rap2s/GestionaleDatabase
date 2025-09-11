package GestionaleDatabase.controller;

import GestionaleDatabase.entity.AdministratorEntity;
import GestionaleDatabase.entity.SignInDTO;
import GestionaleDatabase.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<AdministratorEntity> registrazione(@RequestBody SignInDTO signInDTO) {
        AdministratorEntity admin = new AdministratorEntity();
        admin = administratorService.registrazione(signInDTO.getNome(), signInDTO.getCognome(), signInDTO.getEmail(), signInDTO.getCellulare());

        if (admin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
}