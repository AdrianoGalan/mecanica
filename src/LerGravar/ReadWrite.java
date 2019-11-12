/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LerGravar;

import classes.Carro;
import classes.Endereco;
import classes.Pessoa;
import classes.Telefone;
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

    final String ARQUIVOPESSOA = "txt/pessoas.txt";
    final String ARQUIVOENDERECO = "txt/enderecos.txt";
    final String ARQUIVOCARRO = "txt/carros.txt";
    final String ARQUIVOTELEFONE = "txt/telefones.txt";

    //escreve Pessoa arquivo txt
    public void writePessoa(List<Pessoa> objetoGravar) {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(ARQUIVOPESSOA));

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

    // ler pessoa arquivo txt
    public ArrayList<Pessoa> readPessoa() {

        int cont = 0;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader(ARQUIVOPESSOA));
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

    // escreve endereco arquivo txt
    public void writeEndereco(List<Endereco> objetoGravar) {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(ARQUIVOENDERECO));

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

    // ler Endereco arquivo txt
    public ArrayList<Endereco> readEndereco() {

        int cont = 0;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader(ARQUIVOENDERECO));
            String[] ler;

            //le primeira linha arquivo
            try {

                ler = read.readLine().split(";");

            } catch (Exception e) {
                ler = null;
            }
            ArrayList<Endereco> enderecos = new ArrayList<>();

            while (ler != null) {

                enderecos.add(new Endereco());

                enderecos.get(cont).setId(Integer.parseInt(ler[0]));
                enderecos.get(cont).setCep(ler[1]);
                enderecos.get(cont).setRua(ler[2]);
                enderecos.get(cont).setBairro(ler[3]);
                enderecos.get(cont).setCidade(ler[4]);
                enderecos.get(cont).setEstado(ler[5]);
                enderecos.get(cont).setNumero(ler[6]);

                cont++;
                try {
                    //le proxima linha do arquivo
                    ler = read.readLine().split(";");
                } catch (Exception e) {
                    ler = null;
                }

            }

            return enderecos;

        } catch (FileNotFoundException ex) {
            return null;

        }

    }

    //escreve telefone arquivo txt
    public void writeTelefone(List<Telefone> objetoGravar) {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(ARQUIVOTELEFONE));

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

    // ler Telefone arquivo txt
    public ArrayList<Telefone> readTelefone() {

        int cont = 0;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader(ARQUIVOTELEFONE));
            String[] ler;

            //le primeira linha arquivo
            try {

                ler = read.readLine().split(";");

            } catch (Exception e) {
                ler = null;
            }
            ArrayList<Telefone> telefones = new ArrayList<>();

            while (ler != null) {

                telefones.add(new Telefone());

                telefones.get(cont).setId(Integer.parseInt(ler[0]));
                telefones.get(cont).setDdd(ler[1]);
                telefones.get(cont).setNumero(ler[2]);

                cont++;
                try {
                    //le proxima linha do arquivo
                    ler = read.readLine().split(";");
                } catch (Exception e) {
                    ler = null;
                }

            }

            return telefones;

        } catch (FileNotFoundException ex) {
            return null;

        }

    }
    //escreve carro arquivo txt

    public boolean writeCarro(List<Carro> objetoGravar) {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(ARQUIVOCARRO));

            //Collections.sort(objetoGravar);
            for (int i = 0; i < objetoGravar.size(); i++) {

                writer.write(objetoGravar.get(i).salvar());
                writer.newLine();

            }

            writer.close();
            return true;

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    // ler Carro arquivo txt
    public ArrayList<Carro> readCarro() {

        int cont = 0;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader(ARQUIVOCARRO));
            String[] ler;

            //le primeira linha arquivo
            try {

                ler = read.readLine().split(";");

            } catch (Exception e) {
                ler = null;
            }
            ArrayList<Carro> carros = new ArrayList<>();

            while (ler != null) {

                carros.add(new Carro());

                carros.get(cont).setId(Integer.parseInt(ler[0]));
                carros.get(cont).setPlaca(ler[1]);
                carros.get(cont).setModelo(ler[2]);
                carros.get(cont).setFabricante(ler[3]);
                carros.get(cont).setMotor(ler[4]);
                carros.get(cont).setAno(ler[5]);
                carros.get(cont).setKm(Integer.parseInt(ler[6]));
                carros.get(cont).setStatus(Boolean.valueOf(ler[7]));

                cont++;
                try {
                    //le proxima linha do arquivo
                    ler = read.readLine().split(";");
                } catch (Exception e) {
                    ler = null;
                }

            }

            return carros;

        } catch (FileNotFoundException ex) {
            return null;

        }

    }

}
