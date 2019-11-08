/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LerGravar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadWrite {

    public ReadWrite() {
    }

    public void write(String fileName, List<Object> objetoGravar) {

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            
            //Collections.sort(objetoGravar);

            for (int i = 0; i < objetoGravar.size(); i++) {

                //writer.write(objetoGravar.get(i).saidaSalvar());
                writer.newLine();

            }

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Object> read(String fileName) {

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
            ArrayList<Object> estatisticas = new ArrayList<>();

            while (ler != null) {

                estatisticas.add(new Object());

//                estatisticas.get(cont).setCodCidade(Integer.parseInt(ler[0]));
//                estatisticas.get(cont).setNomeCidade(ler[1]);
//                estatisticas.get(cont).setQtdAcidente(Integer.parseInt(ler[2]));
//                estatisticas.get(cont).setTipoVeiculo(Integer.parseInt(ler[3]));

                cont++;
                try {
                    //le proxima linha do arquivo
                    ler = read.readLine().split(";");
                } catch (Exception e) {
                    ler = null;
                }

            }

            return estatisticas;

        } catch (FileNotFoundException ex) {
//            InOut.out("Não existe estatisticas gravadas no banco");
            return null;

        }

    }

   
}
