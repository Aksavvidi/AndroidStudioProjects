package gr.aueb.cf.simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ste1
        listView = findViewById(R.id.listView);

        //Ste2
        String[] friends = {
                "Katerina",
                "Panagiotis",
                "Thanassis",

        };
        //Step3 Create adapter
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
               this,  //my context
                android.R.layout.simple_list_item_1, //ready made simple list
                friends
        );
        //link that data with the adapter, and that data to the list
        ListView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Hello " + arrayAdapter.getItem(position) , Toast.LENGTH_SHORT).show();
            }
        });

    }
}