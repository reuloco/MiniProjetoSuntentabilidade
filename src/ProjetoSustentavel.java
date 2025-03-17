import java.util.ArrayList;
import java.util.List;

public class ProjetoSustentavel {
    private String nome;
    private String descricao;
    private List<Voluntario> voluntarios; // Agregação
    private RelatorioImpacto relatorio_impacto; // Composição

    public ProjetoSustentavel(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.voluntarios = new ArrayList<>();
        this.relatorio_impacto = null; // Inicialmente, o relatório de impacto não existe
    }

    // Método para adicionar um voluntário
    public void adicionar_voluntario(Voluntario voluntario) {
        if (voluntario != null) {
            voluntarios.add(voluntario);
        }
    }

    // Método para gerar um relatório de impacto
    public void gerar_relatorio_impacto(int arvores_plantadas, double reducao_co2) {
        this.relatorio_impacto = new RelatorioImpacto(arvores_plantadas, reducao_co2);
    }

    // Método para exibir o relatório de impacto
    public void exibir_relatorio_impacto() {
        if (relatorio_impacto != null) {
            relatorio_impacto.exibir_relatorio();
        } else {
            System.out.println("Nenhum relatório de impacto gerado para este projeto.");
        }
    }

    // Getters e Setters
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

    public RelatorioImpacto get_relatorio_impacto() {
        return relatorio_impacto;
    }
}