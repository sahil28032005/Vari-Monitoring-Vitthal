package com.example.vari_monitoring;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.vari_monitoring.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    ProgressDialog pgd;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    Handler h;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        h = new Handler();
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        pgd = new ProgressDialog(this);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            return;
        }
        binding.imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgd.show();
                Toast.makeText(MapsActivity.this, "redirecting...", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    pgd.dismiss();
//                                    LatLng place2 = new LatLng(19.7515, 75.7139);
                                    mMap.clear();
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.898615,74.754189)).title("1 NatePute Palkhi starts from here 24 june").icon(setIcon(MapsActivity.this, R.drawable.one))).setSnippet("First Stay");
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.8633,74.9055)).title("2 MalshiRas stay at malshiras 25 june").icon(setIcon(MapsActivity.this, R.drawable.two))).setSnippet("Second Stay");
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.796713,75.053789)).title("3 Velapur stay at velapur 26 june").icon(setIcon(MapsActivity.this, R.drawable.three))).setSnippet("Third Stay");
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.712392,75.213157)).title("4 BhandiShegaon stay at BhandiShegaon 27 june").icon(setIcon(MapsActivity.this, R.drawable.four))).setSnippet("Fourth Stay");
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(18.457855,74.346162)).title("5 Wakhari stay at Wakhari 28 june").icon(setIcon(MapsActivity.this, R.drawable.five))).setSnippet("Fifth Stay");
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.6806,75.3155)).title("6 PandharPur stay at PandharPur 29 june").icon(setIcon(MapsActivity.this, R.drawable.six))).setSnippet("Sixth Stay");


                                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(17.898615,74.754189)));
                                    pgd.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }).start();


            }
        });

        binding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgd.show();
                Toast.makeText(MapsActivity.this, "redirecting...", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    pgd.dismiss();
                                    mMap.clear();
//                                    LatLng place2 = new LatLng(19.7515, 75.7139);17.676813889075998, 75.32693108823216
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.902453417232667,74.75250841057145)).title("नाटेपुते बस स्टँड").icon(setIcon(MapsActivity.this, R.drawable.bussmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.861781358637273,  74.9083471105704)).title("माळशिरस बस स्टँड").icon(setIcon(MapsActivity.this, R.drawable.bussmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.8845657350947,75.01645087089808)).title("अकलूज एमएसआरटीसी बस स्थानक").icon(setIcon(MapsActivity.this, R.drawable.bussmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.676813889075998,75.32693108823216)).title("जुने बसस्थानक").icon(setIcon(MapsActivity.this, R.drawable.bussmall)));

                                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(17.902453417232667,74.75250841057145)));
                                    pgd.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }).start();


            }
        });
        binding.imageButton6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gotoUrl("https://sngprcdnems01.cdnsrv.jio.com/cdndp.cdn.jio.com/LordShri_Vitthal/LordShri_Vitthal_400.m3u8?cdt=xfctPaVzwnj1-V2VZ6Nrtg&exp=1590000000");
