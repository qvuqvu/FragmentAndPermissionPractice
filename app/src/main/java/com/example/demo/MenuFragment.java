package com.example.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MenuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Khởi tạo layout cho Fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnHome = view.findViewById(R.id.btnHome);
        Button btnMemList = view.findViewById(R.id.btnMemList);
        Button btnAbout = view.findViewById(R.id.btnAbout);

        // Định nghĩa event onClick của button Home
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragManage = getActivity().getSupportFragmentManager();
                FragmentTransaction fragTrans = fragManage.beginTransaction();
                HomeFragment fragHome = (HomeFragment) getActivity().getSupportFragmentManager().findFragmentByTag("frgHome");
                if (fragHome == null) fragHome = new HomeFragment();
                fragTrans.replace(R.id.contentContainer, fragHome , "frgHome");
                fragTrans.addToBackStack(null);
                fragTrans.commit();
                //if (fragManage.getBackStackEntryCount() == 0) return;
            }
        });

        // Định nghĩa event onClick của button MemList
        btnMemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragManage = getActivity().getSupportFragmentManager();
                FragmentTransaction fragTrans2 = fragManage.beginTransaction();
                MemberFragment fragMem = (MemberFragment)  getActivity().getSupportFragmentManager().findFragmentByTag("frgMem");
                if (fragMem == null) fragMem = new MemberFragment();
                fragTrans2.replace(R.id.contentContainer, fragMem ,"frgMem");
                fragTrans2.addToBackStack(null);
                fragTrans2.commit();
                //if (fragManage.getBackStackEntryCount() == 0) return;
            }
        });

        // Định nghĩa event onClick của button About
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragManage = getActivity().getSupportFragmentManager();
                FragmentTransaction fragTrans = fragManage.beginTransaction();
                FragmentManager fragManage1 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragTrans1 = fragManage1.beginTransaction();
                AboutFragment fragbout = (AboutFragment)  getActivity().getSupportFragmentManager().findFragmentByTag("frgAbout");
                if (fragbout == null) fragbout = new AboutFragment();
                fragTrans1.replace(R.id.contentContainer, fragbout ,"frgAbout");
                fragTrans1.addToBackStack(null);
                fragTrans1.commit();
                //if (fragManage.getBackStackEntryCount() == 0) return;
            }
        });
    }
}
