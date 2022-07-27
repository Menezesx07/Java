package br.com.agenda.aplicacao;

import br.com.agenda.dao.ContatoDao;
import br.com.agenda.model.Contato;

import java.util.Date;
import java.util.Scanner;

public class main {



    public static void main(String[] args) throws Exception {


        addContato();
    //readContato();


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

            System.out.println("Contato: " + c.getNome() +", " + c.getIdade() + " anos " + c.getDataCadastro());
        }

    }



}
