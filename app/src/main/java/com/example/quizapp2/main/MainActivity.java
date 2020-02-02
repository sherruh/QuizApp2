package com.example.quizapp2.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.quizapp2.R;
import com.example.quizapp2.history.HistoryFragment;
import com.example.quizapp2.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private BottomNavigationView bottomNavigationView;

    private MainFragment mainFragment;
    private SettingsFragment settingsFragment;
    private HistoryFragment historyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        mainFragment = MainFragment.newInstance();
        settingsFragment = SettingsFragment.newInstance();
        historyFragment = HistoryFragment.newInstance();

        viewPager = findViewById(R.id.main_view_pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),mainFragment,settingsFragment,historyFragment);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.setSelectedItemId(bottomNavigationView.getMenu().getItem(position).getItemId());
            }
        });
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
                        pagerAdapter.getItem(0);
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.item_history:
                        item.setIcon(R.drawable.ic_history);
                        pagerAdapter.getItem(1);
                        viewPager.setCurrentItem(1);
                        break;
                    default:
                        item.setIcon(R.drawable.ic_settings);
                        viewPager.setCurrentItem(2);
                }
                return true;
            }
        });
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        private MainFragment mainFragment;
        private SettingsFragment settingsFragment;
        private HistoryFragment historyFragment;

        public PagerAdapter(@NonNull FragmentManager fm
                ,MainFragment mainFragment
                ,SettingsFragment settingsFragment
                ,HistoryFragment historyFragment) {
            super(fm);

            this.mainFragment = mainFragment;
            this.settingsFragment = settingsFragment;
            this.historyFragment = historyFragment;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            Fragment fragment;
            switch (position){
                case 0:
                    fragment = this.mainFragment;
                    break;
                case 1:
                    fragment = this.settingsFragment;
                    break;
                default:
                    fragment = this.historyFragment;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
