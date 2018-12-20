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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        networkUtil = new NetworkUtil();
        cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        setContentView(R.layout.activity_main);

        createSettingsToolbar();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        MyPagerAdapter adapter = new MyPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        FloatingActionButtonInit();
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        mSettings = getSharedPreferences(getPackageName() + "_preferences", Context.MODE_PRIVATE);


        Log.d("mqtt", NetworkUtil.getConnectivityStatusString(getApplicationContext()));

        Log.d("mqtt", cm.toString());
        getApplicationContext().registerReceiver(new BroadcastReceiver() { // rekt api 26
            @Override
            public void onReceive(Context context, Intent intent) {


                Log.d("mqtt", "changed networkState");
                mqttHandler = new MQTTHandler(getApplication(), mSettings.getString(getString(R.string.MQTTserverURI), getString(R.string.missing)));
            }
        }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));


    }


    private void FloatingActionButtonInit() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((NetworkUtil.getConnectivityStatusString(getApplicationContext())).equals("Wifi enabled")) {
                    Toast.makeText(getApplicationContext(), getString(R.string.emergencyStop), Toast.LENGTH_SHORT).show();
                    MQTTHandler.mypublish("command/segmentAll", "{\"segmentAll\":0}");
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
