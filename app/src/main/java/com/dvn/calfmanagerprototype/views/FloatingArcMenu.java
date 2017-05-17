package com.dvn.calfmanagerprototype.views;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bvapp.arcmenulibrary.ArcMenu;
import com.dvn.calfmanagerprototype.R;
import com.dvn.calfmanagerprototype.utils.RecyclerViewAdapter;

public class FloatingArcMenu extends AppCompatActivity {
	
	private static final int[] ITEM_DRAWABLES = { R.drawable.bat,
			R.drawable.bear, R.drawable.bee, R.drawable.cat,
			R.drawable.deer, R.drawable.owl };
	
	private static final String[] STR = {"Bat","Bear","Bee","Cat","Deer","Owl"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_floating_arc_menu);
		
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		recyclerView.setHasFixedSize(true);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
		
		RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
		recyclerView.setAdapter(adapter);
		
		
		ArcMenu menu = (ArcMenu) findViewById(R.id.arcMenu);
		menu.attachToRecyclerView(recyclerView);
		menu.showTooltip(true);
		menu.setToolTipBackColor(Color.WHITE);
		menu.setToolTipCorner(6f);
		menu.setToolTipPadding(2f);
		menu.setToolTipTextColor(R.color.default_bmb_shareLine1Color);
		menu.setAnim(300,300,ArcMenu.ANIM_MIDDLE_TO_RIGHT,ArcMenu.ANIM_MIDDLE_TO_RIGHT, ArcMenu.ANIM_INTERPOLATOR_ACCELERATE_DECLERATE,ArcMenu.ANIM_INTERPOLATOR_ACCELERATE_DECLERATE);
		
		final int itemCount = 6;
		for (int i = 0; i < itemCount; i++) {
			ImageView item = new ImageView(this);
			item.setImageResource(ITEM_DRAWABLES[i]);
			item.setColorFilter(R.color.default_bmb_highlighted_color);
			final int position = i;
			menu.addItem(item, STR[i], new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//You can access child click in here
				}
			});
		}
	}
	
	

//
//
	
	
}
