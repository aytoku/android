package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.R;

public class SpinnerFragment extends AppCompatActivity {

    String[] choose = {"Эконом", "Стандарт", "Не эконом"};
    String[] choose_cities = {"Владикавказ", "Ногир", "Беслан"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_partners);

        Spinner spinner = (Spinner) findViewById(R.id.choose);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, choose);
        Spinner spinner1 = (Spinner) findViewById(R.id.choose_cities);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, choose_cities);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);
    }
}