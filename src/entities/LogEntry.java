package entities;

import java.util.Date;
import java.util.Objects;

public class LogEntry {

    // Atributos do LogEntry: nome de usuário e momento do log.
    private String username;
    private Date moment;
    
    // Construtor que inicializa os atributos username e moment.
    public LogEntry(String username, Date moment) {        
        this.username = username;
        this.moment = moment;
    }

    // Método getter para obter o nome de usuário.
    public String getUsername() {
        return username;
    }

    // Método setter para definir o nome de usuário.
    public void setUsername(String username) {
        this.username = username;
    }

    // Método getter para obter o momento do log.
    public Date getMoment() {
        return moment;
    }

    // Método setter para definir o momento do log.
    public void setMoment(Date moment) {
        this.moment = moment;
    }

    // Método hashCode, que retorna um código hash baseado no nome de usuário.
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    // Método equals, que verifica se dois objetos LogEntry são iguais com base no nome de usuário.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // Verifica se o objeto comparado é o mesmo.
            return true;
        if (obj == null) // Verifica se o objeto comparado é nulo.
            return false;
        if (getClass() != obj.getClass()) // Verifica se o objeto comparado é da mesma classe.
            return false;
        LogEntry other = (LogEntry) obj;
        return Objects.equals(username, other.username); // Compara o nome de usuário.
    }
}
