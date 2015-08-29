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

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Digite sua opção:");
        String opcao = "";
        boolean teste = false;
        do {
            System.out.println("\n(1) Cadastro de contatos"
                    + "\n(9) Sair");
            opcao = entrada.next();
            if (opcao.equals("1")) {
                entradaDados();
            } else if (opcao.equals("9")) {
                teste = true;
            } else {
                System.out.println("Opção invalida !");
            }
        } while (teste == false);

    }
}
