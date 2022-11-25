package com.example.tinderanimal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinderanimal.adapter.CategoryAdapter;
import com.example.tinderanimal.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {

    RecyclerView categoryRecycler;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Собаки"));
        categoryList.add(new Category(2,"Кошки"));
        categoryList.add(new Category(3,"Лошади"));
        categoryList.add(new Category(4,"Свинки"));
        categoryList.add(new Category(5,"Обезьянки"));

        setCategoryRecycler(categoryList);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById((R.id.categoryRecycler));
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
}