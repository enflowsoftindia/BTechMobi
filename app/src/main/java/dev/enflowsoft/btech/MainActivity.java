package dev.enflowsoft.btech;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import dev.enflowsoft.btech.databinding.ActivityMainBinding;
import dev.enflowsoft.btech.ui.delivery.DeliveryListFragment;
import dev.enflowsoft.btech.ui.home.HomeFragment;
import dev.enflowsoft.btech.ui.sales.SalesListFragment;
import dev.enflowsoft.btech.ui.statement.OutstandingFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    public Fragment currentFragment;
    public boolean isHome;

    /* SESSIONS */
    SharedPreferences usersession;
    public static final String UserSession = "UserSession";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        usersession = this.getSharedPreferences(MainActivity.UserSession, Context.MODE_PRIVATE);
        String navbarFinyear = usersession.getString("username","").toUpperCase() + " - " + usersession.getString("finyearname","").toUpperCase();
        String navbarCompany=usersession.getString("companyunitname","").toUpperCase();

        View headerView = navigationView.getHeaderView(0);
        TextView drawerCompany = (TextView) headerView.findViewById(R.id.txtSubtitleCompany);
        TextView drawerFinyear = (TextView) headerView.findViewById(R.id.txtSubtitleFinyear);
        drawerCompany.setText(navbarCompany);
        drawerFinyear.setText(navbarFinyear);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        isHome = false;
        if (id == R.id.mnuhome) {
            HomeFragment fragment = new HomeFragment();
            isHome = true;
            setMyFragment(fragment);

        } else if (id == R.id.mnudelivery) {
            DeliveryListFragment fragment = new DeliveryListFragment();
            setMyFragment(fragment);

        }
        else if (id == R.id.mnusalesstatement) {
            // SalesListFragment fragment = new SalesListFragment();
            // setMyFragment(fragment);
            return  false;
        }
        else if (id == R.id.mnuoutstandingstatement) {
            OutstandingFragment fragment = new OutstandingFragment();
            setMyFragment(fragment);

        }else if (id == R.id.mnusales) {
            SalesListFragment fragment = new SalesListFragment();
            setMyFragment(fragment);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setMyFragment(Fragment fragment) {

        if (!isHome) {
            clearHomeFragment();
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (currentFragment != null) {
            fragmentTransaction.setReorderingAllowed(false);
            fragmentTransaction.detach(currentFragment);
            fragmentTransaction.hide(currentFragment);
        }

        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
        fragmentTransaction.attach(fragment).commitAllowingStateLoss();
        currentFragment = fragment;
    }

    private void clearHomeFragment() {
        try {

            LinearLayout layoutHome = (LinearLayout) findViewById(R.id.home_fragment_view);
            layoutHome.setVisibility(View.GONE);
            // CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
            // indicator.clearFocus();
        } catch (Exception ex) {
            Log.d("Clear Home Fragment", ex.getMessage());
        }
    }

}