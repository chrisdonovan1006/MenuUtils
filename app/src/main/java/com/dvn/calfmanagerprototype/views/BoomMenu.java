package com.dvn.calfmanagerprototype.views;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dvn.calfmanagerprototype.R;
import com.nightonke.boommenu.Animation.OrderEnum;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.ArrayList;
import java.util.List;

public class BoomMenu extends AppCompatActivity {
	
	private BoomMenuButton bmb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_boom_menu);
		
		bmb = (BoomMenuButton) findViewById(R.id.bmb);
		assert bmb != null;
		bmb.setButtonEnum(ButtonEnum.SimpleCircle);
		bmb.setDimColor(Color.TRANSPARENT);
		bmb.setNormalColor(R.color.colorPrimary);
		bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_9_1);
		bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_9_1);
		for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++)
			bmb.addBuilder(BuilderManager.getSimpleCircleButtonBuilder());
		
		ListView listView = (ListView) findViewById(R.id.list_view);
		assert listView != null;
		listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, getData()));
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				bmb.setOrderEnum(OrderEnum.values()[position]);
			}
		});
		
	}
	
	private List<String> getData() {
		List<String> data = new ArrayList<>();
		for (int i = 0; i < getResources().getStringArray(R.array.animalsType).length; i++)
			data.add(getResources().getStringArray(R.array.animalsType)[i]);
		return data;
	}
	
}
