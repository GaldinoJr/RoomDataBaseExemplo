package com.example.galdino.roomdatabaseexemplo.dataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.galdino.roomdatabaseexemplo.DAO.UserDao;
import com.example.galdino.roomdatabaseexemplo.Entity.User;

/**
 * Created by galdino on 08/08/17.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();

    public static AppDatabase getAppDatabase(Context context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,"user-database")
                                        // Permitir queries na thread principal
                                        // FAZER ISSO APENAS PARA TESTE UNITÁRIO
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }
}
