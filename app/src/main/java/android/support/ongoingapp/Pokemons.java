package android.support.ongoingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.ongoing.R;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Pokemons extends AppCompatActivity {


        ListView lv;
        Context context;
        boolean x=true;

        ArrayList prgmName;
        public static int [] prgmImages={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e
                ,R.drawable.f};
    public static String [] prgmNameList={"Totodile","Cyndaquil",
            "Chickorita","Squirtle","Bulbasuar","Treeko"};
    public static String [] Sortednames={"Bulbasuar","Chickorita","Cyndaquil"
            ,"Squirtle","Totodile","Treeko"};
    public static int [] SortedImages={R.drawable.e,R.drawable.c,R.drawable.b
            ,R.drawable.d,R.drawable.a,R.drawable.f};



    Toolbar mToolbar4;
    CustomAdapter ca;
    CustomAdapter caSorted;
  //  TextView mTitle;
    //Typeface tf;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pokemons);
        mToolbar4 = (Toolbar) findViewById(R.id.toolbar3);

        setSupportActionBar(mToolbar4);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

      //   mTitle = (TextView) mToolbar4.findViewById(R.id.text4);
        /// tf =  Typeface.createFromAsset(getAssets(),"Pokemon Solid.ttf");
        //mTitle.setTypeface(tf);


            context=this;

            lv=(ListView) findViewById(R.id.list_view);
        ca =new CustomAdapter(getApplicationContext(),prgmNameList,prgmImages);

        caSorted=new CustomAdapter(getApplicationContext(),Sortednames,SortedImages);


            lv.setAdapter(ca);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
         /*  final String item = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(),item,Toast.LENGTH_SHORT).show();*/

                    // view.setAlpha(1);


                    if(x) {

                        Intent in = new Intent(getApplicationContext(), DetailActivity.class);  // get a valid context
                        in.putExtra("someKey", prgmNameList[i]);
                        in.putExtra("intKey", prgmImages[i]);
                        startActivity(in);

                    }
                    else

                    {
                        Intent in = new Intent(getApplicationContext(), DetailActivity.class);  // get a valid context
                        in.putExtra("someKey", Sortednames[i]);
                        in.putExtra("intKey", SortedImages[i]);
                        startActivity(in);


                    }

                }
            });









        }






        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_home, menu);
            return true;
        }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();

        if(i==R.id.sort) {
           x=false;
            lv.setAdapter(caSorted);

        }
        if(i==R.id.log_out) {
        //    clearUserName(Pokemons.this);
            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() +".my_pref_file", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("mailkey","");
            editor.apply();

            Intent n = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(n);
            finish();
        }
        if(i==R.id.defaultt) {
            x=true;
            lv.setAdapter(ca);

        }

        return  true;
    }

}

