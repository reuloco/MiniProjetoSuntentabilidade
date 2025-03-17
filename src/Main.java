public class Main {
    public static void main(String[] args) {
        // 1. Criar uma Organização
        Organizacao organizacao = new Organizacao("EcoPlanet");

        // 2. Adicionar alguns Projetos Sustentáveis
        ProjetoSustentavel projeto1 = new ProjetoSustentavel("Reflorestamento Urbano", "Plantio de árvores em áreas urbanas.");
        ProjetoSustentavel projeto2 = new ProjetoSustentavel("Energia Solar Comunitária", "Instalação de painéis solares em comunidades carentes.");

        organizacao.adicionar_projeto(projeto1);
        organizacao.adicionar_projeto(projeto2);

        // 3. Listar os projetos da organização
        System.out.println("Projetos da organização " + organizacao.get_nome() + ":");
        organizacao.listar_projetos();

        // 4. Criar Voluntários
        Voluntario voluntario1 = new Voluntario("João Silva", "joao.silva@example.com");
        Voluntario voluntario2 = new Voluntario("Maria Oliveira", "maria.oliveira@example.com");

        // 5. Associar voluntários a projetos
        voluntario1.participar_projeto(projeto1); // João participa do Reflorestamento Urbano
        voluntario2.participar_projeto(projeto1); // Maria participa do Reflorestamento Urbano
        voluntario2.participar_projeto(projeto2); // Maria participa da Energia Solar Comunitária

        // 6. Criar um Relatório de Impacto para um projeto
        projeto1.gerar_relatorio_impacto(500, 12.5); // Relatório para o Reflorestamento Urbano

        // 7. Exibir os resultados do relatório de impacto
        System.out.println("\nRelatório de Impacto do Projeto: " + projeto1.get_nome());
        projeto1.exibir_relatorio_impacto();
    }
}