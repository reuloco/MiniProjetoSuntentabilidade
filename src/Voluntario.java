public class Voluntario {
    private String nome;
    private String email;

    public Voluntario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Método para participar de um projeto
    public void participar_projeto(ProjetoSustentavel projeto) {
        if (projeto != null) {
            projeto.adicionar_voluntario(this); // Adiciona o voluntário ao projeto
            System.out.println(this.nome + " participou do projeto: " + projeto.get_nome());
        } else {
            System.out.println("Erro: Projeto não pode ser nulo.");
        }
    }

    // Getters e Setters
    public String get_nome() {
        return nome;
    }

    public void set_nome(String nome) {
        this.nome = nome;
    }

    public String get_email() {
        return email;
    }

    public void set_email(String email) {
        this.email = email;
    }
}