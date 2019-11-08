/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LerGravar;

import classes.Pessoa;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Adriano
 */
public class RWPessoa {
    
    public ArrayList<Pessoa> read(String fileName) {

        int cont = 0;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            String[] ler;

            //le primeira linha arquivo
            try {

                ler = read.readLine().split(";");

            } catch (Exception e) {
                ler = null;
            }
            ArrayList<Pessoa> pessoa = new ArrayList<>();

            while (ler != null) {

                pessoa.add(new Pessoa());

                pessoa.get(cont).setId(Integer.parseInt(ler[0]));
                pessoa.get(cont).setNome(ler[1]);
                pessoa.get(cont).setCpf(ler[2]);
                pessoa.get(cont).setTelefone(Integer.parseInt(ler[3]));
                pessoa.get(cont).setTelefone2(Integer.parseInt(ler[4]));
                pessoa.get(cont).setEndereco(Integer.parseInt(ler[5]));
                pessoa.get(cont).setCarro(Integer.parseInt(ler[6]));
                cont++;
                try {
                    //le proxima linha do arquivo
                    ler = read.readLine().split(";");
                } catch (Exception e) {
                    ler = null;
                }

            }

            return pessoa;

        } catch (FileNotFoundException ex) {
//            InOut.out("Não existe estatisticas gravadas no banco");
            return null;

        }

    }
    
}
