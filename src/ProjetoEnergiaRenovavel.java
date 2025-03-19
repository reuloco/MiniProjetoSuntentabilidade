public class ProjetoEnergiaRenovavel extends ProjetoSustentavel {
    private double energia_gerada; // Em MWh

    public ProjetoEnergiaRenovavel(String nome, String descricao, double energia_gerada) {
        super(nome, descricao);
        this.energia_gerada = energia_gerada;
    }

    public double get_energia_gerada() {
        return energia_gerada;
    }

    public void set_energia_gerada(double energia_gerada) {
        this.energia_gerada = energia_gerada;
    }

    @Override
    public void calcularImpacto() {
        System.out.println("Impacto: " + energia_gerada + " MWh de energia gerada.");
    }
}