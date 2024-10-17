package br.com.fiap.dao;

import br.com.fiap.model.Investimento;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO {

    // Método para inserir um investimento no banco de dados
    public void insert(Investimento investimento) {
        String sql = "INSERT INTO investimentos (codigo_investimento, codigo_usuario, valor, tipo_investimento, data_investimento) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, investimento.getCodigoInvestimento());
            pstmt.setInt(2, investimento.getCodigoUsuario());
            pstmt.setDouble(3, investimento.getValor());
            pstmt.setString(4, investimento.getTipoInvestimento());

            // Usar java.sql.Date para inserir a data
            pstmt.setDate(5, java.sql.Date.valueOf(investimento.getDataInvestimento()));

            pstmt.executeUpdate();
            System.out.println("Investimento inserido com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir investimento: " + e.getMessage());
        }
    }

    // Método para recuperar todos os investimentos
    public List<Investimento> getAll() {
        List<Investimento> investimentos = new ArrayList<>();
        String sql = "SELECT * FROM investimentos";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                // Recuperar a data corretamente usando getDate()
                Date dataInvestimento = rs.getDate("data_investimento");

                Investimento investimento = new Investimento(
                        rs.getInt("codigo_investimento"),
                        rs.getInt("codigo_usuario"),
                        rs.getDouble("valor"),
                        rs.getString("tipo_investimento"),
                        dataInvestimento.toLocalDate() // Converter para LocalDate se necessário
                );
                investimentos.add(investimento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar investimentos: " + e.getMessage());
        }
        return investimentos;
    }
}