//            }
public void onClick(View v) {
    pgd.show();
    Toast.makeText(MapsActivity.this, "redirecting...", Toast.LENGTH_SHORT).show();
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            h.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        pgd.dismiss();
                        mMap.clear();
//                                    LatLng place2 = new LatLng(19.7515, 75.7139);17.665420179450678, 75.33119419448519
                        mMap.addMarker(new MarkerOptions().position(new LatLng(17.6850773732767737,75.33508334004773)).title("अंबाबाई पटांगण(वाहनतळ)").icon(setIcon(MapsActivity.this, R.drawable.parkingsmall)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(17.681235810238576,  17.681235810238576)).title("मातोश्री पाकीँग पंढरपूर").icon(setIcon(MapsActivity.this, R.drawable.parkingsmall)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(17.67541660007151,75.33217306030143)).title("गजानन महाराज भक्त निवासासाठी पार्किंग").icon(setIcon(MapsActivity.this, R.drawable.parkingsmall)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(17.68571340955526,75.30883078303616)).title("शेलार चौक पार्किंग").icon(setIcon(MapsActivity.this, R.drawable.parkingsmall)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(17.67699214749505,75.33179500927092)).title("श्री विठ्ठल रुक्मिणी मंदिर पार्किंग").icon(setIcon(MapsActivity.this, R.drawable.parkingsmall)));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(17.665420179450678,75.33119419448519)).title("येमाई तुकाई पार्किंग").icon(setIcon(MapsActivity.this, R.drawable.parkingsmall)));

                        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(17.685077373276773,75.33508334004773)));
                        pgd.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }).start();


}
        });

        binding.imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pgd.show();
                Toast.makeText(MapsActivity.this, "redirecting...", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    pgd.dismiss();
                                    mMap.clear();
//                                    LatLng place2 = new LatLng(19.7515, 75.7139);17.661815074718973, 75.2987384600516
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.67981010160869,75.33146463833323)).title("एचडीएफसी बँक एटीएम, एचडीएफसी बँक लिमिटेड, नवी पेठ, भादुले चौक, पंढरपूर, महाराष्ट्र ४१३३०४").icon(setIcon(MapsActivity.this, R.drawable.atmsmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.678574695142203, 75.32982986364534)).title("स्टेट बँक ऑफ इंडियाचे एटीएम").icon(setIcon(MapsActivity.this, R.drawable.atmsmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.678084030422553,75.3369967257322)).title("कॉर्पोरेशन बँक एटीएम").icon(setIcon(MapsActivity.this, R.drawable.atmsmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.671623486725398, 75.31858604407428)).title("पंढरपूर अर्बन को-ऑपरेटिव्ह बँक लिमिटेड").icon(setIcon(MapsActivity.this, R.drawable.atmsmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.687980421801683,75.20260736400762)).title("आयसीआयसीआय बँकेचे एटीएम").icon(setIcon(MapsActivity.this, R.drawable.atmsmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.661815074718973,75.2987384600516)).title("बँक ऑफ बडोदा एटीएम").icon(setIcon(MapsActivity.this, R.drawable.atmsmall)));
                                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(17.67981010160869,75.33146463833323)));
                                    pgd.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }).start();

            }
        });

        binding.imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgd.show();
                Toast.makeText(MapsActivity.this, "redirecting...", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    pgd.dismiss();
                                    mMap.clear();
//                                    LatLng place2 = new LatLng(19.7515, 75.7139);17.73870130199375, 75.31503908310297
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.68841995148581,75.31585232126403)).title("संजीवनी हॉस्पिटल पंढरपूर").icon(setIcon(MapsActivity.this, R.drawable.hospitalsmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.676398938753742,   75.33027187612147)).title("रुक्मिणी हॉस्पिटल").icon(setIcon(MapsActivity.this, R.drawable.hospitalsmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.681550899806492,75.33181682842762)).title("अपेक्स हॉस्पिटल, पंढरपूर").icon(setIcon(MapsActivity.this, R.drawable.hospitalsmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.670756145345884,75.3159381519477)).title("लाइफलाइन सुपरस्पेशालिटी हॉस्पिटल पंढरपूर").icon(setIcon(MapsActivity.this, R.drawable.hospitalsmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.67301242058853,75.32472371056554)).title("गॅलेक्सी हॉस्पिटल").icon(setIcon(MapsActivity.this, R.drawable.hospitalsmall)));
                                   //wakhri
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.6869089474846,75.2823095682368)).title("माऊली हॉस्पिटल").icon(setIcon(MapsActivity.this, R.drawable.hospitalsmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.68736489860414,75.28134982590777)).title("वर्धन क्लिनिक").icon(setIcon(MapsActivity.this, R.drawable.hospitalsmall)));

                                    //gursale
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.74017373783491,75.31688875289633)).title("सुयश क्लिनिक").icon(setIcon(MapsActivity.this, R.drawable.hospitalsmall)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.73870130199375,75.31503908310297)).title("विठ्ठल हॉस्पिटल").icon(setIcon(MapsActivity.this, R.drawable.hospitalsmall)));

                                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(17.68841995148581,75.31585232126403)));
                                    pgd.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }).start();
            }
        });

        binding.imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgd.show();
                Toast.makeText(MapsActivity.this, "redirecting...", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    pgd.dismiss();
                                    mMap.clear();
//                                    LatLng place2 = new LatLng(19.7515, 75.7139);17.676983877989407, 75.35567088197612
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.681526231149405,75.32391181343581)).title("हॉटेल धनश्री").icon(setIcon(MapsActivity.this, R.drawable.housing)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.677723606979217,   75.3285895856961)).title("हॉटेल विठ्ठल इन पंढरपूर").icon(setIcon(MapsActivity.this, R.drawable.housing)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.67240797602611,75.33069243744613)).title("श्री विठ्ठल रुक्मिणी भक्त निवास").icon(setIcon(MapsActivity.this, R.drawable.housing)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.672441362105175, 75.33106120482367)).title("मंडी दूध डेअरी निवास").icon(setIcon(MapsActivity.this, R.drawable.housing)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.682267076542875,75.3369743769129)).title("श्री राधा गोविंद भक्त निवास").icon(setIcon(MapsActivity.this, R.drawable.housing)));
                                    //wakhri
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.692528439499608,75.33397855277492)).title("श्री संत नारायणदेवबाबा भक्त निवास").icon(setIcon(MapsActivity.this, R.drawable.housing)));
                                    mMap.addMarker(new MarkerOptions().position(new LatLng(17.676983877989407,75.35567088197612)).title("श्री विठ्ठल भक्त निवास").icon(setIcon(MapsActivity.this, R.drawable.housing)));

                                    //gursale


                                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(17.681526231149405,75.32391181343581)));
                                    pgd.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }).start();
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
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

        LatLng sydney = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        mMap.addMarker(new MarkerOptions().position(sydney).title("You are here!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 9.0f ) );
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    private BitmapDescriptor setIcon(Activity context,int Drawableid) {
        android.graphics.drawable.Drawable drawable=ActivityCompat.getDrawable(context,Drawableid);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        Bitmap bitmap=Bitmap.createBitmap(drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    public void fetchLastLocation(){
        Toast.makeText(this, "Fetching your location.....", Toast.LENGTH_SHORT).show();
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            return;
        }
        Task<Location> fetch=fusedLocationProviderClient.getLastLocation();
        fetch.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                Toast.makeText(MapsActivity.this, "Success....", Toast.LENGTH_SHORT).show();

    currentLocation=location;
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
            .findFragmentById(R.id.map);
    mapFragment.getMapAsync(MapsActivity.this);
    Toast.makeText(MapsActivity.this, "Map loaded....", Toast.LENGTH_SHORT).show();
         Toast.makeText(MapsActivity.this,"Activity executed ",Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1) {
            if (grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                fetchLastLocation();
            }
            else {
                Toast.makeText(this, "Location permission is denied!,please allow it", Toast.LENGTH_SHORT).show();
            }
        }
    }



}