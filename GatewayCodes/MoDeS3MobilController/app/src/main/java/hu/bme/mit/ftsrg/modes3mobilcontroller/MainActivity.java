package hu.bme.mit.ftsrg.modes3mobilcontroller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import hu.bme.mit.ftsrg.modes3mobilcontroller.network.NetworkUtil;


public class MainActivity extends AppCompatActivity {

    static public MQTTHandler mqttHandler;
    static public SharedPreferences mSettings;
    static public NetworkUtil networkUtil;
    static public ConnectivityManager cm;

    static public final String TOPIC_SEGMENT_COMMAND = "command/segment";
    static public final String TOPIC_TURNOUT_COMMAND = "command/turnout";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        networkUtil = new NetworkUtil();
        cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        setContentView(R.layout.activity_main);

        createSettingsToolbar();

        setLayout();
        FloatingActionButtonInit();
        initSettings();

        registerNetworkStateChangedListener();


    }

    private void registerNetworkStateChangedListener() {
        getApplicationContext().registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("mqtt", "changed networkState");
                mqttHandler = new MQTTHandler(getApplication(), mSettings.getString(getString(R.string.MQTTserverURI), getString(R.string.missing)));
            }
        }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private void initSettings() {
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        mSettings = getSharedPreferences(getPackageName() + "_preferences", Context.MODE_PRIVATE);
    }

    private void setLayout() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        MyPagerAdapter adapter = new MyPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void FloatingActionButtonInit() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((NetworkUtil.getConnectivityStatusString(getApplicationContext())).equals("Wifi enabled")) {
                    Toast.makeText(getApplicationContext(), getString(R.string.emergencyStop), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/train", "{\"trainID\":\"taurus\",\"speed\":0,\"direction\":\"forward\"}");
                    MQTTHandler.mypublish("command/train", "{\"trainID\":\"piros\",\"speed\":0,\"direction\":\"forward\"}");
                    MQTTHandler.mypublish("command/train", "{\"trainID\":\"sncf\",\"speed\":0,\"direction\":\"forward\"}");
                }
            }
        });
    }

    private void createSettingsToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
