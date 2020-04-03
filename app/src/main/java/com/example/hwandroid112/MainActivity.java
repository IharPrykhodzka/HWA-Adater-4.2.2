package com.example.hwandroid112;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        initList();
    }

    private void initList() {
        final ListView listView = findViewById(R.id.list_view);
        final List<DataItems> dataItemsList = new ArrayList<>();

        dataItemsList.add(new DataItems("Записная книжка", "Из задания № 2.2.1",
                R.drawable.note_background, false));
        dataItemsList.add(new DataItems("Календарь", "Из задания № 2.1.3",
                R.drawable.calendar_background, false));
        dataItemsList.add(new DataItems("Адресс", "Из задания № 2.1.2",
                R.drawable.address_background, false));
        dataItemsList.add(new DataItems("Настройки", "Из задания № 2.2.2",
                R.drawable.settings_background, false));

        final DataItemsAdapter dataItemsAdapter = new DataItemsAdapter(dataItemsList, this);
        listView.setAdapter(dataItemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Object object = dataItemsList.get(position);
                String massage = object.toString();


                switch (massage) {
                    case "Записная книжка":
                        Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
                        startActivity(intentNotes);
                        break;
                    case "Календарь":
                        Intent intentCalendar = new Intent(MainActivity.this, CalendarActivity.class);
                        startActivity(intentCalendar);
                        break;
                    case "Адресс":
                        Intent intentAddress = new Intent(MainActivity.this, AddressActivity.class);
                        startActivity(intentAddress);
                        break;
                    case "Настройки":
                        Toast.makeText(MainActivity.this, R.string.txtOpenSettings, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                Object object = dataItemsList.get(position);
                String massage = object.toString();

                Toast.makeText(MainActivity.this, massage, Toast.LENGTH_LONG).show();

                return false;
            }
        });


    }


}
