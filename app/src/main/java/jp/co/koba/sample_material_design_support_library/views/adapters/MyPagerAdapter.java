package jp.co.koba.sample_material_design_support_library.views.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import jp.co.koba.sample_material_design_support_library.fragments.ListFragment;
import jp.co.koba.sample_material_design_support_library.fragments.MainFragment;
import jp.co.koba.sample_material_design_support_library.fragments.TabLayoutFragment;

public class MyPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {
    /**
     * 1つ目のタブ番号
     */
    private static final int TAB_1 = 0;

    /**
     * 2つ目のタブ番号
     */
    private static final int TAB_2 = 1;

    /**
     * 3つ目のタブ番号
     */
    private static final int TAB_3 = 2;

    /**
     * タブの総数
     */
    private static final int MAX_NUMBER_OF_TAB = 3;

    private ViewPager mViewPager;

    public MyPagerAdapter(AppCompatActivity activity, ViewPager viewPager) {
        super(activity.getSupportFragmentManager());
        mViewPager = viewPager;
        mViewPager.setAdapter(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {
            case TAB_1:
                return new TabLayoutFragment();
            case TAB_2:
                return new MainFragment();
            case TAB_3:
                return new ListFragment();
            default:
                return new TabLayoutFragment();
        }
    }

    @Override
    public int getCount() {
        return MAX_NUMBER_OF_TAB;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab" + (position + 1);
    }
}