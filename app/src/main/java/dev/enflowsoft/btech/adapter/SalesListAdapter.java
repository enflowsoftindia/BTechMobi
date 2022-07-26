package dev.enflowsoft.btech.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.List;

import dev.enflowsoft.btech.models.Listchildvm;
import dev.enflowsoft.btech.models.SalesListResponse;
import dev.enflowsoft.btech.R;


public class SalesListAdapter extends RecyclerView.Adapter<SalesListAdapter.SalesListViewHolder> {

    private List<SalesListResponse> salesListFilter;
    Callback callback;
    Context ctx;
    String checkedPos = "";
    private int[] colors = new int[]{Color.GRAY, Color.WHITE};
    private int[] forecolors = new int[]{Color.WHITE, Color.BLACK};

    public class SalesListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public LinearLayout layout_root;
        public TextView txt_invoiceno;
        public TextView txt_customername;
        public TextView txt_invoicedate;
        public TextView txt_totalamount;
        public TextView txt_sno;

        public SalesListViewHolder(View view) {
            super(view);

            txt_invoiceno = view.findViewById(R.id.txt_invoiceno);
            txt_customername = view.findViewById(R.id.txt_customername);
            txt_invoicedate = view.findViewById(R.id.txt_invoicedate);
            txt_totalamount = view.findViewById(R.id.txt_totalamount);
            txt_sno = view.findViewById(R.id.txt_sales_sno);
            layout_root = view.findViewById(R.id.list_layout_sales);
            layout_root.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.list_layout_sales:
                    callback.itemClick(getAdapterPosition());
                    break;
            }
        }
    }

    public SalesListAdapter(List<SalesListResponse> _salesList, Context ctx) {
        this.salesListFilter = _salesList;
        this.ctx = ctx;
    }

    @Override
    public SalesListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_sales, parent, false);
        return new SalesListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SalesListViewHolder holder, final int position) {
        try {
            int colorPos = position % colors.length;
            int forecolorPos = position % colors.length;
            // holder.itemView.setBackgroundColor(colors[colorPos]);

            SalesListResponse sales = salesListFilter.get(position);
            String strDt = sales.getTransDate().toString().replace("T00:00:00", "");

            holder.txt_invoiceno.setText(String.valueOf(sales.getTransNo()));
            holder.txt_invoicedate.setText(strDt);
            holder.txt_customername.setText(String.valueOf(sales.getPartyName()));
            holder.txt_sno.setText(String.valueOf(position + 1));

            Listchildvm listchild = sales.getListchildvm().get(0);
            holder.txt_totalamount.setText(String.valueOf(listchild.getAmount()));

            // holder.txt_invoiceno.setTextColor(forecolors[forecolorPos]);
            // holder.txt_invoicedate.setTextColor(forecolors[forecolorPos]);
            // holder.txt_customername.setTextColor(forecolors[forecolorPos]);
            // holder.txt_totalamount.setTextColor(forecolors[forecolorPos]);

        } catch (Exception e) {
            Log.d("Bind Error", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return salesListFilter.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {
        void itemClick(int pos);
    }
}