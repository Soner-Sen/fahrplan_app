package com.example.mentz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentz.model.Location;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final List<Location> localDataSet;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.tvResult);
        }
        public TextView getTextView() {
            return textView;
        }
    }
    public MyAdapter(Context context, List dataSet) {
        this.context = context;
        localDataSet = dataSet;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_fahrplan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.getTextView().setText(localDataSet.get(position).getName());
        viewHolder.itemView.setOnClickListener(view -> {
            context.startActivity(new Intent(context, LocationDetail.class)
                    .putExtra("position", position));

            GlobalVars.locationList = localDataSet;
        });
    }
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
