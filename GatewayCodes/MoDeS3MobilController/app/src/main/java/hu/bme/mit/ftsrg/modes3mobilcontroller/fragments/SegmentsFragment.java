package hu.bme.mit.ftsrg.modes3mobilcontroller.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import hu.bme.mit.ftsrg.modes3mobilcontroller.MQTTHandler;
import hu.bme.mit.ftsrg.modes3mobilcontroller.R;
import hu.bme.mit.ftsrg.modes3mobilcontroller.listeners.SegmentOccChangedListener;
import hu.bme.mit.ftsrg.modes3mobilcontroller.listeners.SegmentStateChangedListener;
import hu.bme.mit.ftsrg.modes3mobilcontroller.network.NetworkUtil;

import static hu.bme.mit.ftsrg.modes3mobilcontroller.MainActivity.TOPIC_SEGMENT_COMMAND;

public class SegmentsFragment extends Fragment {

    View rootView;

    HashMap<Integer, Boolean> states = new HashMap<>();
    HashMap<Integer, String> stateOcc = new HashMap<>();

    ArrayList<MySegment> segments = new ArrayList();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_segments, container, false);

        initMySegment();


        initOnOffButtons(rootView);

        initSegments();

        MQTTHandler.setEventListener(new SegmentStateChangedListener() {
            @Override
            public void segmentStateChanged(MqttMessage message) {

                setBackground(message);
            }
        });

        MQTTHandler.setEventListener(new SegmentOccChangedListener() {
            @Override
            public void segmentOccChanged(MqttMessage message) {

                setImageRes(message);
            }
        });


        return rootView;
    }

    private void setImageRes(MqttMessage message) {
        try {
            JSONObject jsonObj = new JSONObject(message.toString());
            Log.d("mqtt", "segmentOcc " + jsonObj.getString("segmentID"));
            int segmentID = Integer.parseInt(jsonObj.getString("segmentID"));
            String state = jsonObj.getString("occupancy");


            for (MySegment segment : segments) {
                if (segment.segmentID == segmentID)
                    if (state.equals(MySegment.FREE)) {
                        segment.occupancy = MySegment.FREE;
                        segment.imageButton.setImageResource(R.drawable.train_grey);
                    } else if (state.equals(MySegment.OCCUPIED)) {
                        segment.occupancy = MySegment.OCCUPIED;
                        segment.imageButton.setImageResource(R.drawable.train);
                    }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void setBackground(MqttMessage message) {
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(message.toString());
            Log.d("mqtt", "segmentid " + jsonObj.getString("segmentID"));
            int segmentID = Integer.parseInt(jsonObj.getString("segmentID"));
            String state = jsonObj.getString("state");


            for (MySegment segment : segments) {
                if (segment.segmentID == segmentID) {
                    if (state.equals("0")) {
                        segment.imageButton.setBackgroundColor(Color.RED);
                        segment.stateOn = false;
                    } else {
                        segment.imageButton.setBackgroundColor(Color.GREEN);
                        segment.stateOn = true;
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initSegments() {
        for (final MySegment segment : segments) {
            segment.imageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                        MQTTHandler.mypublish(TOPIC_SEGMENT_COMMAND, makeMessage(segment));
                    }
                }
            });
        }
    }

    private void initMySegment() {
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s01), 1));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s02), 2));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s04), 4));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s05), 5));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s06), 6));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s07), 7));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s08), 8));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s10), 10));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s11), 11));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s12), 12));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s13), 13));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s15), 15));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s17), 17));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s18), 18));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s19), 19));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s20), 20));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s22), 22));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s23), 23));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s24), 24));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s26), 26));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s27), 27));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s29), 29));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s30), 30));
        segments.add(new MySegment((ImageButton) rootView.findViewById(R.id.s31), 31));
    }


    private String makeMessage(MySegment segment) {

        if (segment.stateOn)
            return "{\"segmentID\":" + segment.segmentID + ",\"state\":0}";
        else
            return "{\"segmentID\":" + segment.segmentID + ",\"state\":1}";
    }


    private void initOnOffButtons(View rootView) {
        Button buttonOFF = (Button) rootView.findViewById(R.id.btnOff);
        buttonOFF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.offMessage), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/segment", "{\"stateAll\":0}");
                }
            }
        });

        Button buttonON = (Button) rootView.findViewById(R.id.btnOn);
        buttonON.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.onMessage), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/segment", "{\"stateAll\":1}");
                }
            }
        });
    }

    private class MySegment {
        ImageButton imageButton;
        boolean stateOn;
        String occupancy;
        int segmentID;

        final static String OCCUPIED = "occupied";
        final static String FREE = "free";

        public MySegment(ImageButton imageButton, int segmentID) {
            this.imageButton = imageButton;
            stateOn = false;
            occupancy = FREE;
            this.segmentID = segmentID;
        }


    }
}
