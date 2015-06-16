package jp.co.koba.sample_material_design_support_library.activities;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;

import butterknife.InjectView;
import butterknife.OnClick;
import jp.co.koba.sample_material_design_support_library.R;

import static butterknife.ButterKnife.findById;


public class MainActivity extends BaseActivity {
    private ActionBarDrawerToggle drawerToggle;

    @InjectView(R.id.main_layout)
    RelativeLayout mainRelativeLayout;

    @OnClick(R.id.fab)
    void onClickFab() {
        Snackbar.make(findById(this, R.id.coordinator_layout),
                getString(R.string.push_fab_message), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar(R.string.app_name);
        initDrawerToggle();
    }

    /**
     * drawerToggleの初期化
     */
    private void initDrawerToggle() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.app_name, R.string.app_name);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(mainRelativeLayout.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        return drawerToggle.onOptionsItemSelected(item)
                || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (findById(this, R.id.main_fragment) != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(mainRelativeLayout.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            findById(this, R.id.main_fragment).requestFocus();
        }
        return super.onTouchEvent(event);
    }
}
