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

import java.util.List;

import dev.enflowsoft.btech.R;
import dev.enflowsoft.btech.models.DeliveryListResponse;
import dev.enflowsoft.btech.models.Listchildvm;


public class DeliveryListAdapter extends RecyclerView.Adapter<DeliveryListAdapter.DeliveryListViewHolder> {

    private List<DeliveryListResponse> deliveryListFilter;
    Callback callback;
    Context ctx;
    String checkedPos = "";
    private int[] colors = new int[]{Color.GRAY, Color.WHITE};
    private int[] forecolors = new int[]{Color.WHITE, Color.BLACK};

    public class DeliveryListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public LinearLayout layout_root;
        public TextView txt_issueno;
        public TextView txt_issuedate;
        public TextView txt_partyname;
        public TextView txt_sno;

        public DeliveryListViewHolder(View view) {
            super(view);

            txt_issueno = view.findViewById(R.id.txt_issueno);
            txt_issuedate = view.findViewById(R.id.txt_issuedate);
            txt_partyname = view.findViewById(R.id.txt_partyname);
            txt_sno = view.findViewById(R.id.txt_dc_sno);
            layout_root = view.findViewById(R.id.list_layout_delivery);
            layout_root.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.list_layout_delivery:
                    callback.itemClick(getAdapterPosition());
                    break;
            }
        }
    }

    public DeliveryListAdapter(List<DeliveryListResponse> _deliveryList, Context ctx) {
        this.deliveryListFilter = _deliveryList;
        this.ctx = ctx;
    }

    @Override
    public DeliveryListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_delivery, parent, false);
        return new DeliveryListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DeliveryListViewHolder holder, final int position) {
        try {
            DeliveryListResponse delivery = deliveryListFilter.get(position);
            String strDt = delivery.getIssueDate().toString().replace("T00:00:00", "");

                        holder.txt_issueno.setText(String.valueOf(delivery.getIssueNo()));
            holder.txt_issuedate.setText(strDt);
            holder.txt_partyname.setText(String.valueOf(delivery.getPartyName()));
            holder.txt_sno.setText(String.valueOf(position + 1));

            Listchildvm listchild = delivery.getListchildvm().get(0);

        } catch (Exception e) {
            Log.d("Bind Error", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return deliveryListFilter.size();
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