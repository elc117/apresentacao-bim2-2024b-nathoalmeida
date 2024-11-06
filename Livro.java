public class Livro {

    // ATRIBUTOS
    private String nome;
    private boolean status;

    // CONSTRUTOR
    public Livro(String nome) {
        this.nome = nome;
        this.status = true;
    }
    // GETTERS
    public String getNome() {
        return nome;
    }

    public boolean getStatus() {
        return status;
    }
    // SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
