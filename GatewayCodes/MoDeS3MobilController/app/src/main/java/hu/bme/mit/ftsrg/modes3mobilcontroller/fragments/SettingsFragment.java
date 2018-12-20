package hu.bme.mit.ftsrg.modes3mobilcontroller.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;

import hu.bme.mit.ftsrg.modes3mobilcontroller.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    public SettingsFragment() {
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        setPreferencesFromResource(R.xml.preferences, s);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());

        SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                if (key.equals(getString(R.string.MQTTserverURI))) {
                    EditTextPreference serverURL = (EditTextPreference) findPreference(getString(R.string.MQTTserverURI));
                    serverURL.setSummary(serverURL.getText());
                }
                if (key.equals(getString(R.string.connectionType))) {
                    ListPreference connectionType = (ListPreference) findPreference(getString(R.string.connectionType));
                    connectionType.setSummary(connectionType.getValue());
                }}
        };

        sharedPref.registerOnSharedPreferenceChangeListener(listener);
        EditTextPreference serverURI = (EditTextPreference) findPreference(getString(R.string.MQTTserverURI));
        serverURI.setSummary(serverURI.getText());

        ListPreference connectionType = (ListPreference) findPreference(getString(R.string.connectionType));
        connectionType.setSummary(connectionType.getValue());
    }

}