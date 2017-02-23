package com.example.johnb.cookbookapp.main_activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.johnb.cookbookapp.R;
import com.example.johnb.cookbookapp.Util.ImageListAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    ListView list;
    /*Tests*/
    List<String> itemName = new ArrayList<>();
    List<Integer> imgId = new ArrayList<>();

    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance(int sectionNumber) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catergory, container, false);

        /************************Image Test*********************************/
        itemName.add("Capuccino");
        itemName.add("Latte");
        itemName.add("Filter");

        imgId.add(R.drawable.capuccino);
        imgId.add(R.drawable.latte);
        imgId.add(R.drawable.filter);


        ImageListAdapter adapter = new ImageListAdapter((Activity) view.getContext(), itemName, imgId);
        list=(ListView)view.findViewById(R.id.img_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = itemName.get(position);
                Log.w("TAG", selectedItem);
            }
        });
        /***********************Image Test***************************************/

        return view;
    }

}
