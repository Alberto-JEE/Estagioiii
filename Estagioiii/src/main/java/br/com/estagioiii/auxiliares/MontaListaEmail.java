/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.auxiliares;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class MontaListaEmail {

    public static List montaLista(String lista) {
        List<String> listaControla = new ArrayList<>();
        String aux[] = lista.split(Pattern.quote(";"));
        listaControla.addAll(Arrays.asList(aux));
        return listaControla;
    }

    public static boolean conexaoInternet() {
        boolean validar = false;
        try {
            InetAddress.getByName("www.google.com.br");
            validar = true;
        } catch (UnknownHostException e) {
        }
        return validar;
    }

}
