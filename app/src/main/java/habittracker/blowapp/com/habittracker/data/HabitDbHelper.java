package habittracker.blowapp.com.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import habittracker.blowapp.com.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by Aran on 11/10/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "habit.db";
    public static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        System.out.println("HELLOW DARAKLFAKL");
        String SQL_CREATE_HABIT_TABLE = ("CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.HABIT_TITLE + " TEXT NOT NULL, "
                + HabitEntry.HABIT_COUNT + " INTEGER NOT NULL DEFAULT 0, "
                + HabitEntry.HABIT_DATE + " TEXT);");
        sqLiteDatabase.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
