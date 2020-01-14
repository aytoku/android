package com.example.myapplication_1.Adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication_1.Fragments.ChatWithOperator;
import com.example.myapplication_1.Fragments.EmptyChatWithDriverFragment;

public class ChatViewPagerAdapter extends FragmentPagerAdapter {

    public ChatViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new EmptyChatWithDriverFragment();
                break;
            case 1:
                fragment = new ChatWithOperator();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab " + (position + 1);
    }
}