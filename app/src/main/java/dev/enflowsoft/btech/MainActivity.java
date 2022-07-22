package dev.enflowsoft.btech;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import dev.enflowsoft.btech.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        View headerView = navigationView.getHeaderView(0);
        TextView drawerUsername = (TextView) headerView.findViewById(R.id.txtSubtitle);
        drawerUsername.setText("ADMIN - HSN 2122");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //isHome = false;
        //if (id == R.id.mnuhome) {
        //    HomeFragment homeFragment = new HomeFragment();
        //    isHome = true;
        //    setMyFragment(homeFragment);
//
        //} else if (id == R.id.mnujoinpartner) {
        //    JoinPartnerFragment joinPartnerFragment = new JoinPartnerFragment();
        //    setMyFragment(joinPartnerFragment);
        //} else if (id == R.id.mnumyfavourites) {
        //    MyFavouritesFragment myFavouritesFragment = new MyFavouritesFragment();
        //    setMyFragment(myFavouritesFragment);
        //} else if (id == R.id.mnumyproducts) {
        //    MyProductsFragment myProductsFragment = new MyProductsFragment();
        //    setMyFragment(myProductsFragment);
        //} else if (id == R.id.mnuprivacypolicy) {
        //    PrivacyPolicyFragment privacyPolicyFragment = new PrivacyPolicyFragment();
        //    setMyFragment(privacyPolicyFragment);
        //} else if (id == R.id.mnusignin) {
        //    Intent intent = GoogleSignInApi.getSignInIntent(googleApiClient);
        //    startActivityForResult(intent, SIGN_IN);
        //} else if (id == R.id.mnurecentsearch) {
        //    RecentSearchFragment recentSearchFragment = new RecentSearchFragment();
        //    setMyFragment(recentSearchFragment);
        //} else if (id == R.id.mnurateus) {
        //    RateUsFragment rateUsFragment = new RateUsFragment();
        //    setMyFragment(rateUsFragment);
        //} else if (id == R.id.mnureachus) {
        //    ReachusFragment reachUsFragment = new ReachusFragment();
        //    setMyFragment(reachUsFragment);
        //} else if (id == R.id.mnumanageprofile) {
        //    ManageProfileFragment manageProfileFragment = new ManageProfileFragment();
        //    setMyFragment(manageProfileFragment);
        //}else if (id == R.id.mnumanagepartner) {
        //    ManagePartnersFragment managePartnersFragment = new ManagePartnersFragment();
        //    setMyFragment(managePartnersFragment);
        //}else if (id == R.id.mnumanagebanner) {
        //    ManageBannersFragment manageBannerFragment = new ManageBannersFragment();
        //    setMyFragment(manageBannerFragment);
        //} else if (id == R.id.mnusignout) {
        //    // SignOutFragment signOutFragment = new SignOutFragment();
        //    // setMyFragment(signOutFragment);
        //    signOutGmailAccount();
        //}
        //DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}