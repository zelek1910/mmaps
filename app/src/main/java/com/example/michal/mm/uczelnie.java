package com.example.michal.mm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import static com.example.michal.mm.R.id;
import static com.example.michal.mm.R.layout;

public class uczelnie extends AppCompatActivity implements OnMapReadyCallback {
    Spinner spinner;
    GoogleMap map2;
    private String routes;
    ArrayAdapter<CharSequence> adapter;

    @Override

    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        map2 = googleMap;
        LatLng fiz = new LatLng(51.776795, 19.488749);
        googleMap.addMarker(new MarkerOptions().position(fiz).title("fizy"));
         googleMap.moveCamera(CameraUpdateFactory.newLatLng(fiz));
              LatLng fizyka = new LatLng(51.776795, 19.488749        );

            Marker m_fizyka;
           map2.addMarker(new MarkerOptions().position(fizyka).title("fizyka"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.uczelnie);

        spinner = (Spinner) findViewById(+id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Ek-Soc");
        list.add("WPiA");
        list.add("Fizyka");
        list.add("Medyczny");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }
};
        /**   spinner = findViewById(R.id.spinner);
           adapter = ArrayAdapter.createFromResource(this,
           R.array.nazwa_ucz, android.R.layout.simple_spinner_item);
               adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
               spinner.setAdapter(adapter);
         <string-array name="nazwa_ucz">
               <item>WPIA</item>
               <item>EK_Soc</item>
               <item>Fiz</item>
               <item>Mat</item>
               <item>Bio</item>
               <item>Che</item>
       */






