package com.techsofficial.prithivi.bottomsheet;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Money_Received extends AppCompatActivity {

    BottomSheetBehavior bottomSheetBehavior;
    Button btExpand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money__received);

        View bottomSheet = findViewById(R.id.bottom_sheet);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);


        View bottomSheets = findViewById(R.id.bottom_sheets);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheets);

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
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

                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                }
                break;

        }



        return super.onOptionsItemSelected(item);
    }
}


