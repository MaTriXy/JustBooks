package com.namclu.android.justbooks.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.namclu.android.justbooks.R;

public class BookActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String EXTRA_SEARCH_TEXT = "EXTRA_SEARCH_TEXT";

    private SearchView searchField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        searchField = (SearchView) findViewById(R.id.search_main_search_field);
        Button searchButton = (Button) findViewById(R.id.button_main_search);

        // Set views
        searchField.setQueryHint(getResources().getString(R.string.hint_search_books));

        // Set onClickListener
        searchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String searchString = searchField.getQuery().toString().trim();

        if (searchString.isEmpty()) {
            Toast.makeText(this, "Please enter a book search..." + searchField.getQuery(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Searching for " + searchString, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, BookResultsActivity.class);
            intent.putExtra(EXTRA_SEARCH_TEXT, searchString);
            startActivity(intent);
        }
    }
}
