/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.marcosfelipe.cadastrodecontatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos.fvsilva
 */
public class Cadastro {

    PreparedStatement pst = null;
    Connection con = null;

    private String Nome;
    private String DataNascimento;
    private String Email;
    private String Telefone;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setDataNascimento(String nascimento) {
        this.Email = nascimento;
    }

    public String Telefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        this.Nome = telefone;
    }

    public void insertContatos() throws ClassNotFoundException, SQLException {

        String sql = "insert into cadastroContatos(Nome,DataNascimento,Telefone,Email) "
                + "values (?,?,?,?)";
        con = ConBanco.conexao();

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Nome);
            pst.setString(2, DataNascimento);
            pst.setString(3, Telefone);
            pst.setString(4, Email);

            pst.execute();
            con.close();
            System.out.println("Cadastro realizado com sucesso !");
        } catch (SQLException error) {
            System.out.println(error);
        }
    }
}
