package com.dvn.calfmanagerprototype.views.rotatemenu;


import android.app.Activity;
import android.os.Bundle;

import com.dvn.calfmanagerprototype.R;
import com.dvn.calfmanagerprototype.views.rotatemenu.view.RingOperationLayout;

public class CircleRunActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_circle_run_activity);
		RingOperationLayout ring = (RingOperationLayout)findViewById(R.id.rotate_view);
		ring.animate();
	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
