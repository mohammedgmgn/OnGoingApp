package android.support.ongoingapp.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gmgn on 8/26/2016.
 */
public class OngoingHelper extends SQLiteOpenHelper {


    public OngoingHelper(Context context) {
        super(context, "Pokemon", null, 1);  //context,Database Name,Cursor,Database version

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Pokemondata (id integer primary key autoincrement,name text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists Pokemondata");
        // Re Create on method  onCreate
        onCreate(sqLiteDatabase);

    }

}