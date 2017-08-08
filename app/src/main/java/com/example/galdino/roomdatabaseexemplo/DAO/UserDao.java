package com.example.galdino.roomdatabaseexemplo.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.galdino.roomdatabaseexemplo.Entity.User;

import java.util.List;

/**
 * Created by galdino on 08/08/17.
 */

@Dao
public interface UserDao
{
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE first_name LIKE :firstName AND last_name LIKE :lastName")
    User findByName(String firstName, String lastName);

    @Query("SELECT COUNT(*) FROM user")
    int countUsers();

    @Insert
    long[] insertAll(User... users);

    @Delete
    void delete(User user);
}
