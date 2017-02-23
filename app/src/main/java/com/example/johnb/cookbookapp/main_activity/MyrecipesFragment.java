package com.example.johnb.cookbookapp.main_activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.johnb.cookbookapp.R;
import com.example.johnb.cookbookapp.add_recipes_activity.AddRecipesActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyrecipesFragment extends ListFragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String TAG = "Myrecipes Fragment";




    public MyrecipesFragment() {
        // Required empty public constructor
    }

    public static MyrecipesFragment newInstance(int sectionNumber) {
        MyrecipesFragment fragment = new MyrecipesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View view = inflater.inflate(R.layout.fragment_myrecipes, container, false);// dont need this if extending ListFragment

        //display the activities list from declared in xml file
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.activities)
        );
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /*Set onclick listener on  activities list*/
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        String[] activities = new String[1];//will hold add recipe for now
        activities = v.getResources().getStringArray(R.array.activities);

        String selectedItem = activities[position];
        Log.w(TAG, "Selected option: " + activities[position]);

        //start Add Recipes Activity
        //no intents passed by defualt
        Intent intent = new Intent(this.getContext(), AddRecipesActivity.class);
        startActivity(intent);
    }

}
