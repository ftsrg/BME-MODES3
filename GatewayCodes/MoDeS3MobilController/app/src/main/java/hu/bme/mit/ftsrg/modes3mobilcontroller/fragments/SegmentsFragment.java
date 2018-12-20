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
import hu.bme.mit.ftsrg.modes3mobilcontroller.SegmentStateChangedListener;
import hu.bme.mit.ftsrg.modes3mobilcontroller.network.NetworkUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class SegmentsFragment extends Fragment {


    View rootView;
    private SegmentStateChangedListener segmentStateChangedListener;

    ImageButton s01;
    ImageButton s02;
    ImageButton s04;
    ImageButton s05;
    ImageButton s06;
    ImageButton s07;
    ImageButton s08;
    ImageButton s10;
    ImageButton s11;
    ImageButton s12;
    ImageButton s13;
    ImageButton s15;
    ImageButton s17;
    ImageButton s18;
    ImageButton s19;
    ImageButton s20;
    ImageButton s22;
    ImageButton s23;
    ImageButton s24;
    ImageButton s26;
    ImageButton s27;
    ImageButton s29;
    ImageButton s30;
    ImageButton s31;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_segments, container, false);

        initOnOffButtons(rootView);

        initSegments(rootView);

        MQTTHandler.setOnEventListener(new SegmentStateChangedListener() {
            @Override
            public void segmentStateChanged(MqttMessage message) {
                setBackground(message);
            }
        });

        initSegmentState();
        return rootView;
    }

    private void initSegmentState() {
        if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                MQTTHandler.mypublish("segment/state", "{\"getstate\":\"every\"}");
        }
    }

    private void setBackground(MqttMessage message) {

        try {
            JSONObject jsonObj = new JSONObject(message.toString());
            Log.d("mqtt", "segmentid " + jsonObj.getString("segmentID"));
            int segmentID = Integer.parseInt(jsonObj.getString("segmentID"));
            String state = jsonObj.getString("state");


            switch (segmentID) {
                case 1:
                    if (state.equals("0")) {
                        s01.setBackgroundColor(Color.RED);
                    } else {
                        s01.setBackgroundColor(Color.GREEN);
                    }
                    break;

                case 2:
                    if (state.equals("0")) {
                        s02.setBackgroundColor(Color.RED);
                    } else {
                        s02.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 4:
                    if (state.equals("0")) {
                        s04.setBackgroundColor(Color.RED);
                    } else {
                        s04.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 5:
                    if (state.equals("0")) {
                        s05.setBackgroundColor(Color.RED);
                    } else {
                        s05.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 6:
                    if (state.equals("0")) {
                        s06.setBackgroundColor(Color.RED);
                    } else {
                        s06.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 7:
                    if (state.equals("0")) {
                        s07.setBackgroundColor(Color.RED);
                    } else {
                        s07.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 8:
                    if (state.equals("0")) {
                        s08.setBackgroundColor(Color.RED);
                    } else {
                        s08.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 10:
                    if (state.equals("0")) {
                        s10.setBackgroundColor(Color.RED);
                    } else {
                        s10.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 11:
                    if (state.equals("0")) {
                        s11.setBackgroundColor(Color.RED);
                    } else {
                        s11.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 12:
                    if (state.equals("0")) {
                        s12.setBackgroundColor(Color.RED);
                    } else {
                        s12.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 13:
                    if (state.equals("0")) {
                        s13.setBackgroundColor(Color.RED);
                    } else {
                        s13.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 15:
                    if (state.equals("0")) {
                        s15.setBackgroundColor(Color.RED);
                    } else {
                        s15.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 17:
                    if (state.equals("0")) {
                        s17.setBackgroundColor(Color.RED);
                    } else {
                        s17.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 18:
                    if (state.equals("0")) {
                        s18.setBackgroundColor(Color.RED);
                    } else {
                        s18.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 19:
                    if (state.equals("0")) {
                        s19.setBackgroundColor(Color.RED);
                    } else {
                        s19.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 20:
                    if (state.equals("0")) {
                        s20.setBackgroundColor(Color.RED);
                    } else {
                        s20.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 22:
                    if (state.equals("0")) {
                        s22.setBackgroundColor(Color.RED);
                    } else {
                        s22.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 23:
                    if (state.equals("0")) {
                        s23.setBackgroundColor(Color.RED);
                    } else {
                        s23.setBackgroundColor(Color.GREEN);
                    }
                    break;
                case 24:
                    if (state.equals("0")) {
                        s24.setBackgroundColor(Color.RED);
                    } else {
                        s24.setBackgroundColor(Color.GREEN);
                    }

                    break;
                case 26:
                    if (state.equals("0")) {
                        s26.setBackgroundColor(Color.RED);
                    } else {
                        s26.setBackgroundColor(Color.GREEN);
                    }

                    break;
                case 27:
                    if (state.equals("0")) {
                        s27.setBackgroundColor(Color.RED);
                    } else {
                        s27.setBackgroundColor(Color.GREEN);
                    }

                    break;
                case 29:
                    if (state.equals("0")) {
                        s29.setBackgroundColor(Color.RED);
                    } else {
                        s29.setBackgroundColor(Color.GREEN);
                    }

                    break;
                case 30:
                    if (state.equals("0")) {
                        s30.setBackgroundColor(Color.RED);
                    } else {
                        s30.setBackgroundColor(Color.GREEN);
                    }

                    break;
                case 31:
                    if (state.equals("0")) {
                        s31.setBackgroundColor(Color.RED);
                    } else {
                        s31.setBackgroundColor(Color.GREEN);
                    }
                    break;
                default:
                    break;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void initSegments(View rootView) {
        s01 = (ImageButton) rootView.findViewById(R.id.s01);
        s01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s01), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "");
                }

            }
        });


        s02 = (ImageButton) rootView.findViewById(R.id.s02);
        s02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s02), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s02");
                }
            }
        });

        s04 = (ImageButton) rootView.findViewById(R.id.s04);
        s04.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s04), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s04");
                }
            }
        });

        s05 = (ImageButton) rootView.findViewById(R.id.s05);
        s05.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s05), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s05");
                }
            }
        });

        s06 = (ImageButton) rootView.findViewById(R.id.s06);
        s06.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s06), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s06");
                }
            }
        });
        s07 = (ImageButton) rootView.findViewById(R.id.s07);
        s07.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s07), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s07");
                }
            }
        });

        s08 = (ImageButton) rootView.findViewById(R.id.s08);
        s08.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s08), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s08");
                }
            }
        });

        s10 = (ImageButton) rootView.findViewById(R.id.s10);
        s10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s10), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s10");
                }
            }
        });

        s11 = (ImageButton) rootView.findViewById(R.id.s11);
        s11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s11), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s11");
                }
            }
        });

        s12 = (ImageButton) rootView.findViewById(R.id.s12);
        s12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s12), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s12");
                }
            }
        });

        s13 = (ImageButton) rootView.findViewById(R.id.s13);
        s13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s13), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s13");
                }
            }
        });

        s15 = (ImageButton) rootView.findViewById(R.id.s15);
        s15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s15), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s15");
                }
            }
        });

        s17 = (ImageButton) rootView.findViewById(R.id.s17);
        s17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s17), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s17");
                }
            }
        });


        s18 = (ImageButton) rootView.findViewById(R.id.s18);
        s18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s18), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s18");
                }
            }
        });
        s19 = (ImageButton) rootView.findViewById(R.id.s19);
        s19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s19), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s19");
                }
            }
        });

        s20 = (ImageButton) rootView.findViewById(R.id.s20);
        s20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s20), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s20");
                }
            }
        });

        s22 = (ImageButton) rootView.findViewById(R.id.s22);
        s22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s22), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s22");
                }
            }
        });

        s23 = (ImageButton) rootView.findViewById(R.id.s23);
        s23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s23), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s23");
                }
            }
        });

        s24 = (ImageButton) rootView.findViewById(R.id.s24);
        s24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s24), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s24");
                }
            }
        });

        s26 = (ImageButton) rootView.findViewById(R.id.s26);
        s26.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s26), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s26");
                }
            }
        });

        s27 = (ImageButton) rootView.findViewById(R.id.s27);
        s27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s27), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s27");
                }
            }
        });


        s29 = (ImageButton) rootView.findViewById(R.id.s29);
        s29.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s29), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s29");
                }
            }
        });

        s30 = (ImageButton) rootView.findViewById(R.id.s30);
        s30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s30), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s30");
                }
            }
        });

        s31 = (ImageButton) rootView.findViewById(R.id.s31);
        s31.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.s31), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegment", "s31");
                }
            }
        });


    }

    private void initOnOffButtons(View rootView) {
        Button buttonOFF = (Button) rootView.findViewById(R.id.btnOff);
        buttonOFF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.offMessage), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegmentAll", "{\"segmentAll\":0}");
                }
            }
        });

        Button buttonON = (Button) rootView.findViewById(R.id.btnOn);
        buttonON.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string.onMessage), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/mysegmentAll", "{\"segmentAll\":1}");
                }
            }
        });
    }

}
