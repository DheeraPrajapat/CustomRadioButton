package com.unknowncoder.customradiobutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.unknowncoder.RadioModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<RadioModel> arrayList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);

        arrayList.add(new RadioModel("#UI"));
        arrayList.add(new RadioModel("#Data Structures"));
        arrayList.add(new RadioModel("#Css"));
        arrayList.add(new RadioModel("#Java"));
        arrayList.add(new RadioModel("#C++"));
        arrayList.add(new RadioModel("#C"));
        arrayList.add(new RadioModel("#Swift"));


        CustomRadioAdapter adapter=new CustomRadioAdapter(arrayList,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);
    }
}