package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ContatoDao {


    public void create(Contato contato) {

        //comando sql
        String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?, ?, ?)";

        Connection conn = null; //criando a variavel de conexão
        PreparedStatement pstm = null; //criando a variavel de preparação dos dados

        try {
            //criando conexão com o BD
            conn = ConnectionFactory.creatConectionMySql();

            //criando o PreparedStatement para funcionar a inserção de dados
            pstm = conn.prepareStatement(sql);

            //Adicionar os valores esperados
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            pstm.execute(); //PARA EXECUTAR O COMANDO DE INSERÇÃO

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fechar as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    } //final função create


    public static List<Contato> getContatos() {

        String sql = "SELECT * FROM contatos";
        List<Contato> contatos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;

        //Recuperar os dados do bd com o "SELECT * FROM"
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.creatConectionMySql(); //criando a conexão com o BD

            pstm = conn.prepareStatement(sql); //inserindo os dados no sql (SELECT * FROM)

            rst = pstm.executeQuery(); //"array" que vai salvar os dados da consulta

            while (rst.next()) {
                Contato contato = new Contato(); //criando um objeto com os parametros do Contato.java

                //recuperando o id
                contato.setId(rst.getInt("id")); //setando o id com as informações do rst

                //recuperando o nome
                contato.setNome(rst.getString("nome")); //setando o nome com as informações do rst

                //recuperando a idade
                contato.setIdade(rst.getInt("idade")); //setando a idade com as informações do rst

                //recuperando a data
                contato.setDataCadastro(rst.getTime("dataCadastro")); //setando a data com as informações do rst

                contatos.add(contato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }

                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return contatos;

    } //final função list<contatos>

}
