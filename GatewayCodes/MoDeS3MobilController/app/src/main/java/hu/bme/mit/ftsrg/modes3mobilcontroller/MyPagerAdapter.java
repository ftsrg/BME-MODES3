package hu.bme.mit.ftsrg.modes3mobilcontroller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hu.bme.mit.ftsrg.modes3mobilcontroller.fragments.SegmentsFragment;
import hu.bme.mit.ftsrg.modes3mobilcontroller.fragments.SensorsFragment;
import hu.bme.mit.ftsrg.modes3mobilcontroller.fragments.TrainsFragment;
import hu.bme.mit.ftsrg.modes3mobilcontroller.fragments.TurnoutsFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;

    public MyPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SegmentsFragment();
        } else if (position == 1) {
            return new TurnoutsFragment();
        } else if (position == 2) {
            return new TrainsFragment();
        } else {
            return new SensorsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.segments);
            case 1:
                return mContext.getString(R.string.turnouts);
            case 2:
                return mContext.getString(R.string.trains);
            case 3:
                return mContext.getString(R.string.sensor);
            default:
                return null;
        }
    }
}
