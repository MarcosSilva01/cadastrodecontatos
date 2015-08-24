/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.marcosfelipe.cadastrodecontatos;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author marcos.fvsilva
 */
public class exe1 {

    static Connection con = null;
    static String nome, dataNascimento, email, telefone;
    PreparedStatement pst = null;
    static Scanner entrada = new Scanner(System.in);

    
    static void entradaDados() throws ClassNotFoundException, SQLException {
        try {
            Cadastro cad = new Cadastro();
            cad.setNome(nome);
            cad.setDataNascimento(dataNascimento);
            cad.setTelefone(telefone);
            cad.setEmail(email);
            
            cad.insertContatos();
            //return true;
        } catch (NumberFormatException | ClassNotFoundException error) {
            System.out.println(error);
            //return false;
        }
    }
    
    static void popula(){
        System.out.println("Cadastro de Contatos:\n"
                + "Nome, Data de Nascimento, E-mail, Telefone\n\n");
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        System.out.print("Data de nascimento: ");
        dataNascimento = entrada.nextLine();
        System.out.print("E-mail: ");
        email = entrada.nextLine();
        System.out.print("Telefone: ");
        telefone = entrada.nextLine();
    }
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Digite sua opção:");
        int opcao=0;
        boolean teste=false;
        do{
            System.out.println("\n(1) Cadastro de contatos"
                    + "\n(9) Sair");
            opcao = entrada.nextInt();
            if(opcao==1){
                popula();
                entradaDados();
            }
            else if(opcao==9){
                System.exit(0);
            }
            else{
                System.out.println("Opção invalida !");
            }
        }while(teste=false);
        
        
        
        
    }
    
    /*public void insertContato() throws ClassNotFoundException {
        String sql = "insert into contatos"
                + "values(Nome = ?,Celular = ?,Email = ?,Rua = ?,"
                + "Numero = ?,Bairro = ?,Complemento = ?,Funcional = ? where  CPF = ?";
        con = ConBanco.conexao();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, dataNascimento);
            pst.setString(3, email);
            pst.setString(4, telefone);

            pst.execute();

            
            con.close();
        } catch (SQLException error) {
            System.out.println("Impossivel cadastrar !");
        }
    }*/

    

}
