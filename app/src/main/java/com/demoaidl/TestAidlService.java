package com.demoaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.demoaidl.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：lhb on 2018/6/8 15:51
 * Mail：lihaibo@znds.com
 */

public class TestAidlService extends Service {

    private List<Person> personList;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        personList = new ArrayList<>();
        return iBinder;
    }

    private IBinder iBinder = new DemoAidl.Stub() {
        @Override
        public void addPersion(Person person) throws RemoteException {
            personList.add(person);
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return personList;
        }
    };
}
