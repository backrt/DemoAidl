package com.demoaidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.demoaidl.bean.Person;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DemoAidl demoAidl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 绑定服务
        Log.d("test", "bindService");
        Intent intent1 = new Intent(getApplicationContext(), TestAidlService.class);
        bindService(intent1, serviceConnection, BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            demoAidl = DemoAidl.Stub.asInterface(service);
            //test
            addPerson();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            demoAidl = null;

        }
    };

    public void addPerson() {
        Log.d("test", "===========add Person ============");
        Random random = new Random();
        Person person = new Person("shixin" + random.nextInt(10));

        try {
            demoAidl.addPersion(person);
            List<Person> personList = demoAidl.getPersonList();
            Log.e("test", person.toString());
            Log.e("test", "list size = " + personList.size());
        } catch (RemoteException e) {
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test", "unbindService");
        if (null != serviceConnection) {
            unbindService(serviceConnection);
        }
    }
}
