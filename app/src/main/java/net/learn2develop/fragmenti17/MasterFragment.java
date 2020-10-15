package net.learn2develop.fragmenti17;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class MasterFragment extends Fragment {
    private ListView lvJelo;
    private List<String> jelo;
    //Kada smo odredili interface, ovde ga ubacujemo
    private onJeloClickListener listener;


    public MasterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_master, container, false);
    }
    //Svu View-ovi nasledjuju View i zato ovde kreiramo metode

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvJelo = view.findViewById(R.id.lvJelo);
        //Kad smo odredili metodu setupList, dodajemo ovde. Uvek pozovemo ovu metodu. Sad bi trebalo da
        //nam app radi i prikaze listu, kada smo odredili showList u Main-u (to je poslednji korak u ovom slucaju)
        setupList();
    }
    // Drugi korak je napraviti novu metodu - nasu listu, kako bi se povezala sa adapterom
    private void setupList(){
        jelo = JeloProvider.getAllJelo();
        //Fragment nema kontekst this kao Activity, ali zato ima getActivity. U ovom slucaju nas data je jelo.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, jelo);
        lvJelo.setAdapter(adapter);

         //Kada smo oderedili fragment_details.xml i DetailsFragement, vracamo se do MasterFragment i dodajemo nove atribute i metode
        // Sada pravimo anonimnu klasu, koda ce nam implementirati sta ce konkretno nesto da se desi na listi

        lvJelo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //pozivamo metodu if kako bismo se uverili da nam app ne bi pucao
                if(listener != null){
                    //za position cemo pretpostaviti da nam je to id Jela te cemo zato simulirati
                    listener.onJeloClicked(position);
                }
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //Sada proveravamo da li kontekst implementira onJeloClickListener. Mogli bismo to uraditi i sa try/catch metodom
        if (context instanceof onJeloClickListener){
            //obvezno moramo kastovati
            listener = (onJeloClickListener)context;
        }else{
            Toast.makeText(getContext(), "Moramo implementirati interfejs", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //Pre nego sto odemo da odredjujemo metode onAttach i onDetach, moramo kreirati interfejs, koji ce da implementira Activity
    //i ujedno da pozove fragment_details
    interface onJeloClickListener{
        //public metoda uvek za interface
        void onJeloClicked (int id);
    }
}