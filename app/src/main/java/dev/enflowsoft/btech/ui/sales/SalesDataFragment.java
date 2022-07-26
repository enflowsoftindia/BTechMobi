package dev.enflowsoft.btech.ui.sales;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.enflowsoft.btech.R;

public class SalesDataFragment extends Fragment {

    private SalesDataViewModel mViewModel;

    public static SalesDataFragment newInstance() {
        return new SalesDataFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentview = inflater.inflate(R.layout.sales_data_fragment, container, false);

        return fragmentview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SalesDataViewModel.class);
        // TODO: Use the ViewModel
    }

}