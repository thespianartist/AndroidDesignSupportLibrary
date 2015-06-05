package com.androititlan.gdg.android_design_support_library.app.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androititlan.gdg.android_design_support_library.R;
import com.androititlan.gdg.android_design_support_library.app.models.Developer;
import com.androititlan.gdg.android_design_support_library.app.ui.activity.DetailActivity;
import com.androititlan.gdg.android_design_support_library.app.util.Config;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Jhordan on 02/06/15.
 */
public class RecyclerViewAdapterExample
        extends RecyclerView.Adapter<RecyclerViewAdapterExample.ViewHolder> {

    private List<Developer> developerList;
    public static class ViewHolder extends RecyclerView.ViewHolder {


        public final View mView;
        public final ImageView mImageView;
        public final TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.txt_photo);
            mTextView = (TextView) view.findViewById(R.id.txt_title);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextView.getText();
        }
    }


    public RecyclerViewAdapterExample(List<Developer> developerList) {
        this.developerList = developerList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Developer developer = developerList.get(position);
        holder.mTextView.setText(developer.getName());

       holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                 Intent intent = new Intent(context,DetailActivity.class);
                 intent.putExtra(Config.EXTRA_NAME, developer.getName());
                 intent.putExtra(Config.EXTRA_PHOTO, developer.getFoto());
               context.startActivity(intent);
            }
        });

        Glide.with(holder.mImageView.getContext())
                .load(developer.getFoto())
                .fitCenter()
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return developerList.size();
    }
}