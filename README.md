# apresentacao-bim2-2024b-nathoalmeida

## Instruções da atividade

Crie uma classe que contenha os seguintes requisitos:

- Dois atributos de tipos diferentes;
- Mais de um construtor;
- Métodos com os prefixos **Get** e **Set**;
- Um método que implemente alguma operação com um ou mais atributos.



## Sistema de biblioteca - criação da classe Aluno

​	A proposta consiste em exemplificar um sistema da biblioteca da UFSM, em que os alunos podem retirar e devolver livros. Para tanto, foi criada uma classe Aluno com os seguintes atributos:

```java
public class Aluno {
    private String nome;
    private String matricula;
    private int emprestimos; // número de empréstimos realizados pelo aluno
}
```

​	Foram implementados dois construtores, com os parâmetros nome e matrícula no primeiro, e somente o nome no segundo (supondo um cenário em que a matrícula seria gerada automaticamente). A variável empréstimos é sempre inicializada em 0, porque não faz muito sentido uma pessoa que não existia, até então, ter empréstimos feitos na biblioteca:

```java
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
```

​	Após, foram criados os métodos *get* e *set*:

```java
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
```

​	Com os construtores e métodos básicos implementados, o próximo passo é implementar os métodos retiraLivro() e devolveLivro(). Contudo, é estranho realizar essas ações se não existem livros...



## Criei uma classe Livro

​	Para minha ideia funcionar melhor, optei por criar uma classe bem ~~fuleira~~ simples, somente para que os métodos de retirada e devolução de livros fizessem mais sentido. Ela tem dois atributos, o nome e o status (*true* se disponível, *false* se indisponível), além de um construtor e os métodos *get* e *set*.

```java
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
```



## Agora sim, retiraLivro() e devolveLivro()

​	Os nossos métodos receberão, como parâmetro, um objeto da classe Livro. Em retiraLivro, serão feitas duas verificações: se o aluno que está tentando retirar o livro ultrapassou o limite de empréstimos (não deve existir limite de empréstimos, mas vamos fingir que sim), e se o livro em questão já não está emprestado.

```java
 public void retiraLivro(Livro livro) {
        if(livro.getStatus()) {
            if (emprestimos < 2) {
                emprestimos++;
                livro.setStatus(false);
                System.out.println("Livro " + "\"" +livro.getNome()+ "\"" + " retirado com sucesso");
                // concatenar essas Strings com aspas no meio foi o terror
            } else {
                System.out.println("Você atingiu o limite de empréstimos");
            }
        } else {
            System.out.println("Livro " + "\"" +livro.getNome()+ "\"" + " indisponível para retirada");
        }
    }
```

​	E o devolveLivro, que apenas decrementa o número de empréstimos feitos pelo aluno e modifica o status do livro para novamente disponível:

```java
public void devolveLivro(Livro livro) {
        livro.setStatus(true);
        emprestimos--;
        System.out.println("Livro " + "\"" +livro.getNome()+ "\"" + " devolvido com sucesso");
    }
```



## Teste das classes

​	Foi criada uma classe, denominada TesteSuaClasse, com o método *main*, que instanciará os objetos e testará a funcionalidade dos métodos criados.

```java
public class TesteSuaClasse {

    public static void main(String[] args) {
        Livro l1 = new Livro("Torto Arado");
        Livro l2 = new Livro("A filha perdida");
        Livro l3 = new Livro("Colonialismo Digital");

        Aluno a1 = new Aluno("Nathália", "201130083");

        a1.retiraLivro(l1);
        a1.retiraLivro(l2);
        a1.retiraLivro(l3); // testa o limite de empréstimos
        a1.devolveLivro(l2);
        a1.retiraLivro(l3);
        a1.retiraLivro(l1); // tenta retirar um livro que já está retirado
        a1.devolveLivro(l1);
    }
}
```

​	O código foi compilado e executado na linha de comando, produzindo o seguinte resultado:

 
