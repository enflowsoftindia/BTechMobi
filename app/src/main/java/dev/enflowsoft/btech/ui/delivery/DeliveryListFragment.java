package dev.enflowsoft.btech.ui.delivery;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.enflowsoft.btech.R;

public class DeliveryListFragment extends Fragment {

    private DeliveryListViewModel mViewModel;

    public static DeliveryListFragment newInstance() {
        return new DeliveryListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentview = inflater.inflate(R.layout.delivery_list_fragment, container, false);

        return fragmentview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DeliveryListViewModel.class);
        // TODO: Use the ViewModel
    }

}