package com.example.johnb.cookbookapp.Util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johnb.cookbookapp.R;

import java.util.List;

/**
 * Created by johnb on 22/02/2017.
 */

public class CheckBoxListAdapter extends ArrayAdapter<String>{

    private final Activity context;
    private final List<String> ingredientNames;


    public CheckBoxListAdapter(Activity context, List<String> ingredientNames) {
        super(context, R.layout.img_cat_list, ingredientNames);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.ingredientNames = ingredientNames;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.ingredients_list, null,true);

        TextView txtViewIngredient = (TextView) rowView.findViewById(R.id.ingredient_name);
        //CheckBox cbIngredient = (CheckBox) rowView.findViewById(R.id.cb_ingredient);

        txtViewIngredient.setText(ingredientNames.get(position));

        return rowView;
    };

}
