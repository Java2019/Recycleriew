package com.nemo.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/*Наш адаптер, мост между фабрикой клонов и выводом их на экран.
Его методы будет дёргать LinearLayoutManager, назныченный вьюшке
RecyclerView в методе onCreate нашей активити*/

public class PersonAdapter extends RecyclerView.Adapter<PersonHolder> {

    private List<CloneFactory.Person> mPersons;
    public PersonAdapter(List<CloneFactory.Person> persons) {
        mPersons = persons;
    }

    //Создаёт пустую вьюшку,оборачивает её в PersonHolder.
    //Дальше забота по наполнению этой вьюшки ложиться именно на объект PersonHolder'а
    @Override
    public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ///
        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.list_item_person, parent, false);
        return new PersonHolder(view);

    }

    //Дёргает метод холдера при выводе нового элемента списка на экран,
    //передавая ему актуальный объект модели для разбора и представления
    @Override
    public void onBindViewHolder(PersonHolder holder, int position) {
        CloneFactory.Person person = mPersons.get(position);
        holder.bindCrime(person);

    }

    //Возвращает размер хранилища моделей
    @Override
    public int getItemCount() {
        return mPersons.size();
    }
}