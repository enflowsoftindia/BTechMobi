package dev.enflowsoft.btech.ui.sales;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import dev.enflowsoft.btech.MainActivity;
import dev.enflowsoft.btech.R;
import dev.enflowsoft.btech.adapter.SalesListAdapter;
import dev.enflowsoft.btech.interfaces.ISalesService;
import dev.enflowsoft.btech.models.SalesListRequest;
import dev.enflowsoft.btech.models.SalesListResponse;
import dev.enflowsoft.btech.remote.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalesListFragment extends Fragment {

    private SalesListViewModel mViewModel;
    private FloatingActionButton fab_addsales;
    private SwipeRefreshLayout swipe_refreshlist;
    ISalesService salesService;

    SharedPreferences usersession;
    Integer companyId, finyearId, userId, pageno;
    List<SalesListResponse> resultList = new ArrayList<SalesListResponse>();
    RecyclerView listView;
    SalesListAdapter salesListAdapter;

    public static SalesListFragment newInstance() {
        return new SalesListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentview = inflater.inflate(R.layout.sales_list_fragment, container, false);

        salesService = APIUtils.postSales();

        fab_addsales = (FloatingActionButton) fragmentview.findViewById(R.id.fab_addsales);
        swipe_refreshlist = (SwipeRefreshLayout) fragmentview.findViewById(R.id.swipe_refreshsaleslist);
        usersession = this.getActivity().getSharedPreferences(MainActivity.UserSession, Context.MODE_PRIVATE);

        companyId = usersession.getInt("companyid",0);
        finyearId = usersession.getInt("finyearid",0);
        userId = usersession.getInt("userid",0);
        pageno = 1; // usersession.getInt("companyid",0);

       fab_addsales.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showDialog(fragmentview);
           }
       });

        swipe_refreshlist.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadSales(fragmentview);
                // Toast.makeText(getActivity(), "Sales refreshed", Toast.LENGTH_SHORT).show();
                swipe_refreshlist.setRefreshing(false);
            }
        });

        loadSales(fragmentview);

        return fragmentview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SalesListViewModel.class);
        // TODO: Use the ViewModel
    }

    private void showDialog(View fragmentvew) {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getActivity());
        // View mView = layoutInflaterAndroid.inflate(R.layout.dialog_manageproduct, null);
        // loadCategorySpinner(mView);
        // EditText txtProdName = (EditText) mView.findViewById(R.id.txt_ProductName);
        // Spinner spnProdCategory = (Spinner) mView.findViewById(R.id.spn_newCategory);
        // EditText txtProdStock = (EditText) mView.findViewById(R.id.txt_ProductStock);
        // CheckBox chkOffer25 = (CheckBox) mView.findViewById(R.id.chk_offer25);
        // CheckBox chkOffer50 = (CheckBox) mView.findViewById(R.id.chk_offer50);
        // CheckBox chkProdVisible = (CheckBox) mView.findViewById(R.id.chk_productvisible);


        AlertDialog.Builder dialogProduct = new AlertDialog.Builder(getActivity());
        dialogProduct.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // MyProducts product = new MyProducts();
                // product.setProductName(txtProdName.getText().toString());
                // product.setCategoryName(spnProdCategory.getSelectedItem().toString());
                // product.setProductStock(txtProdStock.getText().toString());
                // product.setOffer25(chkOffer25.isChecked());
                // product.setOffer50(chkOffer50.isChecked());
                // product.setIsVisible(chkProdVisible.isChecked());
                // product.setPartnerId(partnerId);

                // Call<List<MyProducts>> productsCall = productService.savenewpartnerproduct(product);
                // productsCall.enqueue(new Callback<List<MyProducts>>() {
                //     @Override
                //     public void onResponse(Call<List<MyProducts>> call, Response<List<MyProducts>> response) {
                //         List<MyProducts> products = response.body();
                //         if (response.isSuccessful()) {
                //             Toast.makeText(getActivity(), "Product Saved Successfully", Toast.LENGTH_SHORT).show();
                //         }
                //     }
//
                //     @Override
                //     public void onFailure(Call<List<MyProducts>> call, Throwable t) {
//
                //     }
                // });
                // loadNurseryproducts(fragmentvew);
                dialog.dismiss();
            }
        });

        dialogProduct.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        // dialogProduct.setView(mView);
        dialogProduct.show();
    }

    private void loadSales(View fragmentview) {
        SalesListRequest req = new SalesListRequest();
        req.setCompanyId(companyId);
        req.setFinyearId(finyearId);
        req.setUserId(userId);
        req.setPageno(pageno);
        Call<List<SalesListResponse>> productsCall = salesService.salesinvoicelist(req);
        productsCall.enqueue(new Callback<List<SalesListResponse>>() {
            @Override
            public void onResponse(Call<List<SalesListResponse>> call, Response<List<SalesListResponse>> response) {
                if (response.isSuccessful()) {
                    resultList.clear();
                    resultList = response.body();
                    listView = (RecyclerView) fragmentview.findViewById(R.id.listview_saleslist);

                    salesListAdapter = new SalesListAdapter(resultList, getActivity());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
                    listView.setLayoutManager(linearLayoutManager);
                    listView.setItemAnimator(new DefaultItemAnimator());

                    listView.setAdapter(salesListAdapter);
                    salesListAdapter.setCallback(new SalesListAdapter.Callback() {
                        @Override
                        public void itemClick(int pos) {
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<SalesListResponse>> call, Throwable t) {

            }
        });
    }
}