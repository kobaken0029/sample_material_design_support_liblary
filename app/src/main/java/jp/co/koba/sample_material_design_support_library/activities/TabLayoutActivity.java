package jp.co.koba.sample_material_design_support_library.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.InjectView;
import jp.co.koba.sample_material_design_support_library.R;
import jp.co.koba.sample_material_design_support_library.views.adapters.MyPagerAdapter;

public class TabLayoutActivity extends BaseActivity {
    @InjectView(R.id.tab_layout)
    TabLayout tabLayout;

    @InjectView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        initToolbar(R.string.title_activity_tab_layout);
        initTabLayout();
    }

    /**
     * tabの初期化。
     */
    private void initTabLayout() {
        tabLayout.setTabsFromPagerAdapter(new MyPagerAdapter(this, viewPager));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
}
