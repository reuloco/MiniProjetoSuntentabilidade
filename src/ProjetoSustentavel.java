import java.util.ArrayList;
import java.util.List;

public abstract class ProjetoSustentavel implements ImpactoAmbiental {
    private String nome;
    private String descricao;
    private List<Voluntario> voluntarios;

    public ProjetoSustentavel(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.voluntarios = new ArrayList<>();
    }

    public void adicionar_voluntario(Voluntario voluntario) {
        voluntarios.add(voluntario);
    }

    public String get_nome() {
        return nome;
    }

    public void set_nome(String nome) {
        this.nome = nome;
    }

    public String get_descricao() {
        return descricao;
    }

    public void set_descricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Voluntario> get_voluntarios() {
        return voluntarios;
    }
}