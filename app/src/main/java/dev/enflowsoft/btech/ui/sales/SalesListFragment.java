package dev.enflowsoft.btech.ui.sales;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import dev.enflowsoft.btech.MainActivity;
import dev.enflowsoft.btech.R;
import dev.enflowsoft.btech.adapter.SalesListAdapter;
import dev.enflowsoft.btech.interfaces.IMasterService;
import dev.enflowsoft.btech.interfaces.ISalesService;
import dev.enflowsoft.btech.models.Customer;
import dev.enflowsoft.btech.models.ListRequest;
import dev.enflowsoft.btech.models.SalesListRequest;
import dev.enflowsoft.btech.models.SalesListResponse;
import dev.enflowsoft.btech.remote.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalesListFragment extends Fragment {

    private SalesListViewModel mViewModel;
    private FloatingActionButton fab_addsales, fab_filtersales;
    private SwipeRefreshLayout swipe_refreshlist;
    private Spinner spnSalesPageSize, spnItemCode;
    private AutoCompleteTextView actv;

    ISalesService salesService;
    IMasterService masterService;

    SharedPreferences usersession;
    Integer companyId, finyearId, userId, pageno;
    List<SalesListResponse> resultList = new ArrayList<SalesListResponse>();
    List<String> list_customers = new ArrayList<String>();
    List<Integer> list_customerIds = new ArrayList<Integer>();
    RecyclerView listView;
    SalesListAdapter salesListAdapter;
    String selectedPageSize, selectedCustomer, selectedItemCode;
    Integer selectedCustomerId;
    String defaultDateFormat = "dd-MM-yyyy";
    String apiDateFormat = "yyyy-MM-dd";
    String searchFromDate, searchToDate;
    final Calendar myCalendar = Calendar.getInstance();
    int fromday, frommonth, fromyear, today, tomonth, toyear;

    public static SalesListFragment newInstance() {
        return new SalesListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentview = inflater.inflate(R.layout.sales_list_fragment, container, false);

        MainActivity mainActivity = (MainActivity) getActivity();
        SalesDataFragment salesDataFragment = new SalesDataFragment();

        salesService = APIUtils.postSales();
        masterService = APIUtils.postMasters();

        ResetFilters();

        spnSalesPageSize = (Spinner) fragmentview.findViewById(R.id.spnSalesPageSize);
        spnItemCode = (Spinner) fragmentview.findViewById(R.id.spn_ItemCode);
        fab_addsales = (FloatingActionButton) fragmentview.findViewById(R.id.fab_addsales);
        fab_filtersales = (FloatingActionButton) fragmentview.findViewById(R.id.fab_filtersales);

        swipe_refreshlist = (SwipeRefreshLayout) fragmentview.findViewById(R.id.swipe_refreshsaleslist);
        usersession = this.getActivity().getSharedPreferences(MainActivity.UserSession, Context.MODE_PRIVATE);

        companyId = usersession.getInt("companyid", 0);
        finyearId = usersession.getInt("finyearid", 0);
        userId = usersession.getInt("userid", 0);
        pageno = 1; // usersession.getInt("companyid",0);

        fab_filtersales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(fragmentview);
            }
        });

        fab_addsales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.isHome = false;
                mainActivity.setMyFragment(salesDataFragment);
                mainActivity.currentFragment = salesDataFragment;
            }
        });

        loadSales(fragmentview);

        swipe_refreshlist.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadSales(fragmentview);
                // Toast.makeText(getActivity(), "Sales refreshed", Toast.LENGTH_SHORT).show();
                swipe_refreshlist.setRefreshing(false);
            }
        });

        loadFilterSpinner(fragmentview);

        spnSalesPageSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPageSize = parent.getItemAtPosition(position).toString();
                loadSales(fragmentview);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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
        View mView = layoutInflaterAndroid.inflate(R.layout.dialog_salesfilter, null);
        spnItemCode = (Spinner) mView.findViewById(R.id.spn_ItemCode);
        actv = (AutoCompleteTextView) mView.findViewById(R.id.autotxt_searchcustomer);
        loadAutoCompleteCustomerSearch(mView);
        loadItemCodeSpinner(mView);
        TextView txtFromDt = (TextView) mView.findViewById(R.id.sales_fromDate);
        TextView txtToDt = (TextView) mView.findViewById(R.id.sales_toDate);

        DatePickerDialog.OnDateSetListener fromdate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                SimpleDateFormat dateFormat = new SimpleDateFormat(defaultDateFormat, Locale.getDefault());
                txtFromDt.setText(dateFormat.format(myCalendar.getTime()));
                SimpleDateFormat dateFormatApi = new SimpleDateFormat(apiDateFormat, Locale.getDefault());
                searchFromDate = dateFormatApi.format(myCalendar.getTime());
            }
        };
        DatePickerDialog.OnDateSetListener todate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                SimpleDateFormat dateFormat = new SimpleDateFormat(defaultDateFormat, Locale.getDefault());
                txtToDt.setText(dateFormat.format(myCalendar.getTime()));
                SimpleDateFormat dateFormatApi = new SimpleDateFormat(apiDateFormat, Locale.getDefault());
                searchToDate = dateFormatApi.format(myCalendar.getTime());
            }
        };

        txtFromDt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                fromyear = calendar.get(Calendar.YEAR);
                frommonth = calendar.get(Calendar.MONTH);
                fromday = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(mView.getContext(), fromdate, fromyear, frommonth, fromday);
                datePickerDialog.show();
            }
        });

        txtToDt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                toyear = calendar.get(Calendar.YEAR);
                tomonth = calendar.get(Calendar.MONTH);
                today = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(mView.getContext(), todate, toyear, tomonth, today);
                datePickerDialog.show();
            }
        });

        AlertDialog.Builder dialogProduct = new AlertDialog.Builder(getActivity());
        dialogProduct.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                loadSales(fragmentvew);
                dialog.dismiss();
            }
        });

        dialogProduct.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialogProduct.setNeutralButton("CLEAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ResetFilters();
                loadSales(fragmentvew);
            }
        });

        dialogProduct.setView(mView);
        dialogProduct.show();
    }

    private void loadSales(View fragmentview) {
        SalesListRequest req = new SalesListRequest();
        req.setCompanyId(companyId);
        req.setFinyearId(finyearId);
        req.setUserId(userId);
        req.setPageno(pageno);
        req.setPagesize(selectedPageSize);
        if (selectedCustomerId > 0)
            req.setCustomerId(selectedCustomerId);
        if (selectedItemCode != "") {
            req.setItemCode(selectedItemCode);
        } else {
            req.setItemCode(" ");
        }
        if(searchFromDate != "" && searchToDate != ""){
            req.setFromDate(searchFromDate);
            req.setToDate(searchToDate);
        }

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

    private void loadAutoCompleteCustomerSearch(View view) {

        list_customers = new ArrayList<>();
        list_customerIds = new ArrayList<>();
        ListRequest req = new ListRequest();
        req.setCompanyId(companyId);
        req.setFinyearId(finyearId);
        req.setUserId(userId);
        req.setPageno(pageno);
        req.setPagesize(selectedPageSize);

        Call<List<Customer>> customers = masterService.getallcustomers(req);
        customers.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                List<Customer> masters = response.body();
                if (masters != null) {
                    for (int i = 0; i < masters.size(); i++) {
                        list_customers.add(masters.get(i).getCustomerName());
                        list_customerIds.add(masters.get(i).getCustomerId());
                    }
                    // selectedCustomer = masters.get(0).getCustomerName();
                } else {
                    Toast.makeText(getActivity(), "Server not ready", Toast.LENGTH_SHORT).show();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (view.getContext(), android.R.layout.simple_list_item_1, list_customers);
                actv.setAdapter(adapter);

                int selectedposition = adapter.getPosition(selectedCustomer);
                //if (selectedposition > 0)
                //    actv.setSelection(selectedposition);

                actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        selectedCustomer = parent.getItemAtPosition(position).toString();
                        Integer cPosition = list_customers.indexOf(selectedCustomer);
                        selectedCustomerId = list_customerIds.get(cPosition);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                Log.e("Sales Filter", t.getMessage());
            }
        });
    }

    private void loadItemCodeSpinner(View view) {

        List<String> list_itemcodes = new ArrayList<String>();
        spnItemCode.setVisibility(View.VISIBLE);
        list_itemcodes = new ArrayList<>();

        list_itemcodes.add(" ");
        list_itemcodes.add("C");
        list_itemcodes.add("S");
        list_itemcodes.add("W");

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getContext(), R.layout.list_pagesize, list_itemcodes);
        adapter.setDropDownViewResource(R.layout.list_pagesize);

        spnItemCode.setAdapter(adapter);
        spnItemCode.setVisibility(View.VISIBLE);
        int selectedposition = adapter.getPosition(selectedItemCode);
        spnItemCode.setSelection(selectedposition);

        spnItemCode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItemCode = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // spnItemCode.setBackgroundColor(getResources().getColor(R.color.design_default_color_secondary_variant));
    }

    private void loadFilterSpinner(View view) {

        List<String> list_pageSize = new ArrayList<String>();
        spnSalesPageSize.setVisibility(View.VISIBLE);
        list_pageSize = new ArrayList<>();

        list_pageSize.add("20");
        list_pageSize.add("50");
        list_pageSize.add("100");
        list_pageSize.add("200");

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getContext(), R.layout.list_pagesize, list_pageSize);
        adapter.setDropDownViewResource(R.layout.list_pagesize);

        spnSalesPageSize.setAdapter(adapter);
        spnSalesPageSize.setVisibility(View.VISIBLE);
        // spnSalesPageSize.setBackgroundColor(getResources().getColor(R.color.design_default_color_secondary_variant));
    }

    private void ResetFilters(){
        selectedCustomerId = 0;
        selectedPageSize = "";
        selectedCustomer = "";
        selectedItemCode = " ";
        searchFromDate = "";
        searchToDate = "";
    }

}