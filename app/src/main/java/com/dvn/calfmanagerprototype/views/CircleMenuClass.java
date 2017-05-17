package com.dvn.calfmanagerprototype.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dvn.calfmanagerprototype.R;
import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;

public class CircleMenuClass extends AppCompatActivity {
	
	private CircleMenu circleMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_circle_menu);
		
		circleMenu = (CircleMenu) findViewById(R.id.circleMenu);
		circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
			@Override
			public void onItemClick(CircleMenuButton menuButton) {
				
			}
		});
	}
}
