/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LerGravar;

import classes.Endereco;
import classes.Pessoa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadWrite {
    
    public void writePessoa(String nomeArquivo, List<Pessoa> objetoGravar) {

        BufferedWriter writer;
        
        try {
            writer = new BufferedWriter(new FileWriter(nomeArquivo));
            
            //Collections.sort(objetoGravar);

            for (int i = 0; i < objetoGravar.size(); i++) {

                writer.write(objetoGravar.get(i).salvar());
                writer.newLine();

            }

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void writeEndereco(String nomeArquivo, List<Endereco> objetoGravar) {

        BufferedWriter writer;
        
        try {
            writer = new BufferedWriter(new FileWriter(nomeArquivo));
            
            //Collections.sort(objetoGravar);

            for (int i = 0; i < objetoGravar.size(); i++) {

                writer.write(objetoGravar.get(i).salvar());
                writer.newLine();

            }

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public ArrayList<Pessoa> readPessoa(String fileName) {

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
//                pessoa.get(cont).setTelefone(Integer.parseInt(ler[3]));
//                pessoa.get(cont).setTelefone2(Integer.parseInt(ler[4]));
//                pessoa.get(cont).setEndereco(Integer.parseInt(ler[5]));
//                pessoa.get(cont).setCarro(Integer.parseInt(ler[6]));
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
            return null;

        }

    }

   
}
