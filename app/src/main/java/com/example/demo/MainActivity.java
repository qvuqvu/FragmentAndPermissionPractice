package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kiểm tra đây có phải lần đầu Activity được khởi tạo?
        //      True: add LoginFragment vào Activity
        //      False: không làm gì vì FragmentManager đã lưu sẵn một instance của LoginFragment
        if (savedInstanceState == null)
        {
            // Mọi thao tác với Fragment cần thông qua instance của FragmentTransaction
            FragmentManager fragManage = getSupportFragmentManager();
            FragmentTransaction fragTrans = fragManage.beginTransaction();

            // Gán một instance của LoginFragment vào MainActivity bằng add()
            fragTrans.add(R.id.contentContainer, new LoginFragment(), null);
            fragTrans.commit();
        }
    }
}