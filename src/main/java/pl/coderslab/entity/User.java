package pl.coderslab.entity;

public class User {
    private int id;         // wartość id będzie wynosiła 0, jeśli obiekt nie został jeszcze zapisany w bazie danych
    // (baza danych nigdy nie nada takiego klucza głównego)
    // !=0 , gdy gdy obiekt ma odpowiadający sobie wiersz w bazie danych
    private String email;
    private String username;
    private String password;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
                '}';
    }
}
