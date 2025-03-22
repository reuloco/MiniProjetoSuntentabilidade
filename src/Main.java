import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu principal
        System.out.println("Bem-vindo ao Sistema de Gestão de Projetos Sustentáveis!");

        // Criar organização
        System.out.println("Escolha o tipo de organização:");
        System.out.println("1 - ONG");
        System.out.println("2 - Empresa");
        int tipo_organizacao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

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
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar Projeto");
            System.out.println("2 - Adicionar Voluntário a um Projeto");
            System.out.println("3 - Listar Projetos e Voluntários");
            System.out.println("4 - Calcular Impacto dos Projetos");
            System.out.println("0 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            if (opcao == 0) {
                break; // Sair do loop
            }

            switch (opcao) {
                case 1:
                    // Adicionar projeto
                    System.out.println("Escolha o tipo de projeto:");
                    System.out.println("1 - Projeto de Reflorestamento");
                    System.out.println("2 - Projeto de Reciclagem");
                    System.out.println("3 - Projeto de Energia Renovável");
                    int tipo_projeto = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

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

                    organizacao.adicionar_projeto(projeto);
                    System.out.println("Projeto adicionado com sucesso!");
                    break;

                case 2:
                    // Adicionar voluntário a um projeto
                    if (organizacao.get_lista_projetos().isEmpty()) {
                        System.out.println("Nenhum projeto cadastrado. Adicione um projeto primeiro.");
                        break;
                    }

                    System.out.println("Escolha o projeto para adicionar o voluntário:");
                    for (int i = 0; i < organizacao.get_lista_projetos().size(); i++) {
                        System.out.println((i + 1) + " - " + organizacao.get_lista_projetos().get(i).get_nome());
                    }
                    int indice_projeto = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    if (indice_projeto < 1 || indice_projeto > organizacao.get_lista_projetos().size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }

                    ProjetoSustentavel projeto_selecionado = organizacao.get_lista_projetos().get(indice_projeto - 1);

                    System.out.println("Digite o nome do voluntário:");
                    String nome_voluntario = scanner.nextLine();
                    System.out.println("Digite o e-mail do voluntário:");
                    String email_voluntario = scanner.nextLine();

                    Voluntario voluntario = new Voluntario(nome_voluntario, email_voluntario);
                    projeto_selecionado.adicionar_voluntario(voluntario);
                    System.out.println("Voluntário adicionado com sucesso!");
                    break;

                case 3:
                    // Listar projetos e voluntários
                    if (organizacao.get_lista_projetos().isEmpty()) {
                        System.out.println("Nenhum projeto cadastrado.");
                        break;
                    }

                    System.out.println("\nProjetos da organização " + organizacao.get_nome() + ":");
                    for (ProjetoSustentavel p : organizacao.get_lista_projetos()) {
                        System.out.println("- " + p.get_nome() + ": " + p.get_descricao());
                        if (p.get_voluntarios().isEmpty()) {
                            System.out.println("  Nenhum voluntário cadastrado.");
                        } else {
                            System.out.println("  Voluntários:");
                            for (Voluntario v : p.get_voluntarios()) {
                                System.out.println("  - " + v.get_nome() + " (" + v.get_email() + ")");
                            }
                        }
                    }
                    break;

                case 4:
                    // Calcular impacto dos projetos
                    if (organizacao.get_lista_projetos().isEmpty()) {
                        System.out.println("Nenhum projeto cadastrado.");
                        break;
                    }

                    System.out.println("\nCalculando impactos dos projetos:");
                    for (ProjetoSustentavel p : organizacao.get_lista_projetos()) {
                        System.out.println("\nProjeto: " + p.get_nome());
                        p.calcular_impacto();
                    }
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Programa encerrado. Obrigado!");
        scanner.close();
    }
}