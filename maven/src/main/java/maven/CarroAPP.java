package maven;

import java.util.List;
import java.util.Scanner;

public class CarroAPP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarroDAO dao = new CarroDAO();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Carro CRUD Menu ===");
            System.out.println("1. Inserir carro");
            System.out.println("2. Listar todos carros");
            System.out.println("3. Buscar carro por placa");
            System.out.println("4. Atualizar carro");
            System.out.println("5. Deletar carro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opc = sc.nextInt();
            sc.nextLine(); 

            switch (opc) {
                case 1:
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Potência: ");
                    int potencia = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    Carro novoCarro = new Carro(ano, potencia, modelo, placa, marca);
                    if (dao.insert(novoCarro)) {
                        System.out.println("Carro inserido com sucesso!");
                    } else {
                        System.out.println("Erro ao inserir carro.");
                    }
                    break;

                case 2:
                    List<Carro> carros = dao.getAll();
                    System.out.println("\n--- Lista de Carros ---");
                    for (Carro c : carros) {
                        System.out.println(c.getPlaca() + " | " + c.getModelo() + " | " + c.getMarca() 
                                           + " | Ano: " + c.getAno() + " | Potência: " + c.getPotencia());
                    }
                    break;

                case 3:
                    System.out.print("Placa do carro: ");
                    String buscaPlaca = sc.nextLine();
                    Carro carro = dao.selectByPlaca(buscaPlaca);
                    if (carro != null) {
                        System.out.println("Encontrado: " + carro.getPlaca() + " | " + carro.getModelo()
                                + " | " + carro.getMarca() + " | Ano: " + carro.getAno() 
                                + " | Potência: " + carro.getPotencia());
                    } else {
                        System.out.println("Carro não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Placa do carro a atualizar: ");
                    String updPlaca = sc.nextLine();
                    Carro cUpdate = dao.selectByPlaca(updPlaca);
                    if (cUpdate != null) {
                        System.out.print("Novo ano (" + cUpdate.getAno() + "): ");
                        int novoAno = sc.nextInt();
                        System.out.print("Nova potência (" + cUpdate.getPotencia() + "): ");
                        int novaPot = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Novo modelo (" + cUpdate.getModelo() + "): ");
                        String novoModelo = sc.nextLine();
                        System.out.print("Nova marca (" + cUpdate.getMarca() + "): ");
                        String novaMarca = sc.nextLine();

                        cUpdate.setAno(novoAno);
                        cUpdate.setPotencia(novaPot);
                        cUpdate.setModelo(novoModelo);
                        cUpdate.setMarca(novaMarca);

                        if (dao.update(cUpdate)) {
                            System.out.println("Carro atualizado!");
                        } else {
                            System.out.println("Erro ao atualizar carro.");
                        }
                    } else {
                        System.out.println("Carro não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Placa do carro a deletar: ");
                    String delPlaca = sc.nextLine();
                    if (dao.delete(delPlaca)) {
                        System.out.println("Carro deletado!");
                    } else {
                        System.out.println("Erro ao deletar carro.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
