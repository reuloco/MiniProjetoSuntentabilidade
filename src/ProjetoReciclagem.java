public class ProjetoReciclagem extends ProjetoSustentavel {
    private double toneladas_recicladas;

    public ProjetoReciclagem(String nome, String descricao, double toneladas_recicladas) {
        super(nome, descricao);
        this.toneladas_recicladas = toneladas_recicladas;
    }

    public double get_toneladas_recicladas() {
        return toneladas_recicladas;
    }

    public void set_toneladas_recicladas(double toneladas_recicladas) {
        this.toneladas_recicladas = toneladas_recicladas;
    }

    @Override
    public void calcularImpacto() {
        System.out.println("Impacto: " + toneladas_recicladas + " toneladas recicladas.");
    }
}