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

import hu.bme.mit.ftsrg.modes3mobilcontroller.MQTTHandler;
import hu.bme.mit.ftsrg.modes3mobilcontroller.R;
import hu.bme.mit.ftsrg.modes3mobilcontroller.listeners.TurnoutStateChangedListener;
import hu.bme.mit.ftsrg.modes3mobilcontroller.network.NetworkUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class TurnoutsFragment extends Fragment {

    ImageButton t01;
    ImageButton t02;
    ImageButton t03;
    ImageButton t04;
    ImageButton t05;
    ImageButton t06;

    public TurnoutsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_turnouts, container, false);
        initButtons(rootView);

        MQTTHandler.setEventListener(new TurnoutStateChangedListener() {
            @Override
            public void turnoutStateChanged(MqttMessage message) {
                setTurnoutState(message);
            }
        });

        initTurnoutState();

        return rootView;
    }

    private void setTurnoutState(MqttMessage message) {

        try {
            JSONObject jsonObj = new JSONObject(message.toString());
            Log.d("mqtt", "turnoutid " + jsonObj.getString("turnoutID"));
            int turnoutID = Integer.parseInt(jsonObj.getString("turnoutID"));
            String state = jsonObj.getString("state");

            switch (turnoutID) {
                case 1:
                    if (state.equals("straight")) {

                        t01.setImageResource(R.drawable.turnout_reg_straight);
                    } else if (state.equals("divergent")) {
                        t01.setImageResource(R.drawable.turnout_reg_divergent);
                    }
                    break;

                case 2:
                    if (state.equals("straight")) {

                        t02.setImageResource(R.drawable.turnout_reg_straight);
                    } else if (state.equals("divergent")) {
                        t02.setImageResource(R.drawable.turnout_reg_divergent);
                    }
                    break;

                case 3:
                    if (state.equals("straight")) {
                        t03.setImageResource(R.drawable.turnout_dual_straight);
                    } else if (state.equals("divergent")) {
                        t03.setImageResource(R.drawable.turnout_dual_divergent);
                    }
                    break;

                default:
                    break;

                case 4:
                    if (state.equals("straight")) {

                        t04.setImageResource(R.drawable.turnout_reg_straight);
                    } else if (state.equals("divergent")) {
                        t04.setImageResource(R.drawable.turnout_reg_divergent);
                    }
                    break;
                case 5:
                    if (state.equals("straight")) {

                        t05.setImageResource(R.drawable.turnout_reg_straight);
                    } else if (state.equals("divergent")) {
                        t05.setImageResource(R.drawable.turnout_reg_divergent);
                    }
                    break;
                case 6:
                    if (state.equals("straight")) {

                        t06.setImageResource(R.drawable.turnout_reg_straight);
                    } else if (state.equals("divergent")) {
                        t06.setImageResource(R.drawable.turnout_reg_divergent);
                    }
                    break;

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    private void initTurnoutState() {
        if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
            MQTTHandler.mypublish("turnout/state", "{\"getstate\":\"every\"}");
        }
    }

    private void initButtons(View rootView) {
        t01 = rootView.findViewById(R.id.t01);
        t01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t01), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/turnout", "t01");
                }
            }
        });

        t02 = rootView.findViewById(R.id.t02);
        t02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t02), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/turnout", "t02");
                }
            }
        });

        t03 = rootView.findViewById(R.id.t03);
        t03.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t03), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/turnout", "t03");
                }
            }
        });
        t04 = rootView.findViewById(R.id.t04);
        t04.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t04), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/turnout", "t04");
                }
            }
        });

        t05 = rootView.findViewById(R.id.t05);
        t05.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t05), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/turnout", "t05");
                }
            }
        });

        t06 = rootView.findViewById(R.id.t06);
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
