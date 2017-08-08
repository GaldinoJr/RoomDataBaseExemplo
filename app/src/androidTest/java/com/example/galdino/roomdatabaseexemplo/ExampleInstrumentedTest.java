package com.example.galdino.roomdatabaseexemplo;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.galdino.roomdatabaseexemplo.Entity.User;
import com.example.galdino.roomdatabaseexemplo.dataBase.AppDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private AppDatabase mAppDatabase;
    private User mUser;

    @Before
    public void setUp() {
        Context applicationContext = InstrumentationRegistry.getTargetContext();

        mAppDatabase = Room
                // inMemoryDatabaseBuilder = MEMORIA DE EXECUÇÃO
                .inMemoryDatabaseBuilder(applicationContext, AppDatabase.class)
                .allowMainThreadQueries()
                .build();

        mUser = new User();
        mUser.setFirstName("Galdino");
        mUser.setLastName("Rodrigues");
        mUser.setAge(22);
    }

    @Test
    public void insertUser()
    {
        long[] longs = mAppDatabase.userDao().insertAll(mUser);
        Assert.assertTrue(longs[0] > 0);
    }

    @Test
    public void countUsers()
    {
        int countUsers = mAppDatabase.userDao().countUsers();
        Assert.assertEquals(1, countUsers);
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.galdino.roomdatabaseexemplo", appContext.getPackageName());
    }
}
