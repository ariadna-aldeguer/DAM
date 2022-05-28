package com.example.tabbed.Recyclers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tabbed.Classes.Dish;
import com.example.tabbed.FragmentPizzas;
import com.example.tabbed.FragmentProducts;
import com.example.tabbed.R;

public class RecyclerViewAdapterPizzas extends RecyclerView.Adapter<RecyclerViewAdapterPizzas.ViewHolder> {

    private final Dish[] dishes;
    private final FragmentPizzas.OnListFragmentInteractionListener interactionListener;

    public RecyclerViewAdapterPizzas(Dish[] items, FragmentPizzas.OnListFragmentInteractionListener listener) {
        dishes = items;
        interactionListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_products, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    };

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Dish dm = dishes[position];
        holder.dishItem = dm;
        holder.idView.setText(dm.getId());
        holder.titleView.setText(dm.getCategory());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != interactionListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    interactionListener.onListFragmentInteraction(holder.dishItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dishes.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView idView;
        public final TextView titleView;
        public Dish dishItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            idView = (TextView) view.findViewById(R.id.txtNameProduct);
            titleView = (TextView) view.findViewById(R.id.txtDescriptionProduct);
        }
    }
}
