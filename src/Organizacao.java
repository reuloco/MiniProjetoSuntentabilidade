import java.util.ArrayList;
import java.util.List;

public class Organizacao {
    private String nome;
    private List<ProjetoSustentavel> listaProjetos;

    public Organizacao() {
    }

    public Organizacao(String nome) {
        this.nome = nome;
        this.listaProjetos = new ArrayList<>();
    }


    public String get_nome() {
        return nome;
    }

    public void set_nome(String nome) {
        this.nome = nome;
    }

    public List<ProjetoSustentavel> getListaProjetos() {
        return listaProjetos;
    }

    public void set_lista_projetos(List<ProjetoSustentavel> listaProjetos) {
        this.listaProjetos = listaProjetos;
    }

    public void adicionar_projeto(ProjetoSustentavel projeto) {
        listaProjetos.add(projeto);
    }



    public void listar_projetos() {
        for (ProjetoSustentavel projeto : listaProjetos) {
            System.out.println(projeto);
        }
    }
}