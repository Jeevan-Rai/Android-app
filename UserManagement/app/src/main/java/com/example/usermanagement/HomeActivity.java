package com.example.usermanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.usermanagement.NavFragments.DashboardFragment;
import com.example.usermanagement.NavFragments.ProfileFragment;
import com.example.usermanagement.NavFragments.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.dashboard:
                        fragment = new DashboardFragment();
                        break;

                    case R.id.users:
                        fragment = new UserFragment();
                        break;

                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                }

                if (fragment!=null) {
                    loadFragment(fragment);
                }

                return true;
            }
        });

        loadFragment(new DashboardFragment());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logoutmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void loadFragment(Fragment fragment) {
//        to attach fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout, fragment).commit();
    }


    public void logout(){
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        sharedPrefManager.Logout();
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        Toast.makeText(HomeActivity.this, "Successfully logged out", Toast.LENGTH_SHORT).show();
    }

}