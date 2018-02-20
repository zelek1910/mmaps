package com.example.michal.mm;

import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class wyznacz extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    public void onMapReady(GoogleMap googleMap) {
        GoogleMap mMap;
        LatLng fiz = new LatLng(51.776795, 19.488749);
        googleMap.addMarker(new MarkerOptions().position(fiz).title("fizy"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(fiz));
    }
}
