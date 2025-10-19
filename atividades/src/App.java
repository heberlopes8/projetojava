
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Produto produto = new Produto("", "", 0, 0.0);
        int opcao;

        do {
            System.out.println("\n=== MENU DE PRODUTOS ===");
            System.out.println("1. Cadastrar novo produto");
            System.out.println("2. Adicionar estoque");
            System.out.println("3. Remover estoque");
            System.out.println("4. Calcular valor total do estoque");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Código do produto: ");
                    String codigo = sc.nextLine();
                    System.out.print("Quantidade inicial: ");
                    int quantidade = sc.nextInt();
                    System.out.print("Preço unitário: ");
                    double preco = sc.nextDouble();
                    sc.nextLine();
                    produto = new Produto(nome, codigo, quantidade, preco);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    if (produto != null) {
                        System.out.print("Quantidade a adicionar: ");
                        int qAdd = sc.nextInt();
                        produto.adicionarEstoque(qAdd);
                        System.out.println("Estoque atualizado. Quantidade atual: " + produto.getQuantidade());
                    } else {
                        System.out.println("Nenhum produto cadastrado ainda!");
                    }
                    break;

                case 3:
                    if (produto != null) {
                        System.out.print("Quantidade a remover: ");
                        int qRem = sc.nextInt();
                        produto.removerEstoque(qRem);
                        System.out.println("Estoque atualizado. Quantidade atual: " + produto.getQuantidade());
                    } else {
                        System.out.println("Nenhum produto cadastrado ainda!");
                    }
                    break;

                case 4:
                    if (produto != null) {
                        double valorTotal = produto.calcularValorTotal();
                        System.out.printf("Valor total do estoque: R$ %.2f\n", valorTotal);
                    } else {
                        System.out.println("Nenhum produto cadastrado ainda!");
                    }
                    break;

                case 5:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        sc.close();
    }
}
