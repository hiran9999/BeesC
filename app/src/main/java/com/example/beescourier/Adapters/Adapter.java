package com.example.beescourier.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Update;

import com.example.beescourier.Helper.DatabaseHelper;
import com.example.beescourier.R;
import com.example.beescourier.Table.Tables;
import com.example.beescourier.UpdateDataActivity;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<Tables> tablesList;
    View view;

    DatabaseHelper helper;

    public Adapter(Context context) {
        this.context = context;
    }

    public Adapter(Context context, List<Tables> tablesList) {
        this.context = context;
        this.tablesList = tablesList;

        helper = DatabaseHelper.getInstance(context);
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       view = LayoutInflater.from(context).inflate(R.layout.rv_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(tablesList != null && tablesList.size() > 0)  {
            Tables tables = tablesList.get(position);
            holder.editTextDate.setText(tables.getPick_date());
            holder.order_no.setText(String.valueOf(tables.getId()));
            holder.editTextAddress.setText(tables.getPick_address());

            holder.more_iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(context,holder.more_iv);
                    popupMenu.getMenuInflater().inflate(R.menu.items,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.update_id:
                                    context.startActivities(new Intent[]{new Intent(context, UpdateDataActivity.class)
                                            .putExtra("pick_table", tables)});
                                    break;
                                case R.id.delete_id:
                                    helper.deleteData(tables);
                                    tablesList.remove(position);
                                    notifyDataSetChanged();
                                    notifyItemRangeChanged(position,tablesList.size());
                                    break;

                            }
                            return false;
                        }

                    });
                    popupMenu.show();

                }
            });


        }

    }

    @Override
    public int getItemCount() {
        return tablesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView editTextDate,order_no,editTextAddress;
        ImageView more_iv;
        public ViewHolder(@NonNull  View itemView) {

            super(itemView);

            editTextDate = itemView.findViewById(R.id.editTextDate);
            order_no = itemView.findViewById(R.id.order_no);
            editTextAddress = itemView.findViewById(R.id.editTextAddress);

        }
    }
}
