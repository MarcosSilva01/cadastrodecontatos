/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.marcosfelipe.cadastrodecontatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author marcos.fvsilva
 */
public class ConBanco {

    public static Connection conexao() throws ClassNotFoundException {
        Connection con = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=cadastroContatos";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(url, "MarcosFelipe", "12345678");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException error) {
            System.out.println(null + "SQLServer: " + error);
            return null;
        }

        return con;
    }
}
