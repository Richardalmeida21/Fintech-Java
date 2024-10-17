package br.com.fiap.dao;

import br.com.fiap.model.Receita;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {

    public void insert(Receita receita) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO RECEITAS (CODIGO_RECEITA, CODIGO_USUARIO, VALOR, DATA_RECEITA, CODIGO_CATEGORIA) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, receita.getCodigoReceita());
        stmt.setInt(2, receita.getCodigoUsuario());
        stmt.setDouble(3, receita.getValor());
        stmt.setDate(4, java.sql.Date.valueOf(receita.getDataReceita())); // Converter LocalDate para java.sql.Date
        stmt.setInt(5, receita.getCodigoCategoria());

        try {
            stmt.executeUpdate();
            System.out.println("Receita inserida com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir receita: " + e.getMessage());
        } finally {
            stmt.close();
            conexao.close();
        }
    }

    public List<Receita> getAll() throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM RECEITAS";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Receita> receitas = new ArrayList<>();
        while (rs.next()) {
            receitas.add(new Receita(
                    rs.getInt("CODIGO_RECEITA"),
                    rs.getInt("CODIGO_USUARIO"),
                    rs.getDouble("VALOR"),
                    rs.getDate("DATA_RECEITA").toLocalDate(), // Converter java.sql.Date para LocalDate
                    rs.getInt("CODIGO_CATEGORIA")
            ));
        }
        rs.close();
        stmt.close();
        conexao.close();

        return receitas;
    }
}
