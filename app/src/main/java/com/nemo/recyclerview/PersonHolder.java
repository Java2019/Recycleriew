package com.nemo.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/*Класс PersonHolder занят тем, что держит на готове ссылки на элементы виджетов,
   которые он с радостью наполнит данными из объекта модели в методе bindCrimе.
   Этот класс используется только адаптером в коде ниже, адаптер дёргает его и поручает
   грязную работу по заполнению виджетов*/
public class PersonHolder extends RecyclerView.ViewHolder{

    private TextView mPersonNameTextView;
    private TextView mPersonAdressTextView;
    private TextView mPersonSexTextView;
    private TextView mPersonAgeTextView;
    private CloneFactory.Person mPerson;


    public PersonHolder(View itemView) {
        super(itemView);
        mPersonNameTextView = (TextView) itemView.findViewById(R.id.personNameView);
        mPersonAdressTextView = (TextView) itemView.findViewById(R.id.personAdressView);
        mPersonSexTextView = (TextView) itemView.findViewById(R.id.personSexView);
        mPersonAgeTextView = (TextView) itemView.findViewById(R.id.personAgeView);
    }
    //Метод, связывающий ранее добытые в конструкторе ссылки с данными модели
    public void bindCrime(CloneFactory.Person person) {
        mPerson = person;
        mPersonNameTextView.setText(mPerson.getName());
        mPersonAdressTextView.setText(mPerson.getAdress());
        mPersonAgeTextView.setText(""+mPerson.getAge());
        if(mPerson.isSex()){
            mPersonSexTextView.setText("Мужчина");
        }else {
            mPersonSexTextView.setText("Женщина");
        }

    }

}