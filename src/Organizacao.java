import java.util.ArrayList;

public class Organizacao {
    private String nome;
    private ArrayList<ProjetoSustentavel> lista_projetos;

    public Organizacao(String nome) {
        this.nome = nome;
        this.lista_projetos = new ArrayList<>();
    }

    public void adicionar_projeto(ProjetoSustentavel projeto) {
        lista_projetos.add(projeto);
    }

    public void listar_projetos() {
        System.out.println("Projetos da organização " + nome + ":");
        for (ProjetoSustentavel projeto : lista_projetos) {
            System.out.println("- " + projeto.get_nome() + ": " + projeto.get_descricao());
        }
    }

    public String get_nome() {
        return nome;
    }

    public void set_nome(String nome) {
        this.nome = nome;
    }

    public ArrayList<ProjetoSustentavel> get_lista_projetos() {
        return lista_projetos;
    }
}