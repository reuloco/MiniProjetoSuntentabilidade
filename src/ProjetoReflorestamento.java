public class ProjetoReflorestamento extends ProjetoSustentavel {
    private int arvores_plantadas;

    public ProjetoReflorestamento(String nome, String descricao, int arvores_plantadas) {
        super(nome, descricao);
        this.arvores_plantadas = arvores_plantadas;
    }

    public int get_arvores_plantadas() {
        return arvores_plantadas;
    }

    public void set_arvores_plantadas(int arvores_plantadas) {
        this.arvores_plantadas = arvores_plantadas;
    }

    @Override
    public void calcular_impacto() {
        System.out.println("Impacto: " + arvores_plantadas + " árvores plantadas.");
    }
}