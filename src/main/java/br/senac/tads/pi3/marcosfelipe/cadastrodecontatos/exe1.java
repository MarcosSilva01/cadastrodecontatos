/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.marcosfelipe.cadastrodecontatos;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author marcos.fvsilva
 */
public class exe1 {

    static Connection con = null;
    static String nome, dataNascimento, email, telefone;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Cadastro de Contatos:\n"
                + "Nome, Data de Nascimento, E-mail, Telefone\n\n");
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        System.out.print("Data de nascimento: ex(14/08/2015");
        dataNascimento = entrada.nextLine();
        System.out.print("E-mail: ");
        email = entrada.nextLine();
        System.out.print("Telefone: ");
        telefone = entrada.nextLine();
    }

    public boolean entradaDados() throws ClassNotFoundException, SQLException {
        try {
            Cadastro cad = new Cadastro();
            cad.setNome(nome);
            cad.setDataNascimento(dataNascimento);
            cad.setTelefone(telefone);
            cad.setEmail(email);
            
            cad.insertContatos();
            return true;
        } catch (NumberFormatException | ClassNotFoundException error) {
            System.out.println(error);
            return false;
        }
    }

}
