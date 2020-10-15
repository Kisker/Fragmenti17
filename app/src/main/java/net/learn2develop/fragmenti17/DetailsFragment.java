package net.learn2develop.fragmenti17;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
    private TextView tvJelo;
    private TextView tvMenu;
    private int id;

    public DetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }
// Dodajemo jos dve metode kako bismo setovali id i takodje update-ovali. Plus moramo staviti ispod updateId tvJelo.setText,
    //kako bismo kompletno pozvali tu metodu, Bitno je napomenuti da updateId i setupViews rade u korelaciji
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvJelo = view.findViewById(R.id.tvJelo);
        tvMenu = view.findViewById(R.id.tvMenu);
        //Kada odredimo setupViews metodu, moramo ovde postaviti, kako bi nam jela bila prikazana na drugom ekranu
        setupViews();

    }
    private void setupViews (){
        tvJelo.setText(JeloProvider.getJeloById(id));
        tvMenu.setText(MenuProvider.getMenuById(id));
    }

    public void setId (int id){
        this.id = id;
    }
    public void updateId (int id){
        this.id = id;
        tvJelo.setText(JeloProvider.getJeloById(id));
    }
}