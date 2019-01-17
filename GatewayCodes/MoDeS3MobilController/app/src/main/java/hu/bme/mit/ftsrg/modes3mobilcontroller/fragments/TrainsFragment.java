package hu.bme.mit.ftsrg.modes3mobilcontroller.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import hu.bme.mit.ftsrg.modes3mobilcontroller.MQTTHandler;
import hu.bme.mit.ftsrg.modes3mobilcontroller.R;
import hu.bme.mit.ftsrg.modes3mobilcontroller.network.NetworkUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrainsFragment extends Fragment {


    public TrainsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_trains, container, false);

        initPiros(rootView);
        initSNCF(rootView);
        initTaurus(rootView);

        return rootView;
    }

    public String makeMessage(String trainID,int speed, String dir) {
         return "{\"trainID\":" + trainID + ",\"speed\":"+speed +",direction:\"" + dir + "\"}";
    }

    private void initPiros(View rootView) {
        final ToggleButton r = rootView.findViewById(R.id.reverse);

        Button _0 = (Button) rootView.findViewById(R.id._0);
        _0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._0), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/train", makeMessage("piros",0,"forward"));

                }
            }
        });

        Button _25 = (Button) rootView.findViewById(R.id._25);
        _25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._25), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train", makeMessage("piros",32,"backward"));
                    else
                        MQTTHandler.mypublish("command/train",  makeMessage("piros",32,"forward"));
                }
            }
        });
        Button _50 = (Button) rootView.findViewById(R.id._50);
        _50.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._50), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train", makeMessage("piros",64,"backward"));
                    else
                        MQTTHandler.mypublish("command/train", makeMessage("piros",64,"forward"));
                }
            }
        });

        Button _75 = (Button) rootView.findViewById(R.id._75);
        _75.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._75), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train", makeMessage("piros",96,"backward"));
                    else
                        MQTTHandler.mypublish("command/train", makeMessage("piros",96,"forward"));
                }
            }
        });

        Button _100 = (Button) rootView.findViewById(R.id._100);
        _100.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._100), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train", makeMessage("piros",126,"backward"));
                    else
                        MQTTHandler.mypublish("command/train", makeMessage("piros",126,"forward"));
                }
            }
        });
    }

    private void initSNCF(View rootView) {
        final ToggleButton r = rootView.findViewById(R.id.reverse2);

        Button _0 = (Button) rootView.findViewById(R.id.s_0);
        _0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._0), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/train", makeMessage("sncf",0,"forward"));

                }
            }
        });

        Button _25 = (Button) rootView.findViewById(R.id.s_25);
        _25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._25), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train",makeMessage("sncf",32,"backward"));
                    else
                        MQTTHandler.mypublish("command/train", makeMessage("sncf",32,"forward"));
                }
            }
        });
        Button _50 = (Button) rootView.findViewById(R.id.s_50);
        _50.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._50), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train", makeMessage("sncf",64,"backward"));
                    else
                        MQTTHandler.mypublish("command/train", makeMessage("sncf",64,"forward"));
                }
            }
        });

        Button _75 = (Button) rootView.findViewById(R.id.s_75);
        _75.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._75), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train", makeMessage("sncf",64,"backward"));
                    else
                        MQTTHandler.mypublish("command/train", makeMessage("sncf",64,"forward"));
                }
            }
        });

        Button _100 = (Button) rootView.findViewById(R.id.s_100);
        _100.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._100), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train", makeMessage("sncf",126,"backward"));
                    else
                        MQTTHandler.mypublish("command/train", makeMessage("sncf",126,"forward"));
                }
            }
        });
    }

    private void initTaurus(View rootView) {
        final ToggleButton r = rootView.findViewById(R.id.reverse3);

        Button _0 = (Button) rootView.findViewById(R.id.t_0);
        _0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._0), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/train", makeMessage("taurus",0,"forward"));

                }
            }
        });

        Button _25 = (Button) rootView.findViewById(R.id.t_25);
        _25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._25), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train", makeMessage("taurus",32,"backward"));
                    else
                        MQTTHandler.mypublish("command/train", makeMessage("taurus",32,"forward"));
                }
            }
        });
        Button _50 = (Button) rootView.findViewById(R.id.t_50);
        _50.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._50), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train", makeMessage("taurus",64,"backward"));
                    else
                        MQTTHandler.mypublish("command/train", makeMessage("taurus",64,"forward"));
                }
            }
        });

        Button _75 = (Button) rootView.findViewById(R.id.t_75);
        _75.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._75), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train", makeMessage("taurus",96,"backward"));
                    else
                        MQTTHandler.mypublish("command/train", makeMessage("taurus",96,"forward"));
                }
            }
        });

        Button _100 = (Button) rootView.findViewById(R.id.t_100);
        _100.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((NetworkUtil.getConnectivityStatusString(getContext())).equals("Wifi enabled")) {
                    Toast.makeText(getContext(), getString(R.string._100), Toast.LENGTH_SHORT).show();
                    if(r.isChecked())
                        MQTTHandler.mypublish("command/train", makeMessage("taurus",126,"backward"));
                    else
                        MQTTHandler.mypublish("command/train", makeMessage("taurus",126,"forward"));
                }
            }
        });
    }
}

