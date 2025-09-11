package GestionaleDatabase.entity;

public class SignInDTO {

    private String nome;

    private String cognome;

    private String email;

    private String cellulare;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = (email == null || email.isBlank()) ? null : email;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = (cellulare == null || cellulare.isBlank()) ? null : cellulare;
    }

    public SignInDTO(String nome, String cognome, String email, String cellulare) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.cellulare = cellulare;
    }

    public SignInDTO() {
    }

    @Override
    public String toString() {
        return "SignInDTO{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", cellulare='" + cellulare + '\'' +
                '}';
    }
}