package net.learn2develop.fragmenti17;

import java.util.ArrayList;
import java.util.List;

public class JeloProvider {
    // static znaci da nije vezana za instancu, nego za samu klasu
    private static List<String> jelo;
    // init proverava da li su jela popunjena
    private static void init(){
        if(jelo == null){
            jelo = new ArrayList<>();
            jelo.add("Pileca supa");
            jelo.add("Riblja corba");
        }
    }
    public static List<String> getAllJelo(){
        init();
        return jelo;
    }
    public static String getJeloById(int id){
        init();
        if ((id>=0) && (id<jelo.size())){
            return jelo.get(id);
        }
        //ako je null znaci da nema nista
        return null;
    }
}
