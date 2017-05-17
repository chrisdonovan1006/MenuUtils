package com.dvn.calfmanagerprototype.utils;

/**
 * Created by Christopher on 16/05/2017.
 * <p>
 * (Class Info: )
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dvn.calfmanagerprototype.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
	private final Context mContext;
	
	public RecyclerViewAdapter(Context context) {
		mContext = context;
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lst_item, parent, false);
		return new ViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		String[] animals = mContext.getResources().getStringArray(R.array.animals)[position].split(",");
		String animal = animals[0];
		String image = animals[1];
		int animalsResId = mContext.getResources().getIdentifier(image, "drawable", mContext.getPackageName());
		
		Log.d("ANIMALS", "onBindViewHolder: "+animals[0]+", "+animals[1]+", "+animalsResId);
		
		viewHolder.mTextView.setText(animal);
		viewHolder.mImageView.setImageDrawable(Utility.getRoundedBitmap(mContext, animalsResId));
	}
	
	@Override
	public int getItemCount() {
		return mContext.getResources().getStringArray(R.array.animals).length;
	}
	
	public static class ViewHolder extends RecyclerView.ViewHolder {
		public TextView mTextView;
		public ImageView mImageView;
		
		public ViewHolder(View v) {
			super(v);
			mTextView = (TextView) v.findViewById(R.id.title);
			mImageView = (ImageView) v.findViewById(R.id.imgLst);
		}
	}
}
