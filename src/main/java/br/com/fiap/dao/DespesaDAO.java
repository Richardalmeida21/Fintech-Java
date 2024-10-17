package br.com.fiap.dao;

import br.com.fiap.model.Despesa;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {

    public void insert(Despesa despesa) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO DESPESAS (CODIGO_DESPESA, CODIGO_USUARIO, VALOR, DATA_DESPESA, CODIGO_CATEGORIA) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, despesa.getCodigoDespesa());
        stmt.setInt(2, despesa.getCodigoUsuario());
        stmt.setDouble(3, despesa.getValor());
        stmt.setDate(4, java.sql.Date.valueOf(despesa.getDataDespesa())); // Converter LocalDate para java.sql.Date
        stmt.setInt(5, despesa.getCodigoCategoria());

        try {
            stmt.executeUpdate();
            System.out.println("Despesa inserida com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir despesa: " + e.getMessage());
        } finally {
            stmt.close();
            conexao.close();
        }
    }

    public List<Despesa> getAll() throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM DESPESAS";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Despesa> despesas = new ArrayList<>();
        while (rs.next()) {
            despesas.add(new Despesa(
                    rs.getInt("CODIGO_DESPESA"),
                    rs.getInt("CODIGO_USUARIO"),
                    rs.getDouble("VALOR"),
                    rs.getDate("DATA_DESPESA").toLocalDate(), // Converter java.sql.Date para LocalDate
                    rs.getInt("CODIGO_CATEGORIA")
            ));
        }
        rs.close();
        stmt.close();
        conexao.close();

        return despesas;
    }
}
