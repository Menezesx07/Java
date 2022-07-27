package br.com.agenda.factory;

import java.sql.DriverManager;
import java.sql.Connection;


public class ConnectionFactory {

    private static final String USER = "root";
    private static final String PASSWORD = "0000";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";


    public static Connection creatConectionMySql() throws Exception { //twrows para evitar erros

        //criar conexão com o banco de dados
       Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

       return connection;

    }


    //FUNÇÃO CRIADA APENAS PARA TESTAR SE A CONEXÃO ESTAVA FUNCIONANDO
    public static void main(String[] args) throws Exception {

        //Puxar uma conexão com o bd
        Connection con = creatConectionMySql();


      //testar Conexão
        if(con!=null){
            System.out.println("Conexão obtida com sucesso");
            con.close();
        } else {
            System.out.println("erro");
        }
    }

    }








