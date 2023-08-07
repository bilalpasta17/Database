package com.example.database;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText FirstName, LastName;
    Button btn_1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);
        btn_1 = findViewById(R.id.btn_1);
        //setOnclick listener on button applied

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new bg_thread().start();
            }
        });

    }

    class bg_thread extends Thread {
        public void run() {

            super.run();
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "room_db").build();

            //user created and called using getter and setter
            User a = new User(1, FirstName.getText().toString(), LastName.getText().toString());
            User b = new User(2, FirstName.getText().toString(), LastName.getText().toString());
            UserDao userDao = db.userDao();
            //insertion
            userDao.insertUser(a);
            userDao.insertUser(b);
            userDao.deleteUser(a);
            Log.d(TAG, "database inserted " + userDao.getUsers().get(0).getFirstName());
        };
//        UserDao userDao=new UserDao()

