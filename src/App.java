import financeiro.*;
import model.Funcionario;
import model.Prato;
import service.RhService;
import service.VendaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static List<Funcionario> funcionarios = new ArrayList<>();

    private static List<Prato> cardapio = new ArrayList<>();

    private static double faturamentoTotal = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        inicializarDados();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n--- TECHFOOD ERP REFACTOR ---");

            System.out.println("1-RH | 2-Aumento | 3-Cardápio | 4-Estoque | 5-VENDA | 0-Sair");

            opcao = scanner.nextInt();

            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("1-Listar | 2-Contratar | 3-Demitir");

                    int sub = scanner.nextInt();

                    scanner.nextLine();

                    if (sub == 1) {

                        for (int i = 0; i < funcionarios.size(); i++)

                            System.out.println(i + ": " + funcionarios.get(i).getNome());

                    } else if (sub == 2) {

                        System.out.print("Nome: ");

                        String nome = scanner.nextLine();

                        System.out.print("Cargo: ");

                        String cargo = scanner.nextLine();

                        System.out.print("Salário: ");

                        double salario = scanner.nextDouble();

                        funcionarios.add(new Funcionario(nome, cargo, salario));

                    } else if (sub == 3) {

                        System.out.print("ID: ");

                        int id = scanner.nextInt();

                        funcionarios.get(id).setNome("DEMITIDO");

                    }

                    break;

                case 2:

                    System.out.print("ID Funcionario: ");

                    int idFuncionario = scanner.nextInt();

                    System.out.print("Aumento %: ");

                    double aumento = scanner.nextDouble();

                    new RhService().aplicarAumento(funcionarios.get(idFuncionario), aumento);

                    break;

                case 3:

                    System.out.print("ID Prato: ");

                    int idPrato = scanner.nextInt();

                    System.out.print("Quantidade: ");

                    int qtd = scanner.nextInt();

                    System.out.print("1-Presencial / 2-Delivery: ");

                    boolean isDel = scanner.nextInt() == 2;

                    System.out.println("Pagamento: 1-Pix | 2-Débito | 3-Crédito | 4-Espécie");

                    int tipoPagamento = scanner.nextInt();

                    IPagamentos metodo = (IPagamentos) switch(tipoPagamento) {

                        case 1 -> new Pix();

                        case 2 -> new Debito();

                        case 3 -> new Credito();

                        case 4 -> new Especie();

                        default -> new Exception("Método de Pagamento Indisponível");

                    };

                    VendaService venda = new VendaService(metodo);

                    try {

                        double total = venda.realizarVenda(cardapio.get(idPrato), qtd, isDel);

                        faturamentoTotal += total;

                        System.out.println("VENDA OK! Total: R$ " + total);

                    }catch (Exception e){

                        System.out.println("ERRO: " + e.getMessage());

                    }

                    break;

            }

        }
    }

    private static void inicializarDados() {

        funcionarios.add(new Funcionario("Lucas (Dono)", "Gerente", 8000));

        cardapio.add(new Prato("Feijoada Completa", 45.0, 10));

        cardapio.add(new Prato("Moqueca de Peixe", 65.0, 5));

    }

}
