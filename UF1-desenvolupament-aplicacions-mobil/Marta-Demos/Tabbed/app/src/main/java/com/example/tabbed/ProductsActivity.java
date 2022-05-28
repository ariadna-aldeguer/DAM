package com.example.tabbed;

import android.os.Bundle;

import com.example.tabbed.Classes.Dish;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;

import com.example.tabbed.ui.main.SectionsPagerAdapter;
import com.example.tabbed.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity implements FragmentProducts.OnListFragmentInteractionListener  {

private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // define TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tabPizzas));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tabStarters));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tabDesserts));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // define ViewPager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        // fake list model... for test
        Dish[] pizzas = createDummyListModel("tab 0");
        Dish[] start = createDummyListModel("tab 1");
        Dish[] drinks = createDummyListModel("tab 2");


        //  ViewPager need a PagerAdapter
        final SectionsPagerAdapter adapter = new SectionsPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount(), pizzas, start, drinks );

        viewPager.setAdapter(adapter);

        // Listeners
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(getOnTabSelectedListener(viewPager));

    }

    /**
     * Listener for tab selected
     * @param viewPager
     * @return
     */
    @NonNull
    private TabLayout.OnTabSelectedListener getOnTabSelectedListener(final ViewPager viewPager) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Toast.makeText(ProductsActivity.this, "Tab selected " +  tab.getPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // nothing now
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // nothing now
            }
        };
    }


    /**
     * Listener that comunicate fragment / recycler with this activity
     * @param model
     */

    public void onListFragmentInteraction(Dish model) {
        // the user clicked on this item over the list
        Toast.makeText(ProductsActivity.this, Dish.class.getSimpleName() + ":" + model.getId() + " - "  +model.getName(), Toast.LENGTH_LONG).show();
    }


    // model for test purpose
    private Dish[] createDummyListModel(String msj) {
        List<Dish> l = new ArrayList<>();
        for(int i = 0; i < 10; i++  ) {
            l.add(new Dish(String.valueOf(i), "description " + i , "category " + i + " -" + msj));
        }
        return l.toArray(new Dish[l.size()]);
    }
}