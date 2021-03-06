package com.example.johnb.cookbookapp.add_recipes_activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.johnb.cookbookapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherDetailsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public OtherDetailsFragment() {
        // Required empty public constructor
    }
    public static OtherDetailsFragment newInstance(int sectionNumber) {
        OtherDetailsFragment fragment = new OtherDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other_details, container, false);
    }

}
