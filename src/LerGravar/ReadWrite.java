/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LerGravar;

import classes.Carro;
import classes.Dre;
import classes.Endereco;
import classes.Orcamento;
import classes.OrdemServico;
import classes.Pessoa;
import classes.Telefone;
import classes.Peca;
import classes.Servico;
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
    final String ARQUIVOOCAMENTO = "txt/orcamentos.txt";
    final String ARQUIVOPECAS = "txt/pecas.txt";
    final String ARQUIVOSERVICOS = "txt/servicos.txt";
    final String ARQUIVOOS = "txt/os.txt";
    final String ARQUIVODRE = "txt/dre.txt";

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
                carros.get(cont).setIdPessoa(Integer.parseInt(ler[1]));
                carros.get(cont).setPlaca(ler[2]);
                carros.get(cont).setModelo(ler[3]);
                carros.get(cont).setFabricante(ler[4]);
                carros.get(cont).setMotor(ler[5]);
                carros.get(cont).setAno(ler[6]);
                carros.get(cont).setKm(Integer.parseInt(ler[7]));
                carros.get(cont).setStatus(Boolean.valueOf(ler[8]));

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
    //escreve Orçamento arquivo txt

    public boolean writeOrcamento(List<Orcamento> objetoGravar) {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(ARQUIVOOCAMENTO));

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

    // ler Orçamento arquivo txt
    public ArrayList<Orcamento> readOrcamento() {

        int cont = 0;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader(ARQUIVOOCAMENTO));
            String[] ler;

            //le primeira linha arquivo
            try {

                ler = read.readLine().split(";");

            } catch (Exception e) {
                ler = null;
            }
            ArrayList<Orcamento> orcamentos = new ArrayList<>();

            while (ler != null) {

                orcamentos.add(new Orcamento());
                try {

                    orcamentos.get(cont).setId(Integer.parseInt(ler[0]));
                    orcamentos.get(cont).setIdCarro(Integer.parseInt(ler[1]));
                    orcamentos.get(cont).setDescricaoProblema(ler[2]);
                    orcamentos.get(cont).setValorTotalPecas(Double.parseDouble(ler[3]));
                    orcamentos.get(cont).setValorTotalMaoObra(Double.parseDouble(ler[4]));
                    orcamentos.get(cont).setValorTotalOrcamento(Double.parseDouble(ler[5]));
                    orcamentos.get(cont).setDataAtual(ler[6]);
                    orcamentos.get(cont).setHoraAtual(ler[7]);
                    orcamentos.get(cont).setStatus(Boolean.valueOf(ler[8]));

                    cont++;
                } catch (Exception e) {
                    return null;
                }

                try {
                    //le proxima linha do arquivo
                    ler = read.readLine().split(";");
                } catch (Exception e) {
                    ler = null;
                }

            }

            return orcamentos;

        } catch (FileNotFoundException ex) {
            return null;

        }

    }
    //escreve Peças arquivo txt

    public boolean writePecas(List<Peca> objetoGravar) {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(ARQUIVOPECAS));

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

    // ler Orçamento arquivo txt
    public ArrayList<Peca> readPecas() {

        int cont = 0;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader(ARQUIVOPECAS));
            String[] ler;

            //le primeira linha arquivo
            try {

                ler = read.readLine().split(";");

            } catch (Exception e) {
                ler = null;
            }
            ArrayList<Peca> pecas = new ArrayList<>();

            while (ler != null) {

                pecas.add(new Peca());

                pecas.get(cont).setIdOrcamento(Integer.parseInt(ler[0]));
                pecas.get(cont).setNome(ler[1]);
                pecas.get(cont).setPreco(Double.parseDouble(ler[2]));

                cont++;
                try {
                    //le proxima linha do arquivo
                    ler = read.readLine().split(";");
                } catch (Exception e) {
                    ler = null;
                }

            }

            return pecas;

        } catch (FileNotFoundException ex) {
            return null;

        }

    }
    //escreve Serviços arquivo txt

    public boolean writeServicos(List<Servico> objetoGravar) {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(ARQUIVOSERVICOS));

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

    // ler Orçamento arquivo txt
    public ArrayList<Servico> readServicos() {

        int cont = 0;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader(ARQUIVOSERVICOS));
            String[] ler;

            //le primeira linha arquivo
            try {

                ler = read.readLine().split(";");

            } catch (Exception e) {
                ler = null;
            }
            ArrayList<Servico> servicos = new ArrayList<>();

            while (ler != null) {

                servicos.add(new Servico());

                servicos.get(cont).setIdOrcamento(Integer.parseInt(ler[0]));
                servicos.get(cont).setDescricao(ler[1]);
                servicos.get(cont).setPreco(Double.parseDouble(ler[2]));

                cont++;
                try {
                    //le proxima linha do arquivo
                    ler = read.readLine().split(";");
                } catch (Exception e) {
                    ler = null;
                }

            }

            return servicos;

        } catch (FileNotFoundException ex) {
            return null;

        }

    }

    //escreve od arquivo txt
    public boolean writeOs(List<OrdemServico> objetoGravar) {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(ARQUIVOOS));

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

    // ler os arquivo txt
    public ArrayList<OrdemServico> readOs() {

        int cont = 0;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader(ARQUIVOOS));
            String[] ler;

            //le primeira linha arquivo
            try {

                ler = read.readLine().split(";");

            } catch (Exception e) {
                ler = null;
            }
            ArrayList<OrdemServico> oss = new ArrayList<>();

            while (ler != null) {

                oss.add(new OrdemServico());

                oss.get(cont).setId(Integer.parseInt(ler[0]));
                oss.get(cont).setIdCarro(Integer.parseInt(ler[1]));
                oss.get(cont).setIdOrcamento(Integer.parseInt(ler[2]));
                oss.get(cont).setIdPessoa(Integer.parseInt(ler[3]));
                oss.get(cont).setServicoExecutado(ler[4]);
                oss.get(cont).setDataFinalizada(ler[5]);
                oss.get(cont).setKmAtual(ler[6]);
                oss.get(cont).setStatus(Boolean.valueOf(ler[7]));

                cont++;
                try {
                    //le proxima linha do arquivo
                    ler = read.readLine().split(";");
                } catch (Exception e) {
                    ler = null;
                }

            }

            return oss;

        } catch (FileNotFoundException ex) {
            return null;

        }

    }

    //escreve dre arquivo txt
    public boolean writeDre(Dre objetoGravar) {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(ARQUIVODRE));

            writer.write(objetoGravar.salvar());
            writer.newLine();

            writer.close();
            return true;

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    // ler os arquivo txt
    public Dre readDre() {

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader(ARQUIVODRE));
            String[] ler = null;

            //le primeira linha arquivo
            try {
                ler = read.readLine().split(";");
            } catch (IOException ex) {
                Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
            }

            Dre dre = new Dre();

            dre.setVendas(Double.parseDouble(ler[0]));
            dre.setImposto(Double.parseDouble(ler[1]));
            dre.setCustos(Double.parseDouble(ler[2]));
            dre.setDespesas(Double.parseDouble(ler[3]));
            dre.setLucroBruto(Double.parseDouble(ler[4]));
            dre.setVendasLiquidas(Double.parseDouble(ler[5]));
            dre.setLucroOperacional(Double.parseDouble(ler[6]));
            dre.setLucroLiquido(Double.parseDouble(ler[7]));
            dre.setData(ler[8]);

            return dre;

        } catch (FileNotFoundException ex) {
            return null;

        }

    }

}
