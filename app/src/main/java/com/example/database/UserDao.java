package com.example.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

// declaration of method, used in database.
    @Dao
    public interface UserDao {
        @Query("SELECT * FROM User")
        List<User> getUsers();

        @Insert(onConflict = OnConflictStrategy.REPLACE)  // or OnConflictStrategy.IGNORE
        void insertUser(User user);

        @Update
        void updateUser(User user);

        @Delete
        void deleteUser(User user);
    }

