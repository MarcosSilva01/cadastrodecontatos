/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.marcosfelipe.cadastrodecontatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marcos.fvsilva
 */
public class Cadastro {

    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con = null;

    private String Nome;
    private String DataNascimento;
    private String Email;
    private String Telefone;
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    

    public void insertContatos() throws ClassNotFoundException, SQLException {

        String sql = "insert into Contatos(Nome,DataNascimento,Telefone,Email) "
                + "values (?,?,?,?)";
        con = ConBanco.conexao();

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Nome);
            pst.setString(2, DataNascimento);
            pst.setString(3, Telefone);
            pst.setString(4, Email);

            pst.execute();
            System.out.println("Cadastro efetuado com sucesso!");
            con.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    public void editarContatos() throws ClassNotFoundException {
        String sql = "update Contatos set Nome = ?, DataNascimento = ?, Telefone = ?, Email = ? where  ID_Contato = ?";
        con = ConBanco.conexao();

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Nome);
            pst.setString(2, DataNascimento);
            pst.setString(3, Telefone);
            pst.setString(4, Email);
            pst.setInt(5, ID);

            pst.executeUpdate();
            System.out.println("Update efetudao com sucesso!");
            con.close();
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    public void excluirContatos() throws ClassNotFoundException {
        String sql = "delete from Contatos where Nome = ? and ID_Contato = ?";
        con = ConBanco.conexao();

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Nome);
            pst.setInt(2, ID);

            pst.executeUpdate();
            System.out.println("Contato excluido com sucesso!");
            con.close();
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    public void selecionarContatos() throws ClassNotFoundException {
        String sql = "select * from Contatos";
        con = ConBanco.conexao();
        try {
            pst = con.prepareStatement(sql);

            System.out.println(rs = pst.executeQuery());
        } catch (Exception error) {
            System.out.println(error);
        }
    }

}
