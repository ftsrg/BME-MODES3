package hu.bme.mit.ftsrg.modes3mobilcontroller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import hu.bme.mit.ftsrg.modes3mobilcontroller.fragments.SettingsFragment;

public class SettingsActivity extends AppCompatActivity{
    public static final String serverURL = "serverURL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);

    }
}
