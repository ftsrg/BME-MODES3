package hu.bme.mit.ftsrg.modes3mobilcontroller.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import hu.bme.mit.ftsrg.modes3mobilcontroller.MQTTHandler;
import hu.bme.mit.ftsrg.modes3mobilcontroller.R;
import hu.bme.mit.ftsrg.modes3mobilcontroller.network.NetworkUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class TurnoutsFragment extends Fragment {


    public TurnoutsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_turnouts, container, false);
        initButtons(rootView);

        return rootView;
    }

    private void initButtons(View rootView) {
        Button t01 = (Button) rootView.findViewById(R.id.t01);
        t01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t01), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/turnout", "t01");
                }
            }
        });

        Button t02 = (Button) rootView.findViewById(R.id.t02);
        t02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t02), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/turnout", "t02");
                }
            }
        });

        Button t03 = (Button) rootView.findViewById(R.id.t03);
        t03.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t03), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/turnout", "t03");
                }
            }
        });
        Button t04 = (Button) rootView.findViewById(R.id.t04);
        t04.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t04), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/turnout", "t04");
                }
            }
        });

        Button t05 = (Button) rootView.findViewById(R.id.t05);
        t05.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t05), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/turnout", "t05");
                }
            }
        });

        Button t06 = (Button) rootView.findViewById(R.id.t06);
        t06.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t06), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/turnout", "t06");
                }
            }
        });

    }


}
