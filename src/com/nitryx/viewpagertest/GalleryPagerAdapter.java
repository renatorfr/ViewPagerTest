package com.nitryx.viewpagertest;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

public class GalleryPagerAdapter extends PagerAdapter {

	private Activity activity;
	private int[] drawableIDs;

	public GalleryPagerAdapter(Activity activity, int[] drawableIDs) {
		this.activity = activity;
		this.drawableIDs = drawableIDs;
	}

	@Override
	public int getCount() {
		return drawableIDs.length;
	}

	/**
	 * Create the page for the given position. THe adapter is responsible for
	 * adding the view to the container given here, although it only must ensure
	 * this is done by the time it returns from {@link #finishUpdate()}.
	 * 
	 * @param container
	 *            The containing View in which the page will be shown.
	 * @param position
	 *            The page position to be instantiated.
	 * @return Returns an Object representing the new page. This does not need
	 *         to be a View, but can be some other container of the page.
	 */
	@Override
	public Object instantiateItem(View container, int position) {
		ImageView imageView = new ImageView(activity);

		imageView.setBackgroundResource(drawableIDs[position]);

		((ViewPager) container).addView(imageView, 0);

		return imageView;
	}

	/**
	 * Remove a page for the given position. The adapter is responsible for
	 * removing the view from it's container, although it only must ensure this
	 * is done by the time it returns from {@link #finishUpdate()}.
	 * 
	 * @param container
	 *            The containing View from which the page will be removed.
	 * @param position
	 *            The page position to be removed.
	 * @param object
	 *            The same object that was returned by
	 *            {@link #instantiateItem(View, int)}.
	 */
	@Override
	public void destroyItem(View container, int position, Object view) {
		((ViewPager) container).removeView((ImageView) view);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((ImageView) object);
	}

	/**
	 * Called when the change in the shown pages has been completed. At this
	 * point you must ensure that all of the pages have actually been added or
	 * removed from the container as appropriate.
	 * 
	 * @param container
	 *            The containing View which is displaying this adapter's page
	 *            views.
	 */
	@Override
	public void finishUpdate(View container) {
	}

	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public void startUpdate(View container) {
	}
}
