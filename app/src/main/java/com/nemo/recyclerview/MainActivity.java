package com.nemo.recyclerview;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements View.OnScrollChangeListener {
    //ссылка на адаптер, класс который знает всё о модели и дёргает методы холдера
    private PersonAdapter mAdapter;
    //ссылка на вьюшку из представления
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Находим ссылку на контейнер - виджет
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //LinearLayoutManager занимается размещением объектов на экране и прокруткой
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Подготавливаем армию клонов
        List<CloneFactory.Person> personList = CloneFactory.getCloneList();
        //Создаём экземпляр адаптера и передаём ему под командование наших клонов. Далее руководит ими он
        mAdapter = new PersonAdapter(personList, this);
        //Назначаем вьюхе адаптером наш экземпляр PersonAdapter
        mRecyclerView.setAdapter(mAdapter);
        // Назначаем слушатель нашему списку
        mRecyclerView.setOnScrollChangeListener(this);
    }

    @Override
    public void onScrollChange(View view, int i, int i1, int i2, int i3) {
        Toast.makeText(getApplicationContext(), "This", Toast.LENGTH_LONG).show();
    }
}
