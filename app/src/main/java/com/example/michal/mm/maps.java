package com.example.michal.mm;import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

;

public class maps extends AppCompatActivity implements OnMapReadyCallback {

    Button button2;
    EditText textView;
    GoogleMap map;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        button2 = (Button) findViewById(R.id.button2);
        textView = (EditText) findViewById(R.id.editText);
        button2.setOnClickListener(new View.OnClickListener() {
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
            }});
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        map = googleMap;
      //  LatLng sydney = new LatLng(-33.852, 99.00);
     //   googleMap.addMarker(new MarkerOptions().position(sydney)
    //          .title("Marker in Sydney"));
    //    googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

}
