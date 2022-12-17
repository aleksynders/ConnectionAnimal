package com.example.tinderanimal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinderanimal.adapter.AnimalAdapter;
import com.example.tinderanimal.adapter.CategoryAdapter;
import com.example.tinderanimal.model.Animal;
import com.example.tinderanimal.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {

    ImageButton clsCategory;

    TextView mainPageHeader, help;

    RecyclerView categoryRecycler, animalRecycler;
    CategoryAdapter categoryAdapter;
    static AnimalAdapter animalAdapter;
    static List<Animal> animalList = new ArrayList<>();
    static List<Animal> fullAnimalList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        animalList.clear();
        fullAnimalList.clear();

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Собаки"));
        categoryList.add(new Category(2,"Кошки"));
        categoryList.add(new Category(3,"Лошади"));
        categoryList.add(new Category(4,"Свинки"));
        categoryList.add(new Category(5,"Обезьянки"));

        setCategoryRecycler(categoryList);


        animalList.add(new Animal(1,"cat1", "Пуфик", "Ярый любитель сосисок. Ищет кошечку", "+7 (920) 892-45-23", "pufik_krut@mail.ru", 2));
        animalList.add(new Animal(2,"cat2", "Розочка", "Ищет ласкового котика для создания потомства", "+7 (934) 855-33-22", "rozakoshka@mail.ru", 2));
        animalList.add(new Animal(3,"cat3", "Муся", "Строгая, хорошая, милая, ласковая. Ищет сильного и верного котика", "+7 (440) 845-41-11", "sdvsdvsdfadsf@mail.ru", 2));

        animalList.add(new Animal(4,"pig", "Кукуруза", "Яростный и злой", "+7 (920) 892-45-23", "rvevsvsv@mail.ru", 4));

        fullAnimalList.addAll(animalList);

        setAnimalRecycler(animalList);

        clsCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animalList.clear();
                animalList.addAll(fullAnimalList);

                animalAdapter.notifyDataSetChanged();
            }
        });

        mainPageHeader = findViewById(R.id.mainPageHeader);
        help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, activity_help.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setAnimalRecycler(List<Animal> animalList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        animalRecycler = findViewById((R.id.animalRecycler));
        animalRecycler.setLayoutManager(layoutManager);

        animalAdapter = new AnimalAdapter(this, animalList);
        animalRecycler.setAdapter(animalAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById((R.id.categoryRecycler));
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

        clsCategory = findViewById(R.id.imgFilter);
    }

    public static void showAnimalCategory(int category){
            animalList.clear();
            animalList.addAll(fullAnimalList);

            List<Animal> filterAnimal = new ArrayList<>();

            for(Animal a : animalList){
                if(a.getCategory()==category)
                    filterAnimal.add(a);
            }
            animalList.clear();
            animalList.addAll(filterAnimal);
            animalAdapter.notifyDataSetChanged();
    }

}