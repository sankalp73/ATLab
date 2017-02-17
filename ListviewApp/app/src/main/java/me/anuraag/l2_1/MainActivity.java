package me.anuraag.l2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    private String[] groceryItems;
    // Create and populate a List of items.


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.mainListView );

        groceryItems = getResources().getStringArray(R.array.groceryitems);

        // Create ArrayAdapter using the items list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, groceryItems);



        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );
        mainListView.setOnItemClickListener(this);
    }



    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {

        Bundle bundle = new Bundle();
        bundle.putString("item", groceryItems[position]);
        ItemFragment itemFragment = new ItemFragment();
        itemFragment.setArguments(bundle);
        itemFragment.show(getSupportFragmentManager(), "item fragment");
    }
}
