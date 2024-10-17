package br.com.fiap;

import br.com.fiap.dao.*;
import br.com.fiap.model.*;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Testar a conexão com o banco de dados
        try {
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexão realizada!");

            // Criar objetos DAO
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            InvestimentoDAO investimentoDAO = new InvestimentoDAO();
            ContaDAO contaDAO = new ContaDAO();
            DespesaDAO despesaDAO = new DespesaDAO();
            ReceitaDAO receitaDAO = new ReceitaDAO();

            // Inserir um novo usuário
            Usuario usuario = new Usuario(9, "Karina", "karina@gmail.com", "karina2024", LocalDate.now());
            usuarioDAO.insert(usuario); // Inserir o usuário

            // Inserir um novo investimento
            investimentoDAO.insert(new Investimento(13, 9, 1500.0, "Imobiliária", LocalDate.now()));

            // Inserir uma nova conta
            contaDAO.insert(new Conta(9, 9, 10000.0, "Corrente")); // Conta associada ao usuário Karina

            // Inserir uma nova despesa
            despesaDAO.insert(new Despesa(9, 9, 500.0, LocalDate.now(), 2)); // Usando LocalDate

            // Inserir uma nova receita
            receitaDAO.insert(new Receita(9, 9, 3000.0, LocalDate.now(), 1)); // Usando LocalDate

            // Consultar todos os investimentos
            List<Investimento> investimentos = investimentoDAO.getAll();
            for (Investimento inv : investimentos) {
                System.out.println(inv);
            }

            // Consultar todas as contas
            List<Conta> contas = contaDAO.getAll();
            for (Conta conta : contas) {
                System.out.println(conta);
            }

            // Consultar todas as despesas
            List<Despesa> despesas = despesaDAO.getAll();
            for (Despesa despesa : despesas) {
                System.out.println(despesa);
            }

            // Consultar todas as receitas
            List<Receita> receitas = receitaDAO.getAll();
            for (Receita receita : receitas) {
                System.out.println(receita);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
