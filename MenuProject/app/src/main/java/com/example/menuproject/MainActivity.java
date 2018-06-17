package com.example.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button smsAction = (Button) findViewById(R.id.buttonSMS);
        Button phoneAction = (Button) findViewById(R.id.buttonPHONE);
        Button webAction = (Button) findViewById(R.id.buttonWEB);
        Button mapAction = (Button) findViewById(R.id.buttonMAP);
        Button shareAction = (Button) findViewById(R.id.buttonSHARE);
        Button newActAction = (Button) findViewById(R.id.buttonNEWACT);

        smsAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent smsInt = new Intent(Intent.ACTION_SENDTO);
                smsInt.setData(Uri.parse("smsto:"+ Uri.encode("+1 5555551212")));
                smsInt.putExtra("sms_body","Dalem's Sample Message");
                startActivity(smsInt);
            }
        });
        phoneAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent dialInt = new Intent(Intent.ACTION_DIAL);
                dialInt.setData(Uri.parse("tel:9993842823"));
                startActivity(dialInt);
            }
        });
        webAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent webInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.blog.google"));
                startActivity(webInt);
            }
        });
        mapAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent mapInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Englewood+Hospital+and+Medical+Center/@40.903997,-73.970663,17z/data=!3m1!4b1!4m5!3m4!1s0x89c2f10f1cf367f3:0x124a853c770183ff!8m2!3d40.903997!4d-73.968469"));
                startActivity(mapInt);
            }
        });
        shareAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent shareInt = new Intent(Intent.ACTION_SEND);
                shareInt.setType("text/plain");
                shareInt.putExtra(Intent.EXTRA_SUBJECT, "CS6392018");
                shareInt.putExtra(Intent.EXTRA_TEXT,"Join CS6392018");
                startActivity(Intent.createChooser(shareInt,"Share the Love"));
            }
        });
        newActAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent newActInt = new Intent(MainActivity.this, NewActivity.class);
                startActivity(newActInt);
            }
        });

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
            Toast t = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
            t.show();
            return true;
        } else if (id == R.id.action_help) {
            Intent help = new Intent(this, HelpActivity.class);
            startActivity(help);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
