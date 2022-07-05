package com.example.android_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewinterface{

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();

    }

    private void initData() {
        userList =new ArrayList<>();
        userList.add(new ModelClass(R.drawable.pic,"irtisam ali","12:49 Am","Comsats","______________________________________"));
        userList.add(new ModelClass(R.drawable.download,"Zain ali","10:40 Am","Comsats","______________________________________"));

        userList.add(new ModelClass(R.drawable.im3,"Shahid ali","12:33 Pm","Comsats","______________________________________"));
        userList.add(new ModelClass(R.drawable.im4,"Umer","08:44 Am","Comsats","______________________________________"));
        userList.add(new ModelClass(R.drawable.images,"Bilal","09:00 Pm","Comsats","______________________________________"));
        userList.add(new ModelClass(R.drawable.img5,"Hassan","07:06 Am","Comsats","______________________________________"));
        userList.add(new ModelClass(R.drawable.im,"Alizy","11:42 Am","Comsats","______________________________________"));
        userList.add(new ModelClass(R.drawable.download,"Abbubakar","03:20 Am","Comsats","______________________________________"));

        userList.add(new ModelClass(R.drawable.im3,"Bahadur ali","12:33 Pm","Comsats","______________________________________"));
        userList.add(new ModelClass(R.drawable.im4,"Shahroz","08:44 Am","Comsats","______________________________________"));
        userList.add(new ModelClass(R.drawable.images,"Syed Hassan","09:00 Pm","Comsats","______________________________________"));
        userList.add(new ModelClass(R.drawable.img5,"Haider","07:06 Am","Comsats","______________________________________"));
        userList.add(new ModelClass(R.drawable.im,"Amna","11:42 Am","Comsats","______________________________________"));
        userList.add(new ModelClass(R.drawable.download,"Hammad","03:20 Am","Comsats","______________________________________"));
    }

    private void initRecyclerView() {
        recyclerView =findViewById(R.id.recyclerView);
        layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userList,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent =new Intent(this,MainActivity2.class);
        intent.putExtra("Name", userList.get(position).getTextview1());
        intent.putExtra("University", userList.get(position).getTextview3());
        intent.putExtra("Image", userList.get(position).getImageview2());
        startActivity(intent);

    }
}