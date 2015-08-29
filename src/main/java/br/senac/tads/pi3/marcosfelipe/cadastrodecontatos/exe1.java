/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.marcosfelipe.cadastrodecontatos;

import java.util.Scanner;
import java.sql.SQLException;

/**
 *
 * @author marcos.fvsilva
 */
public class exe1 {

    static Scanner entrada = new Scanner(System.in);

    static void entradaDados() throws ClassNotFoundException, SQLException {
        try {

            System.out.println("Cadastro de Contatos:\n"
                    + "Nome, Data de Nascimento, E-mail, Telefone\n\n");
            Cadastro cad = new Cadastro();
            System.out.print("Nome: ");
            cad.setNome(entrada.nextLine());
            System.out.print("Data de nascimento: ");
            cad.setDataNascimento(entrada.nextLine());
            System.out.print("Telefone: ");
            cad.setTelefone(entrada.nextLine());
            System.out.print("E-mail: ");
            cad.setEmail(entrada.nextLine());
            cad.setNome(entrada.next());
            System.out.print("Data de nascimento: ");
            cad.setDataNascimento(entrada.next());
            System.out.print("Telefone: ");
            cad.setTelefone(entrada.next());
            System.out.print("E-mail: ");
            cad.setEmail(entrada.next());

            cad.insertContatos();
        } catch (NumberFormatException | ClassNotFoundException error) {
            System.out.println(error);
        }

    }

    static void listarDados() throws ClassNotFoundException {
        Cadastro cad = new Cadastro();
        cad.selecionarContatos();

    }

    static void editarDados() throws ClassNotFoundException {
        Cadastro cad = new Cadastro();
        System.out.print("Nome: ");
        cad.setNome(entrada.nextLine());
        System.out.print("Data de nascimento: ");
        cad.setDataNascimento(entrada.nextLine());
        System.out.print("Telefone: ");
        cad.setTelefone(entrada.nextLine());
        System.out.print("E-mail: ");
        cad.setEmail(entrada.nextLine());
        System.out.print("ID do Contato: ");
        cad.setID(entrada.nextInt());

        cad.editarContatos();
    }

    static void excluirDados() throws ClassNotFoundException {
        Cadastro cad = new Cadastro();
        System.out.print("Nome: ");
        cad.setNome(entrada.nextLine());
        System.out.print("ID do Contato: ");
        cad.setID(entrada.nextInt());

        cad.excluirContatos();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Digite sua opção:");
        String opcao = "";
        boolean sair = false;
        System.out.println("\n(1) Cadastrar Contatos"
                + "\n(2) Listar Contatos"
                + "\n(3) Editar Contato"
                + "\n(4) Excluir Contato"
                + "\n(9) Sair");
        do {
            opcao = entrada.next();
            if (opcao.equals("1")) {
                entradaDados();
            } else if (opcao.equals("2")) {
                listarDados();
            } else if (opcao.equals("3")) {
                editarDados();
            } else if (opcao.equals("4")) {
                excluirDados();
            } else if (opcao.equals("9")) {
                sair = true;
            } else {
                System.out.println("Opção invalida !");
            }
        } while (sair == false);

    }
}
