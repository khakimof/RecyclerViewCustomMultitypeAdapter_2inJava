package com.example.recyclerviewcustommultitypeadapter_2injava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import adapter.CustomAdapter;
import model.Member;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void initView() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for (int i = 0 ; i < 30 ; i++ ) {
            if (i==0||i==5||i==16||i==25) {
                members.add(new Member("Ilhombek" + i,"Ubaydullayev" + i , 1));
            }
            else if (i==3 || i==10 || i==20) {
                members.add(new Member("Ilhpmbek" + i,"Ubaydullayev" + i,2));
            }
            else {
                members.add(new Member("Ilhombek" + i,"Ubaydullayev" + i, 0));
            }
        }
        return members;
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
}