/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LerGravar;

import classes.Usuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Adriano
 */
public class RWUsuario {

    public static ArrayList<Usuario> lerUsuario() {

        int cont = 0;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader("txt/usuarios.txt"));
            String[] ler;

            //le primeira linha arquivo
            try {

                ler = read.readLine().split(";");

            } catch (Exception e) {
                ler = null;
            }
            ArrayList<Usuario> usuarios = new ArrayList<>();

            while (ler != null) {

                usuarios.add(new Usuario());

                usuarios.get(cont).setId(ler[0]);
                usuarios.get(cont).setNome(ler[1]);
                usuarios.get(cont).setUsuario(ler[2]);
                usuarios.get(cont).setSenha(ler[3]);

                cont++;
                try {
                    //le proxima linha do arquivo
                    ler = read.readLine().split(";");
                } catch (Exception e) {
                    ler = null;
                }

            }

            return usuarios;

        } catch (FileNotFoundException ex) {
            return null;

        }

    }

}
