package com.example.ejercicio2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private Context context;
    private List <Producto> productList;
    public ListAdapter(Context context) {
        this.context = context;
    }

    public void setProductList(List <Producto> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_producto, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.MyViewHolder holder, int position) {
        holder.producto.setText(this.productList.get(position).getNombre());
        holder.precio.setText(this.productList.get(position).getPrecio());
    }

    @NonNull
    @Override
    public int getItemCount() {
        return  this.productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView producto, precio;

        public MyViewHolder(View view) {
            super(view);
            producto = view.findViewById(R.id.productoTv);
            precio = view.findViewById(R.id.precioTv);
        }
    }
}
