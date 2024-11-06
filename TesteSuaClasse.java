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
