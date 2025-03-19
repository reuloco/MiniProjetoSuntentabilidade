import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu principal
        System.out.println("Bem-vindo ao Sistema de Gestão de Projetos Sustentáveis!");
        System.out.println("Escolha o tipo de organização:");
        System.out.println("1 - ONG");
        System.out.println("2 - Empresa");
        int tipo_organizacao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Criar organização
        Organizacao organizacao;
        if (tipo_organizacao == 1) {
            System.out.println("Digite o nome da ONG:");
            String nome = scanner.nextLine();
            organizacao = new ONG(nome);
        } else if (tipo_organizacao == 2) {
            System.out.println("Digite o nome da Empresa:");
            String nome = scanner.nextLine();
            System.out.println("Digite o CNPJ da Empresa:");
            String cnpj = scanner.nextLine();
            organizacao = new Empresa(nome, cnpj);
        } else {
            System.out.println("Opção inválida. Encerrando o programa.");
            scanner.close();
            return;
        }

        // Menu de projetos
        while (true) {
            System.out.println("\nEscolha o tipo de projeto para adicionar:");
            System.out.println("1 - Projeto de Reflorestamento");
            System.out.println("2 - Projeto de Reciclagem");
            System.out.println("3 - Projeto de Energia Renovável");
            System.out.println("0 - Sair");
            int tipo_projeto = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            if (tipo_projeto == 0) {
                break; // Sair do loop
            }

            // Capturar dados do projeto
            System.out.println("Digite o nome do projeto:");
            String nome_projeto = scanner.nextLine();
            System.out.println("Digite a descrição do projeto:");
            String descricao_projeto = scanner.nextLine();

            ProjetoSustentavel projeto;
            switch (tipo_projeto) {
                case 1:
                    System.out.println("Digite o número de árvores plantadas:");
                    int arvores_plantadas = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    projeto = new ProjetoReflorestamento(nome_projeto, descricao_projeto, arvores_plantadas);
                    break;
                case 2:
                    System.out.println("Digite a quantidade de toneladas recicladas:");
                    double toneladas_recicladas = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    projeto = new ProjetoReciclagem(nome_projeto, descricao_projeto, toneladas_recicladas);
                    break;
                case 3:
                    System.out.println("Digite a quantidade de energia gerada (em MWh):");
                    double energia_gerada = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    projeto = new ProjetoEnergiaRenovavel(nome_projeto, descricao_projeto, energia_gerada);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            // Adicionar projeto à organização
            organizacao.adicionar_projeto(projeto);
            System.out.println("Projeto adicionado com sucesso!");
        }

        // Exibir projetos e calcular impactos
        System.out.println("\nProjetos da organização " + organizacao.get_nome() + ":");
        organizacao.listar_projetos();

        System.out.println("\nCalculando impactos dos projetos:");
        for (ProjetoSustentavel projeto : organizacao.get_lista_projetos()) {
            System.out.println("\nProjeto: " + projeto.get_nome());
            projeto.calcularImpacto();
        }

        scanner.close();
    }
}