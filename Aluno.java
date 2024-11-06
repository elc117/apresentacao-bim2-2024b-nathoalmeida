public class Aluno {

// ATRIBUTOS DA CLASSE
    private String nome;
    private String matricula;
    private int emprestimos;

// CONSTRUTORES
    public Aluno(String nome) {
        this.nome = nome;
        this.emprestimos = 0;
    }

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.emprestimos = 0;
    }

// GETTERS
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getEmprestimos() {
        return emprestimos;
    }

 // SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setEmprestimos(int emprestimos) {
        this.emprestimos = emprestimos;
    }

// MÉTODOS DA CLASSE
    public void retiraLivro(Livro livro) {
        if(livro.getStatus()) {
            if (emprestimos < 2) {
                emprestimos++;
                livro.setStatus(false);
                System.out.println("Livro " + "\"" +livro.getNome()+ "\"" + " retirado com sucesso");
            } else {
                System.out.println("Você atingiu o limite de empréstimos");
            }
        } else {
            System.out.println("Livro " + "\"" +livro.getNome()+ "\"" + " indisponível para retirada");
        }
    }

    public void devolveLivro(Livro livro) {
        livro.setStatus(true);
        emprestimos--;
        System.out.println("Livro " + "\"" +livro.getNome()+ "\"" + " devolvido com sucesso");
    }
}
