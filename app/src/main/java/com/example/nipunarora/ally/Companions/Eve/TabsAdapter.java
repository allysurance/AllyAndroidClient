package com.example.nipunarora.ally.Companions.Eve;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.nipunarora.ally.Companions.Eve.TabFragments.EveFitnessManager;
import com.example.nipunarora.ally.Companions.Eve.TabFragments.EveTimeline;

/**
 * Created by nipunarora on 24/03/18.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f;
        if (position==0)
            f=new EveTimeline();
        else
            f=new EveFitnessManager();
        return f;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       /* switch (position){
            case 0:
                return "Timeline";
            case 1:
                return "Fitness Tracker";
            case 2:
                return "Health Analysis";
            default:
                return "Bas bhai aur nahi";
        }*/
       return null;

    }
}
