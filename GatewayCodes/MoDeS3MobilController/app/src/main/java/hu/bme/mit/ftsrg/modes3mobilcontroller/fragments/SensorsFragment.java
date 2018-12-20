package hu.bme.mit.ftsrg.modes3mobilcontroller.fragments;


import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import hu.bme.mit.ftsrg.modes3mobilcontroller.MQTTHandler;
import hu.bme.mit.ftsrg.modes3mobilcontroller.R;
import hu.bme.mit.ftsrg.modes3mobilcontroller.network.NetworkUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class SensorsFragment extends Fragment implements SensorEventListener {

    private static SensorManager mSensorManager;
    private Sensor lightSensor;
    private TextView sensorTextView;
    private ImageView bulb;
    private boolean bulboff = true;
    private boolean init = true;
    private boolean lastBulbStateOff;
    private boolean isVisibleToUsermy;

    public SensorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mv = inflater.inflate(R.layout.fragment_sensors, container, false);
        mSensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        lightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        sensorTextView = (TextView) mv.findViewById(R.id.sensor_list);
        sensorTextView.setText(getResources().getString(R.string.lightSensorInit));
        bulb = (ImageView) mv.findViewById(R.id.bulb);

        if (lightSensor != null) {
            mSensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);

        }
        init = true;
        return mv;

    }



    @Override
    public void onResume() {
        super.onResume();
        init = true;
        Log.d("lifec", "onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("lifec", "onStop");
        mSensorManager.unregisterListener(this);

        if (!bulboff)
            lastBulbStateOff = false;
        else {
            lastBulbStateOff = true;
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("lifec", "onPause");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    isVisibleToUsermy = isVisibleToUser;

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        float currentValue = event.values[0];
        sensorTextView.setText(getResources().getString(R.string.label_light, currentValue));
        if (isVisibleToUsermy) {
            Log.d("lifec", "userVisible" + isVisibleToUsermy);

            Log.d("mqtt2", "init value " + init + currentValue + " bulboff " + bulboff);

            MQTTHandler.mypublish("raw/light", "{\"SensorID\":\"myPhone\",\"Light\":\"" + Math.round(currentValue) + "\",\"MicroTimeStamp\":\"0\",\"Type\":\"light\"}");
            if (init) {

                if (currentValue < 20) {
                    bulb.setImageResource(R.drawable.trans_on);
                    ((TransitionDrawable) bulb.getDrawable()).startTransition(1000);
                    if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                        Toast.makeText(getContext(), getString(R.string.onLight), Toast.LENGTH_SHORT).show();
                        MQTTHandler.mypublish("command/light", "1");
                    }
                    bulboff = false;
                }

                if (currentValue >= 20 && currentValue <= 80 && !lastBulbStateOff) {
                    bulb.setImageResource(R.drawable.trans_on);
                    ((TransitionDrawable) bulb.getDrawable()).startTransition(1000);
                    bulboff = false;
                } else if (currentValue >= 20 && currentValue <= 80) {

                    bulboff = true;
                }
                if (currentValue > 80) {

                    if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                        Toast.makeText(getContext(), getString(R.string.offLight), Toast.LENGTH_SHORT).show();
                        MQTTHandler.mypublish("command/light", "0");
                    }
                    bulboff = true;
                }
                init = false;
            } else {

                if (currentValue < 20 && bulboff) {
                    bulb.setImageResource(R.drawable.trans_on);
                    ((TransitionDrawable) bulb.getDrawable()).startTransition(1000);
                    if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                        Toast.makeText(getContext(), getString(R.string.onLight), Toast.LENGTH_SHORT).show();
                        MQTTHandler.mypublish("command/light", "1");
                    }
                    bulboff = false;
                }

                if (currentValue > 80 && !bulboff) {
                    bulb.setImageResource(R.drawable.trans_off);
                    ((TransitionDrawable) bulb.getDrawable()).startTransition(1000);
                    if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                        Toast.makeText(getContext(), getString(R.string.offLight), Toast.LENGTH_SHORT).show();
                        MQTTHandler.mypublish("command/light", "1");
                    }

                    bulboff = true;
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
