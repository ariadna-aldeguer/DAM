package com.example.tabbed;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabbed.Classes.Dish;
import com.example.tabbed.Recyclers.RecyclerViewAdapterPizzas;



public class FragmentPizzas extends Fragment {

    private static final String KEY_MODEL = "KEY_MODEL";

    private Dish[] dummyModels;
    private OnListFragmentInteractionListener interactionListener;

    public FragmentPizzas() {
    }

    /**
     * Receive the model list
     */
    public static FragmentPizzas newInstance(Dish[] dummyModels) {
        FragmentPizzas fragment = new FragmentPizzas();
        Bundle args = new Bundle();
        args.putParcelableArray(KEY_MODEL, dummyModels);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) {
            throw new RuntimeException("You must to send a dummyModels ");
        }
        Log.i("arguments", ""+ getArguments());
        dummyModels = (Dish[]) getArguments().getParcelableArray(KEY_MODEL);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new RecyclerViewAdapterPizzas(dummyModels, interactionListener));
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // activity must implement OnListFragmentInteractionListener
        if (context instanceof OnListFragmentInteractionListener) {
            interactionListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interactionListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * <p/>
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Dish item);
    }
}