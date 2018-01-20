package kr.pe.dreamer.startalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import kr.pe.dreamer.startalk.chatting.ChattingFragment;
import kr.pe.dreamer.startalk.friend.FriendFragment;
import kr.pe.dreamer.startalk.util.GlobalConfig;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (GlobalConfig.getInstance().isLogin(this)) {
            setContentView(R.layout.activity_main);
            initLayout();
        } else {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void initLayout() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        setSupportActionBar(toolbar);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_friend_icon_n));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_chatting_icon_n));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private class TabPagerAdapter extends FragmentPagerAdapter {
        private int count;

        public TabPagerAdapter(FragmentManager fm, int count) {
            super(fm);
            this.count = count;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    FriendFragment friendFragment = FriendFragment.newInstance();
                    return friendFragment;
                case 1:
                    ChattingFragment chattingFragment = ChattingFragment.newInstance();
                    return chattingFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return count;
        }
    }
}
