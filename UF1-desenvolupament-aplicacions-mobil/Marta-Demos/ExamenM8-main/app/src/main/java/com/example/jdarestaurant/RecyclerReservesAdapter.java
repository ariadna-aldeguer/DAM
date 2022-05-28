package com.example.jdarestaurant;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerReservesAdapter extends RecyclerView.Adapter<RecyclerReservesAdapter.ViewHolder>{

    public Context con;
    public RecyclerReservesAdapter(Context con, ArrayList<Reserves>arrayReserves){
        this.arrayReserves = arrayReserves;
        this.con = con;
    }




}