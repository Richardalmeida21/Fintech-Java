package br.com.fiap.dao;

import br.com.fiap.model.Conta;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    public void insert(Conta conta) throws SQLException {
        String sql = "INSERT INTO CONTAS (CODIGO_CONTA, CODIGO_USUARIO, SALDO, TIPO_CONTA) VALUES (?, ?, ?, ?)";
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, conta.getCodigoConta());
            stmt.setInt(2, conta.getCodigoUsuario());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setString(4, conta.getTipoConta()); // Se tiver essa informação no modelo

            stmt.executeUpdate();
            System.out.println("Conta inserida com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir conta: " + e.getMessage());
        }
    }

    public List<Conta> getAll() throws SQLException {
        String sql = "SELECT * FROM CONTAS";
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            List<Conta> contas = new ArrayList<>();
            while (rs.next()) {
                contas.add(new Conta(
                        rs.getInt("CODIGO_CONTA"),
                        rs.getInt("CODIGO_USUARIO"),
                        rs.getDouble("SALDO"),
                        rs.getString("TIPO_CONTA") // Se tiver essa informação no modelo
                ));
            }
            return contas;
        } catch (SQLException e) {
            System.err.println("Erro ao consultar contas: " + e.getMessage());
            return new ArrayList<>(); // Retorna uma lista vazia em caso de erro
        }
    }
}
