package net.learn2develop.fragmenti17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//Kada smo odradili DetailsFragment zajedno sam Master Fragment i sve nove metode te atribute, moramo implementirati
//MasterFragment kako bi drugi deo app konkretno radio
public class MainActivity extends AppCompatActivity implements MasterFragment.onJeloClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showList();
    }
    // Nova metoda (kada zavrsimo kreiranje metoda u JeloProvider, uvek idemo u Main, kako bismo kreirali novu metodu) koja
    // ce nam prikazati fragmente sa listom svih jela
    private void showList () {
        MasterFragment masterFragment = new MasterFragment();
        //Posto u ovom slucaju nasledjujemo AppCompatActivity, moramo pozvati instancu klase masterFragment, a ne samu klasu (MasterFragment)
        // i koristimo getSupportFragmentManager. U slucaju da nasledjujeno Activity, onda bismo koristili getFragmentManager!
        getSupportFragmentManager().beginTransaction().replace(R.id.flFrame, masterFragment).commit();
        //.addToBackStack(null) obrisemo, jer bismo u ovom slucaju morali dvaput na app da stisnemo da izadjemo iz
        //same aplikacije, umesto da to uradimo samo jednom.
        //Posle ovoga moramo pozvati metodu showList u onCreate

        //Kada smo odredili DetailsFragment i Master Fragment, vracamo se u Main, kako bismo pozvali sledece funkcije da nam se prikazu na app
    }
        private void showJelo (int id){
            DetailsFragment fragment = new DetailsFragment();
            fragment.setId(id);
            getSupportFragmentManager().beginTransaction().replace(R.id.flFrame, fragment).addToBackStack(null).commit();

        }
        public void onJeloClicked(int id){
        showJelo(id);

        }
    }
