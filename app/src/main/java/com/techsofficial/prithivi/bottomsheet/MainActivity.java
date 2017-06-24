package com.techsofficial.prithivi.bottomsheet;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BottomSheetBehavior bottomSheetBehavior,bottomSheetBehaviors,bottomSheetBehaviorss;
    Button btExpand,Accept;
    TextView numbers,setnumbers,total;
    String requestamount;
    EditText amount ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         numbers = (TextView)findViewById(R.id.display);
        setnumbers = (TextView)findViewById(R.id.ContactNumber);
        amount  =(EditText)findViewById(R.id.EditText01);
        total = (TextView)findViewById(R.id. TotalAmount);
      Accept = (Button)findViewById(R.id.Accept);
        Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"Amount Transfer success",Toast.LENGTH_LONG).show();

                if (bottomSheetBehaviorss.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehaviorss.setState(BottomSheetBehavior.STATE_HIDDEN);

                } else {
                    bottomSheetBehaviorss.setState(BottomSheetBehavior.STATE_EXPANDED);

                }



            }
        });
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.floatingActionButton3) ;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplication(),"Touch",Toast.LENGTH_LONG).show();
                requestamount =  amount.getText().toString();
                total.setText(""+requestamount+"RS");


                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                }
                if (bottomSheetBehaviors.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehaviors.setState(BottomSheetBehavior.STATE_HIDDEN);

                } else {
                    bottomSheetBehaviors.setState(BottomSheetBehavior.STATE_EXPANDED);
                    bottomSheetBehaviors.setPeekHeight(900);

                }

                if (bottomSheetBehaviorss.getState() == BottomSheetBehavior.STATE_EXPANDED)
                    bottomSheetBehaviorss.setState(BottomSheetBehavior.STATE_HIDDEN);





            }
        });

        FloatingActionButton fabs = (FloatingActionButton)findViewById(R.id.sendmoney) ;
        fabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Toast.makeText(getApplicationContext(),"Payment successfully",Toast.LENGTH_LONG).show();
                if (bottomSheetBehaviorss.getState() == BottomSheetBehavior.STATE_EXPANDED)
                    bottomSheetBehaviorss.setState(BottomSheetBehavior.STATE_HIDDEN);


            }
        });


        ImageView t = (ImageView) findViewById(R.id.contactss);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent localIntent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(localIntent, 1);*/

                pickContact();
            }
        });







        View bottomSheet = findViewById(R.id.bottom_sheet);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);


        View bottomSheets = findViewById(R.id.bottom_sheets);

        bottomSheetBehaviors = BottomSheetBehavior.from(bottomSheets);
        bottomSheetBehaviors.setHideable(true);
        bottomSheetBehaviors.setState(BottomSheetBehavior.STATE_HIDDEN);



        View bottomSheetss = findViewById(R.id.bottom_sheetss);

        bottomSheetBehaviorss = BottomSheetBehavior.from(bottomSheetss);
        bottomSheetBehaviorss.setHideable(true);
        bottomSheetBehaviorss.setState(BottomSheetBehavior.STATE_HIDDEN);



    }


    private void pickContact() {
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request it is that we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // Get the URI that points to the selected contact
                Uri contactUri = data.getData();
                // We only need the NUMBER column, because there will be only one row in the result
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};

                // Perform the query on the contact to get the NUMBER column
                // We don't need a selection or sort order (there's only one result for the given URI)
                // CAUTION: The query() method should be called from a separate thread to avoid blocking
                // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
                // Consider using CursorLoader to perform the query.
                Cursor cursor = getContentResolver()
                        .query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                // Retrieve the phone number from the NUMBER column
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);
                numbers.setText("Contact Number:"+number);
                setnumbers.setText("Contact Number:"+number);
               // Toast.makeText(getApplicationContext(),""+number,Toast.LENGTH_LONG).show();

                // Do something with the phone number...
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (item.getItemId())
        {
            case R.id.nofication:

                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                }
                break;
            case R.id.Received:
                if (bottomSheetBehaviors.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehaviors.setState(BottomSheetBehavior.STATE_HIDDEN);

                } else {
                    bottomSheetBehaviors.setState(BottomSheetBehavior.STATE_EXPANDED);

                }

                /*Toast.makeText(getApplicationContext(),"Touch",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(),Money_Received.class);
                startActivity(i);*/
                break;

        }



        return super.onOptionsItemSelected(item);
    }

}
