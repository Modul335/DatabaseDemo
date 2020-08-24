package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.databasedemo.model.Book;
import com.orm.SugarContext;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonSave = null;
    private Button buttonReset = null;

    private TextView titelText = null;
    private TextView autorText = null;
    private TextView verlagText = null;
    private TextView isbnText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(this);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("doButtonSaveClick");
                doButtonSaveClick();
            }
        });

        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("doButtonResetClick");
                doButtonResetClick();
            }
        });

        autorText = (EditText) findViewById(R.id.bookTitel);
        titelText = (EditText) findViewById(R.id.bookAutor);
        verlagText = (EditText) findViewById(R.id.bookVerlag);
        isbnText = (EditText) findViewById(R.id.bookIsbn);

    }

    private void doButtonSaveClick() {
        Book book = new Book(titelText.getText().toString(),autorText.getText().toString(),
                verlagText.getText().toString(),isbnText.getText().toString());
        book.save();
        List<Book> books = Book.listAll(Book.class);
        System.out.println("COUNT: " + books.size());

    }

    private void doButtonResetClick() {
        autorText.setText("");
        titelText.setText("");
        verlagText.setText("");
        isbnText.setText("");
     }

    public void onTerminate() {
        SugarContext.terminate();
    }

}