package jp.co.koba.sample_material_design_support_library.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.co.koba.sample_material_design_support_library.R;

import static butterknife.ButterKnife.findById;

public class BaseActivity extends AppCompatActivity {
    private BaseActivity activity;

    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @InjectView(R.id.toolbar_menu)
    Toolbar toolbar;

    @InjectView(R.id.navigation_view)
    NavigationView navigationView;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_item_1:
                    case R.id.navigation_item_2:
                    case R.id.navigation_item_3:
                        menuItem.setChecked(true);
                        Snackbar.make(findById(BaseActivity.this, R.id.coordinator_layout),
                                menuItem.getTitle(), Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.move_tab_layout:
                        startActivity(new Intent(getApplicationContext(), TabLayoutActivity.class));
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    /**
     * toolbarの初期化。
     */
    protected void initToolbar(int titleResId) {
        toolbar.setTitle(titleResId);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void finish() {
        drawerLayout.closeDrawers();
        super.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (activity instanceof MainActivity) {
                    break;
                }
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
