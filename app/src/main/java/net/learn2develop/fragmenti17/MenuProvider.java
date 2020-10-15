package net.learn2develop.fragmenti17;

import java.util.ArrayList;
import java.util.List;

public class MenuProvider {

    private static List<String> menu;
    // init proverava da li su jela popunjena
    private static void init(){
        if(menu == null){
            menu = new ArrayList<>();
            menu.add("Domaca supa od krtole i svezeg pileceg mesa, sa dodatkom divljih borovnica sa obronka Niksice Zupe.");
            menu.add("Corba napravljena od svezeg ulova sa podrucja Niksica.");
        }
    }
    public static List<String> getAllMenu(){
        init();
        return menu;
    }
    public static String getMenuById(int id){
        init();
        if ((id>=0) && (id<menu.size())){
            return menu.get(id);
        }
        //ako je null znaci da nema nista
        return null;
    }
}
