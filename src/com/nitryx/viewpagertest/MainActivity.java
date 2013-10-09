package com.nitryx.viewpagertest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	// mainLayout is the child of the HorizontalScrollView
	private LinearLayout mainLayout;

	// This is an array that holds the IDs of the drawables
	private int[] images = { R.drawable.image1, R.drawable.image2, R.drawable.image3,
			R.drawable.image4, R.drawable.image5, R.drawable.image6 };

	private View cell;
	private TextView textView;

	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) findViewById(R.id._viewPager);

		mainLayout = (LinearLayout) findViewById(R.id._linearLayout);

		for (int i = 0; i < images.length; i++) {
			cell = getLayoutInflater().inflate(R.layout.cell, null);

			final ImageView imageView = (ImageView) cell.findViewById(R.id._image);
			imageView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					viewPager.setVisibility(View.VISIBLE);
					viewPager.setAdapter(new GalleryPagerAdapter(MainActivity.this, images));
					viewPager.setCurrentItem(v.getId());

				}
			});

			imageView.setTag("Image#" + (i + 1));

			textView = (TextView) cell.findViewById(R.id._imageName);

			imageView.setImageResource(images[i]);
			textView.setText("Image#" + (i + 1));

			mainLayout.addView(cell);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		if (viewPager != null && viewPager.isShown()) {
			viewPager.setVisibility(View.GONE);
		} else {
			super.onBackPressed();
		}
	}
}
