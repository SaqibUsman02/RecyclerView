package com.example.recyclerview_191119;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.recyclerview_191119.Adapter.RecyclerViewAdapter;
import com.example.recyclerview_191119.Model.SubjectData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<SubjectData> SubjectList=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.RV_1);

        SubjectList.add(new SubjectData("DataBase","CS001"));
        SubjectList.add(new SubjectData("Programming C++","CS301"));
        SubjectList.add(new SubjectData("OOP","CS401"));
        SubjectList.add(new SubjectData("English","CS601"));
        SubjectList.add(new SubjectData("Linear Algebra","CS701"));
        SubjectList.add(new SubjectData("Calculus","CS801"));
        SubjectList.add(new SubjectData("Applied Physic","CS901"));
        SubjectList.add(new SubjectData("Assembly","CS6101"));
        SubjectList.add(new SubjectData("Machine Learning","CS631"));
        SubjectList.add(new SubjectData("History","CS621"));
        recyclerViewAdapter=new RecyclerViewAdapter(this,SubjectList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
    recyclerView.setHasFixedSize(true);

    recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {



        @Override
        public void onDeleteClick(int position) {
            removeItem(position);

        }
    });


    }

    public void removeItem(int position)
    {
        SubjectList.remove(position);
        recyclerViewAdapter.notifyItemRemoved(position);

    }
}