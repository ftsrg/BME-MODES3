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

import java.util.HashMap;

import hu.bme.mit.ftsrg.modes3mobilcontroller.MQTTHandler;
import hu.bme.mit.ftsrg.modes3mobilcontroller.R;
import hu.bme.mit.ftsrg.modes3mobilcontroller.listeners.TurnoutStateChangedListener;
import hu.bme.mit.ftsrg.modes3mobilcontroller.network.NetworkUtil;

import static hu.bme.mit.ftsrg.modes3mobilcontroller.MainActivity.TOPIC_TURNOUT_COMMAND;

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

    HashMap<Integer, String> states = new HashMap<>(7);
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

        
        for (int i = 1; i <7; i++) {
            states.put(i,"straight");
        }
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
                        states.remove(1);
                        states.put(1,"straight");
                        t01.setImageResource(R.drawable.turnout_reg_straight);

                    } else if (state.equals("divergent")) {
                        states.remove(1);
                        states.put(1,"divergent");
                        t01.setImageResource(R.drawable.turnout_reg_divergent);
                    }
                    break;

                case 2:
                    if (state.equals("straight")) {

                        states.remove(2);
                        states.put(2,"straight");
                        t02.setImageResource(R.drawable.turnout_reg_straight);
                    } else if (state.equals("divergent")) {
                        states.remove(2);
                        states.put(2,"divergent");
                        t02.setImageResource(R.drawable.turnout_reg_divergent);
                    }
                    break;

                case 3:
                    if (state.equals("straight")) {
                        states.remove(3);
                        states.put(3,"straight");
                        t03.setImageResource(R.drawable.turnout_dual_straight);
                    } else if (state.equals("divergent")) {
                        states.remove(3);
                        states.put(3,"divergent");
                        t03.setImageResource(R.drawable.turnout_dual_divergent);
                    }
                    break;

                default:
                    break;

                case 4:
                    if (state.equals("straight")) {

                        states.remove(4);
                        states.put(4,"straight");
                        t04.setImageResource(R.drawable.turnout_reg_straight);
                    } else if (state.equals("divergent")) {
                        states.remove(4);
                        states.put(4,"divergent");
                        t04.setImageResource(R.drawable.turnout_reg_divergent);
                    }
                    break;
                case 5:
                    if (state.equals("straight")) {

                        states.remove(5);
                        states.put(5,"straight");
                        t05.setImageResource(R.drawable.turnout_reg_straight);
                    } else if (state.equals("divergent")) {
                        states.remove(5);
                        states.put(5,"divergent");
                        t05.setImageResource(R.drawable.turnout_reg_divergent);
                    }
                    break;
                case 6:
                    if (state.equals("straight")) {

                        states.remove(6);
                        states.put(6,"straight");
                        t06.setImageResource(R.drawable.turnout_reg_straight);
                    } else if (state.equals("divergent")) {
                        states.remove(6);
                        states.put(6,"divergent");
                        t06.setImageResource(R.drawable.turnout_reg_divergent);
                    }
                    break;

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private String makeMessage(int turnoutID) {
        if(states.get(turnoutID).equals("straight"))
            return "{\"turnoutID\":" + turnoutID + ",\"state\":\"divergent\"}";
        else
            return "{\"turnoutID\":" + turnoutID + ",\"state\":\"straight\"}";
    }
   
    private void initButtons(View rootView) {
        t01 = rootView.findViewById(R.id.t01);
        t01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t01), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish(TOPIC_TURNOUT_COMMAND, makeMessage(1));
                }
            }
        });

        t02 = rootView.findViewById(R.id.t02);
        t02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t02), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish(TOPIC_TURNOUT_COMMAND, makeMessage(2));
                }
            }
        });

        t03 = rootView.findViewById(R.id.t03);
        t03.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t03), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish(TOPIC_TURNOUT_COMMAND, makeMessage(3));
                }
            }
        });
        t04 = rootView.findViewById(R.id.t04);
        t04.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t04), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish(TOPIC_TURNOUT_COMMAND, makeMessage(4));
                }
            }
        });

        t05 = rootView.findViewById(R.id.t05);
        t05.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t05), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish(TOPIC_TURNOUT_COMMAND, makeMessage(5));
                }
            }
        });

        t06 = rootView.findViewById(R.id.t06);
        t06.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.t06), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish(TOPIC_TURNOUT_COMMAND, makeMessage(6));
                }
            }
        });

    }

}
