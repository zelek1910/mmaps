package com.example.michal.mm;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class uczelnie extends AppCompatActivity implements OnMapReadyCallback {

    Button button;
    EditText textView;
    GoogleMap map;
    Spinner spinner;
    LocationManager locationManager;
    Map<String, LatLng> universityLocationMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_main);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        fillUniversityLocationMap();
        spinner = (Spinner) findViewById(R.id.spinner);

        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,
                        new ArrayList<String>(universityLocationMap.keySet()));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if(item != null){
                    LatLng sydney = universityLocationMap.get(item);
                    if(sydney != null){
                        map.clear();
                        map.addMarker(new MarkerOptions().position(sydney)
                                .title("Marker in " + item));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,4));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

  /*      button = (Button) findViewById(R.id.button2);
        textView = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Geocoder coder = new Geocoder(getApplicationContext());
                List<Address> address;
                try {
                    String locationName = textView.getText().toString();
                    Geocoder gc = new Geocoder(getApplicationContext());
                    List<Address> addressList = coder.getFromLocationName(locationName, 5);
                    Address location = addressList.get(0);

                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();

                    LatLng sydney = new LatLng(latitude , longitude );
                    map.addMarker(new MarkerOptions().position(sydney)
                            .title("Marker in " + locationName));
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,13));
            } catch (IOException e) {
                    e.printStackTrace();
                }
            }});*/
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        map = googleMap;
        /*LatLng sydney = new LatLng(-33.852, 99.00);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

    }

    private void fillUniversityLocationMap(){
        universityLocationMap.put("fiz",new LatLng(51.776795, 19.488749));
        universityLocationMap.put("Szkola",new LatLng(-23.852, 130.00));
        universityLocationMap.put("Kasia",new LatLng(23.852, -130.00));
    }
}


