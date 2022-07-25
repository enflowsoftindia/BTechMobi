package dev.enflowsoft.btech.ui.home;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import dev.enflowsoft.btech.MainActivity;
import dev.enflowsoft.btech.R;
import dev.enflowsoft.btech.ui.delivery.DeliveryListFragment;
import dev.enflowsoft.btech.ui.sales.SalesListFragment;
import dev.enflowsoft.btech.ui.statement.OutstandingFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    Button btnSaleslist, btnDelivery, btnOutstandingstatement;
    Fragment currentFragment;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentview = inflater.inflate(R.layout.home_fragment, container, false);

        btnSaleslist = (Button) fragmentview.findViewById(R.id.home_menu_sales);
        btnDelivery = (Button) fragmentview.findViewById(R.id.home_menu_delivery);
        btnOutstandingstatement = (Button) fragmentview.findViewById(R.id.home_menu_salesoutstanding);

        btnSaleslist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(fragmentview, "1-1");
            }
        });
        btnDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(fragmentview, "1-2");
            }
        });
        btnOutstandingstatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(fragmentview, "2-1");
            }
        });

        return fragmentview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

    public void openFragment(View view, String type) {

        HomeFragment homeFragment = new HomeFragment();
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.isHome = false;
        currentFragment = mainActivity.currentFragment;
        if (currentFragment == null) {
            mainActivity.currentFragment = homeFragment;
            mainActivity.isHome = true;
        }

        switch (type) {
            case "1-1":
                SalesListFragment salesListFragment = new SalesListFragment();
                mainActivity.isHome = false;
                mainActivity.setMyFragment(salesListFragment);
                mainActivity.currentFragment = salesListFragment;
                break;
            case "1-2":
                DeliveryListFragment deliveryListFragment = new DeliveryListFragment();
                mainActivity.isHome = false;
                mainActivity.setMyFragment(deliveryListFragment);
                mainActivity.currentFragment = deliveryListFragment;
                break;
            case "2-1":
                OutstandingFragment outstandingFragment = new OutstandingFragment();
                mainActivity.isHome = false;
                mainActivity.setMyFragment(outstandingFragment);
                mainActivity.currentFragment = outstandingFragment;
                break;
        }
    }
}