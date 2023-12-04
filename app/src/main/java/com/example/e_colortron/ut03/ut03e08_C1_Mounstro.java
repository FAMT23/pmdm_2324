package com.example.e_colortron.ut03;

import android.graphics.Color;

import java.io.Serializable;

public class ut03e08_C1_Mounstro implements Serializable {
    int extremidades;
    String nombre, color;
    int  patasIz, patasDer, manosIz,manosDer;

    public ut03e08_C1_Mounstro(int extremidades, String nombre, String color){
        this.extremidades=extremidades;
        this.nombre=nombre;
        this.color=color;
    }

    public String toString() {

        patasIz= (int) ((Math.random()*extremidades));
        patasDer= (int) ((Math.random()*(extremidades-patasIz)));
        manosIz= (int) ((Math.random()*(extremidades-patasIz-patasDer)));
        manosDer= (extremidades-patasIz-patasDer-manosIz);

        int max_char=Math.max(Math.max(manosIz,manosDer),Math.max(patasIz,patasDer));


        String figuraMountro=nChar('/',patasIz, max_char-patasIz)+" o "+
                nChars('\\',patasDer)+"\n"+
                nChar('/',manosIz,max_char-manosIz)+"   "+
                nChars('\\',manosDer);
        return figuraMountro;
    }

    public  String nChars(char caracter,int nVeces){
        String cadena="";
        for(int i=0;i<nVeces;i++){
            cadena=cadena+caracter;
        }
        return (cadena);
    }
    public  String nChar(char caracter,int nVeces, int nBlanco){
        String cadena="";
        for(int i=0;i<nBlanco;i++){
            cadena=cadena+" ";
        }
        for(int i=0;i<nVeces;i++){
            cadena=cadena+caracter;
        }
        return (cadena);
    }
}
