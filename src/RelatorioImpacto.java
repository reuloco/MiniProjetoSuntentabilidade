public class RelatorioImpacto {
    private int arvores_plantadas;
    private double reducao_co2; // Em toneladas

    public RelatorioImpacto(int arvores_plantadas, double reducao_co2) {
        this.arvores_plantadas = arvores_plantadas;
        this.reducao_co2 = reducao_co2;
    }

    // Método para exibir o relatório
    public void exibir_relatorio() {
        System.out.println("Relatório de Impacto:");
        System.out.println("Árvores Plantadas: " + arvores_plantadas);
        System.out.println("Redução de CO2: " + reducao_co2 + " toneladas");
    }

    // Getters e Setters
    public int get_arvores_plantadas() {
        return arvores_plantadas;
    }

    public void set_arvores_plantadas(int arvores_plantadas) {
        this.arvores_plantadas = arvores_plantadas;
    }

    public double get_reducao_co2() {
        return reducao_co2;
    }

    public void set_reducao_co2(double reducao_co2) {
        this.reducao_co2 = reducao_co2;
    }
}