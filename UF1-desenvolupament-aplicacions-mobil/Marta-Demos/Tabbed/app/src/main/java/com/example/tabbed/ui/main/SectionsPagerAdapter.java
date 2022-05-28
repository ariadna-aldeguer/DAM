package com.example.tabbed.ui.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tabbed.Classes.Dish;
import com.example.tabbed.FragmentPizzas;
import com.example.tabbed.FragmentProducts;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private int numTabs;
    private Dish[] all;
    private Dish[] pizzas;
    private Dish[] starters;

    public SectionsPagerAdapter(FragmentManager fm, int numTabs, Dish[] all,
                                Dish[] pizzas, Dish[] starters) {
        super(fm);
        this.numTabs = numTabs;
        this.all = all;
        this.pizzas = pizzas;
        this.starters = starters;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentProducts tab1 = new FragmentProducts();
                return tab1;
            case 1:
                FragmentPizzas tab2 = new FragmentPizzas();
                return tab2;
            case 2:
                FragmentProducts tab3 = FragmentProducts.newInstance(starters);
                return tab3;
            default:
                throw new RuntimeException("Tab position invalid " + position);
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}