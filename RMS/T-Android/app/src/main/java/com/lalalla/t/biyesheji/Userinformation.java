package com.lalalla.t.biyesheji;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

public class Userinformation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private RelativeLayout container = null;
    private static final String STATES_KEY = "android:states";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocalActivityManager = new LocalActivityManager(this, true);                               //后面继承的
        Bundle states = savedInstanceState != null
                ? (Bundle) savedInstanceState.getBundle(STATES_KEY) : null;
        mLocalActivityManager.dispatchCreate(states);
        setContentView(R.layout.activity_userinformation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        container = (RelativeLayout)findViewById(R.id.containerBody);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        RadioButton btnModule1 = (RadioButton) findViewById(R.id.btnModule1);
        RadioButton btnModule2 = (RadioButton) findViewById(R.id.btnModule2);
        RadioButton btnModule3 = (RadioButton) findViewById(R.id.btnModule3);
        btnModule1.setOnClickListener(this);
        btnModule2.setOnClickListener(this);
        btnModule3.setOnClickListener(this);
        container.addView(
                getLocalActivityManager().startActivity("Module1", new Intent(Userinformation.this, Module1.class)).getDecorView());
//                (v)->{container.removeAllViews();
//        container.addView(getLocalActivityManager().startActivity(
//                "Module1",//加载的activity名
//                new Intent(TestView.this, Module1.class)
//                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//                .getDecorView());});
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLocalActivityManager.dispatchResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle state = mLocalActivityManager.saveInstanceState();
        if (state != null) {
            outState.putBundle(STATES_KEY, state);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLocalActivityManager.dispatchPause(isFinishing());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLocalActivityManager.dispatchStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalActivityManager.dispatchDestroy(isFinishing());
    }

    protected LocalActivityManager mLocalActivityManager;
    public Activity getCurrentActivity() {
        return mLocalActivityManager.getCurrentActivity();
    }

    public final LocalActivityManager getLocalActivityManager() {
        return mLocalActivityManager;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnModule1:
                container.removeAllViews();
                container.addView(
                        getLocalActivityManager().startActivity("Module1",new Intent(Userinformation.this, Module1.class)).getDecorView());
                break;
            case R.id.btnModule2:
                container.removeAllViews();
                container.addView(
                        getLocalActivityManager().startActivity("Module2",new Intent(Userinformation.this, Module2.class)).getDecorView());
                break;
            case R.id.btnModule3:
                container.removeAllViews();
                container.addView(
                        getLocalActivityManager().startActivity("Module3",new Intent(Userinformation.this, Module3.class)).getDecorView());
                break;
        }
    }
}
