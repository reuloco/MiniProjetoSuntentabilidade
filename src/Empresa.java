public class Empresa extends Organizacao {
    private String cnpj;

    public Empresa(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    public String get_cnpj() {
        return cnpj;
    }

    public void set_cnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}