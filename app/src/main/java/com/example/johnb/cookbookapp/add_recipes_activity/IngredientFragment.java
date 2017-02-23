package com.example.johnb.cookbookapp.add_recipes_activity;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.johnb.cookbookapp.R;
import com.example.johnb.cookbookapp.Util.CheckBoxListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class IngredientFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String TAG = "Ingredients Fragment";
    private List<String> ingredientsAmount;//to be replaced Recipe list
    private List<String> ingredientsName;//to be replaced Recipe list
    private List<String> concatenatedNameAmmount;
    private Boolean isSelected = false;
    private int index = 0;

    ListView ingredientsList;
    EditText edtIngredientAmount;
    EditText edtIngredientName;
    CheckBoxListAdapter adapter;
    CheckBox cbIngredient;
    Button btnAdd;


    public IngredientFragment() {
        // Required empty public constructor
    }

    public static IngredientFragment newInstance(int sectionNumber) {
        IngredientFragment fragment = new IngredientFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        concatenatedNameAmmount = new ArrayList<String>();
        ingredientsAmount = new ArrayList<String>();
        ingredientsName = new ArrayList<String>();

        //prevent arrays from getting cleared when orientation is changed
        if(savedInstanceState != null){
            ingredientsAmount = savedInstanceState.getStringArrayList("ingredientsAmount");
            ingredientsName = savedInstanceState.getStringArrayList("ingredientsName");
            concatenatedNameAmmount = savedInstanceState.getStringArrayList("concatenatedNameAmmount");
            index = savedInstanceState.getInt("index");
            isSelected = savedInstanceState.getBoolean("isSelected");
        }

        View view = inflater.inflate(R.layout.fragment_add_ingredients, container, false);

        //reference to the views used in the fragment
        btnAdd = (Button) view.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);
        cbIngredient = (CheckBox) view.findViewById(R.id.cb_ingredient);
        edtIngredientAmount = (EditText) view.findViewById(R.id.amount);
        edtIngredientName = (EditText) view.findViewById(R.id.ingredient);
        ingredientsList  =(ListView)view.findViewById(R.id.ingredients_list_holder);

        //update and display ingredients on ListVIew
        adapter = new CheckBoxListAdapter((Activity) view.getContext(), concatenatedNameAmmount);
        ingredientsList.setAdapter(adapter);

        ingredientsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = concatenatedNameAmmount.get(position);

                edtIngredientAmount.setText(ingredientsAmount.get(position));
                edtIngredientName.setText(ingredientsName.get(position));
                isSelected = true;
                index = position;
                btnAdd.setText("Apply");
            }
        });
        return view;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_add: onClickAddIngredient(v);
                break;
//            case R.id.stop_button: onClickStop(v);
//                break;
//            case R.id.reset_button: onClickStart(v);
//                break;
        }
    }
    //

    /*when add button clicked add ingredients to
    * appropriate lists and show on listView*/
    private void onClickAddIngredient(View v) {
       /*ingredients name and amount are separated because the ingredients
        name will need to be indexed*/
        String ingredient = edtIngredientName.getText().toString();
        String ingredientAmount = edtIngredientAmount.getText().toString();
        String fullIngredientDetail = String.format("%s %s", ingredientAmount, ingredient);

        if(btnAdd.getText() == "Apply" && index > -1 && isSelected == true) {
            ingredientsAmount.set(index, ingredientAmount);//data to be added onto the properarray list in Recipe class
            ingredientsName.set(index, ingredient);
            concatenatedNameAmmount.set(index, fullIngredientDetail);
            isSelected = false;
            index = -1;
            btnAdd.setText("Add");
        } else{
            ingredientsAmount.add(ingredientAmount);//data to be added onto the properarray list in Recipe class
            ingredientsName.add(ingredient);
            concatenatedNameAmmount.add(fullIngredientDetail);
        }
        //notify ListVIew that an ingredient has been added
        adapter.notifyDataSetChanged();

        edtIngredientAmount.setText("");
        edtIngredientName.setText("");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putStringArrayList("ingredientsAmount", (ArrayList<String>) ingredientsAmount);
        savedInstanceState.putStringArrayList("ingredientsName", (ArrayList<String>) ingredientsName);
        savedInstanceState.putStringArrayList("concatenatedNameAmmount",(ArrayList<String>) concatenatedNameAmmount);
        savedInstanceState.putInt("index", index);
        savedInstanceState.putBoolean("isSelected", isSelected);
        savedInstanceState.putString("buttonText", btnAdd.getText().toString());
    }

}
