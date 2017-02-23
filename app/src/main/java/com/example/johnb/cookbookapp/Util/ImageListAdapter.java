package com.example.johnb.cookbookapp.Util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johnb.cookbookapp.R;

import java.util.List;

/**
 * Created by johnb on 22/02/2017.
 */

public class ImageListAdapter extends ArrayAdapter<String>{

    private final Activity context;
    private final List<String> itemNames;
    private final List<Integer> imgIds;
    private static final int BITMAP_DIM = 450;


    public ImageListAdapter(Activity context, List<String> itemname, List<Integer> imgid) {
        super(context, R.layout.img_cat_list, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemNames =itemname;
        this.imgIds =imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.img_cat_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.description);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        txtTitle.setText(itemNames.get(position));

        //decode images to reduce file size
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), imgIds.get(position)), BITMAP_DIM,BITMAP_DIM, false);

        imageView.setImageBitmap(scaledBitmap);
        return rowView;
    };

}
