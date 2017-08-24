package com.example.namrataojha.todo_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.data;
import static com.example.namrataojha.todo_app.R.id.etNewItem;

public class EditItemActivity extends AppCompatActivity {
    EditText editItems;
    Button saveItem;
    int pos;
    static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Intent intent = getIntent();
        String editText = intent.getStringExtra("ITEM_NAME");
        pos = getIntent().getIntExtra("ITEM_POS", 0);

        editItems = (EditText)findViewById(R.id.etEditItems);
        saveItem= (Button)findViewById(R.id.btnSaveItem);
        editItems.setText(editText);
        editItems.setSelection(editItems.getText().length());


    }

    public void onEditItem(View v){

        String itemText= editItems.getText().toString();
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("ITEM_EDITED_NAME", itemText);
        data.putExtra("ITEM_POS", pos); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent

    }
}
