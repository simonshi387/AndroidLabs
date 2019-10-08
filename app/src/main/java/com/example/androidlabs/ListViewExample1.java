package com.example.androidlabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;


public class ListViewExample1 extends AppCompatActivity {
    //items to display
    ArrayList<Msg> objects = new ArrayList<>();
    EditText editText=null;
    BaseAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //setContentView(R.layout.table_row_layout);
        initMsgs();
        //You only need 2 lines in onCreate to actually display data:
        ListView theList = findViewById(R.id.theList);
        theList.setAdapter( myAdapter = new MyListAdapter() );
        theList.setOnItemClickListener( ( lv, vw, pos, id) ->{

            Toast.makeText( ListViewExample1.this,
                    "You clicked on:" + pos, Toast.LENGTH_SHORT).show();

        } );

        Button sendButton = findViewById(R.id.p3sendButton);
        editText=findViewById(R.id.p3editText);
        sendButton.setOnClickListener( clik ->
        {
            String content = editText.getText().toString();
            Msg msg = new Msg(content, Msg.TYPE_SEND);
            objects.add( msg );
            editText.setText("");
            myAdapter.notifyDataSetChanged(); //update yourself

        });
        Button receiveButton = findViewById(R.id.p3receiveButton);
       // editText=findViewById(R.id.p3editText);
        receiveButton.setOnClickListener( clik ->
        {
            String content = editText.getText().toString();
            Msg msg = new Msg(content, Msg.TYPE_RECE);
            objects.add( msg );
            editText.setText("");
            myAdapter.notifyDataSetChanged(); //update yourself
        });

       // SwipeRefreshLayout refresher = findViewById(R.id.refresher);
       // refresher.setOnRefreshListener(() -> {

       //     objects.add("Item " + (1+objects.size()) );
         //   myAdapter.notifyDataSetChanged(); //update yourself
          //  refresher.setRefreshing(false);  //get rid of spinning wheel;
       // });
    }
    private void initMsgs() {
        Msg msg1 = new Msg("Hello, I'm Allen.", Msg.TYPE_SEND);
        objects.add(msg1);
        Msg msg2 = new Msg("Hello, I'm Allen.", Msg.TYPE_RECE);
        objects.add(msg2);
        Msg msg3 = new Msg("What can i do for you. ", Msg.TYPE_RECE);
        objects.add(msg3);
    }

    //Need to add 4 functions here:
    private class MyListAdapter extends BaseAdapter {

        public int getCount() {  return objects.size();  } //This function tells how many objects to show

        public Msg getItem(int position) { return objects.get(position);  }  //This returns the string at position p

        public long getItemId(int p) { return p; } //This returns the database id of the item at position p

        public View getView(int p, View recycled, ViewGroup parent)
        {
            LayoutInflater inflater = getLayoutInflater();
            //View thisRow = null;
            View thisRow=recycled;
            if(thisRow == null) {
                if (getItem(p).getType()==1) {
                    thisRow = inflater.inflate(R.layout.receive, null);
                    TextView itemField = thisRow.findViewById(R.id.receiveTextView);
                    itemField.setText(getItem(p).getContent());
                } else {
                    thisRow = inflater.inflate(R.layout.send, null);
                    TextView itemField = thisRow.findViewById(R.id.sendTextView);
                    itemField.setText(getItem(p).getContent());
                }
            }
            return thisRow;
        }
    }

}
