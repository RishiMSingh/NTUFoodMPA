package com.example.foodcollectionntu;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng thePoint = new LatLng(52.912179, -1.183643 );
        LatLng theRefectory = new LatLng(52.912218, -1.185311);
        LatLng cafeBarista = new LatLng(52.911992,-1.186202);
        LatLng NTU = new LatLng(52.911697,-1.185590);
        mMap.addMarker(new MarkerOptions().position(thePoint).title("The Point"));
        mMap.addMarker(new MarkerOptions().position(theRefectory).title("The Refectory"));
        mMap.addMarker(new MarkerOptions().position(cafeBarista).title("Cafe Barista"));
        mMap.addMarker(new MarkerOptions().position(NTU).title("Nottingham Trent University Clifton campus"));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(NTU));
    }
}