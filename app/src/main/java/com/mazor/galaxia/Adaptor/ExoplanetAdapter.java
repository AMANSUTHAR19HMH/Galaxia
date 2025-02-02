package com.mazor.galaxia.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mazor.galaxia.ModelClass.Exoplanet;
import com.mazor.galaxia.R;

import java.util.List;

public class ExoplanetAdapter extends RecyclerView.Adapter<ExoplanetAdapter.ViewHolder> {
    private List<Exoplanet> exoplanetList;

    public ExoplanetAdapter(List<Exoplanet> exoplanetList) {
        this.exoplanetList = exoplanetList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exoplanet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Exoplanet exoplanet = exoplanetList.get(position);
        holder.name.setText(exoplanet.getName());
        holder.mass.setText("Mass: " + exoplanet.getMass());
        holder.radius.setText("Radius: " + exoplanet.getRadius());
        holder.year.setText("Discovered: " + exoplanet.getDiscoveryYear());
        holder.hostStar.setText("Host Star: " + exoplanet.getHostStar());
    }

    @Override
    public int getItemCount() {
        return exoplanetList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, mass, radius, year, hostStar;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            mass = itemView.findViewById(R.id.mass);
            radius = itemView.findViewById(R.id.radius);
            year = itemView.findViewById(R.id.year);
            hostStar = itemView.findViewById(R.id.hostStar);
        }
    }
}
