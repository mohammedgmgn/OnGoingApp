package android.support.ongoingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.ongoing.R;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tv ;
    String ExternalFontPath;
    Typeface FontLoaderTypeface;
    Toolbar mToolbar;
    EditText mail,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   //open sharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() +".my_pref_file", Context.MODE_PRIVATE);
        String tempmail = sharedPreferences.getString("mailkey","");
        //check if he logged in before
        if(tempmail.length()>1)
{

 startActivity(new Intent(MainActivity.this,Pokemons.class));
}

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
// Get access to the custom title view
        //TextView mTitle = (TextView) mToolbar.findViewById(R.id.text);
       //Typeface tf =  Typeface.createFromAsset(getAssets(),"Pokemon Solid.ttf");
        //mTitle.setTypeface(tf);

        Button signin = (Button)findViewById(R.id.button);
      //  b.setTypeface(tf);

        TextView register = (TextView)findViewById(R.id.register);
        mail=(EditText)findViewById(R.id.mailid);
        password=(EditText)findViewById(R.id.passwordid);

        //register.setTypeface(tf);



        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        SpannableString st = new SpannableString(actionBar.getTitle());
        st.setSpan(new myTypeFace("",Typeface.createFromAsset(getAssets(),"Pokemon Solid.ttf")),0,
                st.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(st);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#40c8ca")));
       // actionBar.setTitle(Html.fromHtml("<font color='#f17304'>ActionBartitle </font>"));*/
        signin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(mail.getText().toString().isEmpty()||password.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this,"Invalid input",Toast.LENGTH_LONG).show();

            }
            else
            {


               // Save data to Activity Level SharedPrefs
                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() +".my_pref_file", Context.MODE_PRIVATE);
                String mailstring=mail.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("mailkey",mailstring);
                editor.apply(); //commit changes


                Intent n = new Intent(getApplicationContext(),Pokemons.class);
                startActivity(n);

            }


        }
    });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(getApplicationContext(),SignUp.class);
                startActivity(n);
            }
        });




    }
}


