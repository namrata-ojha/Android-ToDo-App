package com.example.namrataojha.todo_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static android.R.id.message;
import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.example.namrataojha.todo_app.EditItemActivity.REQUEST_CODE;

public class
MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;
    String EditedItemReceived;
    int postionEdited;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView)findViewById(R.id.lvItems);
        items= new ArrayList<>();
        readItems();
        itemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        lvItems.setAdapter(itemsAdapter);
//        items.add("First Item");
//        items.add("Second Item");
        setupListViewListner();

    }

    // ActivityOne.java, time to handle the result of the sub-activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // REQUEST_CODE is defined above
        try {
            if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
                // Extract name value from result extras
                EditedItemReceived = data.getExtras().getString("ITEM_EDITED_NAME");
                postionEdited = data.getExtras().getInt("ITEM_POS", 0);
                // Toast the name to display temporarily on screen
                Toast.makeText(this, "Item edited", Toast.LENGTH_SHORT).show();
                updateItem();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setupListViewListner() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener(){

                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View item, int pos, long id) {
                        items.remove(pos);
                        itemsAdapter.notifyDataSetChanged();
                        writeItems();
                        return true;
                    }
    });
        lvItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String itemName = parent.getItemAtPosition(position).toString();
                        int post = position;
                        Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
                        intent.putExtra("ITEM_NAME", itemName);
                        intent.putExtra("ITEM_POS", post);
                        startActivityForResult(intent , REQUEST_CODE);

                    }
                }
        );

    }

    private void readItems(){
        File fileDir = getFilesDir();
        File todoFile = new File(fileDir, "todo.txt");
        try{
            items= new ArrayList<String>(FileUtils.readLines(todoFile));

        } catch (IOException e){
            items = new ArrayList<String>();
        }
    }

    private void writeItems(){
        File filesDir = getFilesDir();
        File todoFile= new File(filesDir, "todo.txt");
        try{
            FileUtils.writeLines(todoFile,items);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
        public void updateItem(){
            items.set(postionEdited,EditedItemReceived);
           // itemsAdapter.insert(EditedItemReceived, postionEdited);
            itemsAdapter.notifyDataSetChanged();
            writeItems();
        }

    public void onAddItem(View v){
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText= etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems();
    }



}
