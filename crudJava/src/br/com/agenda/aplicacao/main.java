package br.com.agenda.aplicacao;

import br.com.agenda.dao.ContatoDao;
import br.com.agenda.model.Contato;

import java.util.Date;
import java.util.Scanner;

public class main {



    public static void main(String[] args) throws Exception {


       // addContato();
      // readContato();
       // updateContato();
       // deleteContato();


    }

    public static void addContato()  {
        ContatoDao contatoDao = new ContatoDao();
        Scanner src1 = new Scanner(System.in);
        Scanner src2 = new Scanner(System.in);

        System.out.println("Digite o nome");
        String nome = src1.nextLine();

        System.out.println("Digite a idade");
        Integer idade = src2.nextInt();

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setIdade(idade);
        contato.setDataCadastro(new Date());



        contatoDao.create(contato);
    }

    public static void readContato () {

        for(Contato c : ContatoDao.getContatos()){ //criando um objeto do script "Contato.java", e dizendo que para cada
                                                    //item lido na busca do bd armazenado no "getContato()" do "Contato.dao"

            System.out.println("Contato: " + c.getNome() +", " + c.getIdade() + " anos " + c.getDataCadastro() + " id " + c.getId());
        }

    }

    public static void updateContato(){
        ContatoDao contatoDao = new ContatoDao(); //contatodao.java
        Scanner scr3 = new Scanner(System.in); //id
        Scanner scr4 = new Scanner(System.in); //nome
        Scanner scr5 = new Scanner(System.in); //idade

        Contato contato = new Contato(); //contato.java

        System.out.println("Digite o id do contato para alterar o Contato");
        Integer id = scr3.nextInt();
        contato.setId(id);

        System.out.println("Digite o novo nome");
        String nome = scr4.nextLine();
        contato.setNome(nome);

        System.out.println("Digite a nova idade");
        Integer idade = scr5.nextInt();
        contato.setIdade(idade);
        contato.setDataCadastro(new Date());

        contatoDao.update(contato); //comando para parametrizar tudo e todar o update no contatoDao.java

    }

    public static void deleteContato(){
        ContatoDao contatoDao = new ContatoDao();
         Scanner scr6 = new Scanner(System.in); //id

        Contato contato = new Contato();

        System.out.println("Digite o id que deseja deletar ");
        Integer id = scr6.nextInt();

        contato.setId(id);

        contatoDao.delete(contato);


    }

}
