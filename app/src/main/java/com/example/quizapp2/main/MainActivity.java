package com.example.quizapp2.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.quizapp2.R;
import com.example.quizapp2.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private BottomNavigationView bottomNavigationView;

    private MainFragment mainFragment;
    private SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        mainFragment = MainFragment.newInstance();
        settingsFragment = SettingsFragment.newInstance();

        viewPager = findViewById(R.id.main_view_pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),mainFragment,settingsFragment);
        viewPager.setAdapter(pagerAdapter);
        bottomNavigationView = findViewById(R.id.bottom_nav_main);
        bottomNavigationView.setItemIconTintList(null);
        setBottomNavListener();
    }

    private void setBottomNavListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                bottomNavigationView.getMenu().getItem(0).setIcon(R.drawable.ic_main_idle);
                bottomNavigationView.getMenu().getItem(1).setIcon(R.drawable.ic_history_idle);
                bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.ic_settings_idle);
                switch (item.getItemId()){
                    case R.id.item_main:
                        item.setIcon(R.drawable.ic_main);
                        break;
                    case R.id.item_history:
                        item.setIcon(R.drawable.ic_history);
                        break;
                    default:
                        item.setIcon(R.drawable.ic_settings);

                }
                return false;
            }
        });
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        private MainFragment mainFragment;
        private SettingsFragment settingsFragment;

        public PagerAdapter(@NonNull FragmentManager fm
                ,MainFragment mainFragment
                ,SettingsFragment settingsFragment) {
            super(fm);

            this.mainFragment = mainFragment;
            this.settingsFragment = settingsFragment;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            Fragment fragment;
            switch (position){
                case 0:
                    fragment = this.mainFragment;
                    break;
                default:
                    fragment = this.settingsFragment;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
