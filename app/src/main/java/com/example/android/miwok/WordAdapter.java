package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

	public int mColorResourceId;



	public WordAdapter(Activity context, ArrayList<Word> word, int colorResourceId){
		super(context, 0, word);
		mColorResourceId = colorResourceId;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		View listItemView = convertView;
		if(listItemView == null){
			listItemView = LayoutInflater.from(getContext()).inflate(
					R.layout.list_item, parent, false
			);
		}

		Word currentWord = getItem(position);

		TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_translation);
		defaultTextView.setText(currentWord.getDefaultTranslation());

		TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_translation);
		miwokTextView.setText(currentWord.getMiwokTranslation());

		ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

		if(currentWord.hasImage()){
		imageView.setImageResource(currentWord.getmImageResourceId());
		imageView.setVisibility(View.VISIBLE);
		} else {
			imageView.setVisibility(View.GONE);
		}


		View textContainer = (View) listItemView.findViewById(R.id.text_container);
		int color = ContextCompat.getColor(getContext(), mColorResourceId);

		textContainer.setBackgroundColor(color);
		return listItemView;
	}

}
