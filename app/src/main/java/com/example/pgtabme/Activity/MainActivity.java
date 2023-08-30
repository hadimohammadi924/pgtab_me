package com.example.pgtabme.Activity;

import android.app.Dialog;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pgtabme.API.APIClient;
import com.example.pgtabme.Adapter.ViewPagerAdapter;
import com.example.pgtabme.Fragment.Fragment_abmivedevist;
import com.example.pgtabme.Fragment.Fragment_abmiveyeklitri;
import com.example.pgtabme.Fragment.Fragment_all;
import com.example.pgtabme.Fragment.Fragment_anvaepanir;
import com.example.pgtabme.Fragment.Fragment_doghnayloni;
import com.example.pgtabme.Fragment.Fragment_doghyekonim;
import com.example.pgtabme.Fragment.Fragment_gheyrelabani;
import com.example.pgtabme.Fragment.Fragment_hamzade;
import com.example.pgtabme.Fragment.Fragment_kareroghan;
import com.example.pgtabme.Fragment.Fragment_kashksayerlabani;
import com.example.pgtabme.Fragment.Fragment_khame;
import com.example.pgtabme.Fragment.Fragment_mastmamoli;
import com.example.pgtabme.Fragment.Fragment_mosir;
import com.example.pgtabme.Fragment.Fragment_paniruf;
import com.example.pgtabme.Fragment.Fragment_poodri;
import com.example.pgtabme.Fragment.Fragment_sayerdogh;
import com.example.pgtabme.Fragment.Fragment_shirestril;
import com.example.pgtabme.Fragment.Fragment_shirpastorize;
import com.example.pgtabme.Fragment.Fragment_shirsade;
import com.example.pgtabme.Fragment.Fragment_shirtamdar;
import com.example.pgtabme.R;

import java.util.ArrayList;
import java.util.List;

//import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    ImageView menu_drawer_right;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;
    List<Fragment> fragments;
    String[] title = new String[]{"همه", "شیر پاستوریزه ساده", "شیر استریل 1/5لیتری", "شیر200ساده", "شیر استریل طعم دار", "انواع خامه", "کره و روغن", "ماست موسیر", "ماست همزده", "ماست معمولی", "پنیر یو اف", "انواع پنیر", "دوغ نایلونی", "دوغ 1/5 لیتری", "سایر انواع دوغ", "ابمیوه200", "آبمیوه 1لیتری", "محصولات پودری", "کشک و سایر محصولات لبنی", "محصولات غیر لبنی"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        if (APIClient.isNetworkAvailable(this)) {
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

         viewPager = findViewById(R.id.viewPager);
         tabLayout = findViewById(R.id.tabLayout);
        initViewPager();
            setupNavMenu();
        } else {
            Toast.makeText(this, "اتصال به اینترنت برقرار نیست", Toast.LENGTH_SHORT).show();
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.connection);
            Button button = (Button) dialog.findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
            });
            dialog.show();
        }
    }
//
//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//    }

   //
    public void setupNavMenu() {
        drawerLayout =  findViewById(R.id.drawer);
        navigationView =  findViewById(R.id.navigationview);
        menu_drawer_right =  findViewById(R.id.menu_drawer_right);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                if (id == R.id.item_home) {
                    Toast.makeText(MainActivity.this, "در ورژن بعدی فعال خواهد شد", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                } else if (id == R.id.item_update) {
                    Toast.makeText(MainActivity.this, "در ورژن بعدی فعال خواهد شد", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.item_update) {
                    Toast.makeText(MainActivity.this, "در ورژن بعدی فعال خواهد شد", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.item_fav) {
                    Toast.makeText(MainActivity.this, "در ورژن بعدی فعال خواهد شد", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.item_setting) {
                    Toast.makeText(MainActivity.this, "در ورژن بعدی فعال خواهد شد", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.item_serach) {
                    Toast.makeText(MainActivity.this, "در ورژن بعدی فعال خواهد شد", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                } else if (id == R.id.item_about) {

                    startActivity(new Intent(MainActivity.this, AboutActivity.class));

                } else if (id == R.id.item_help) {
                    Toast.makeText(MainActivity.this, "" + (Html.fromHtml("" + "" +
                            "" +
                            "" +
                            "<h4><b>راهنمایی</h4></b><br>" +
                            "" +
                            "در ورژن بعدی فعال خواهد شد" +
                            "")), Toast.LENGTH_SHORT).show();

                } else if (id == R.id.item_exit) {
                    if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                        finishAffinity();
                    } else {
                        finish();
                    }

                }
                return true;
            }
        });


        menu_drawer_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

    }

    public void initViewPager() {
        fragments = new ArrayList<>();
        fragments.add(Fragment_all.newInstance());
        fragments.add(Fragment_shirpastorize.newInstance());
        fragments.add(Fragment_shirestril.newInstance());
        fragments.add(Fragment_shirsade.newInstance());
        fragments.add(Fragment_shirtamdar.newInstance());
        fragments.add(Fragment_khame.newInstance());
        fragments.add(Fragment_kareroghan.newInstance());
        fragments.add(Fragment_mosir.newInstance());
        fragments.add(Fragment_hamzade.newInstance());
        fragments.add(Fragment_mastmamoli.newInstance());
        fragments.add(Fragment_paniruf.newInstance());
        fragments.add(Fragment_anvaepanir.newInstance());
        fragments.add(Fragment_doghnayloni.newInstance());
        fragments.add(Fragment_doghyekonim.newInstance());
        fragments.add(Fragment_sayerdogh.newInstance());
        fragments.add(Fragment_abmivedevist.newInstance());
        fragments.add(Fragment_abmiveyeklitri.newInstance());
        fragments.add(Fragment_poodri.newInstance());
        fragments.add(Fragment_kashksayerlabani.newInstance());
        fragments.add(Fragment_gheyrelabani.newInstance());


        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, title);
        viewPager.setAdapter(viewPagerAdapter);


        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(16).select();


    }



    @Override
    public void onBackPressed() {
        finishAffinity();
//        if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
//            drawerLayout.closeDrawers();
//        }



    }
}





