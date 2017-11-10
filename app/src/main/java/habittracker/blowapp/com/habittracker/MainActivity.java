package habittracker.blowapp.com.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import habittracker.blowapp.com.habittracker.data.HabitContract.HabitEntry;
import habittracker.blowapp.com.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dbHelper = new HabitDbHelper(this);
        insertHabit();
        readHabit();
    }

    public void insertHabit() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(HabitEntry.HABIT_TITLE, "Practice Piano");
        values.put(HabitEntry.HABIT_COUNT, 7);
        values.put(HabitEntry.HABIT_DATE, "Sep-10-2014");

        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);
        System.out.println(newRowId);
    }

    public void readHabit() {
        Cursor cursor = getCursor();
        try {
            int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
            int titleColumnIndex = cursor.getColumnIndex(HabitEntry.HABIT_TITLE);
            int countColumnIndex = cursor.getColumnIndex(HabitEntry.HABIT_COUNT);
            int dateColumnIndex = cursor.getColumnIndex(HabitEntry.HABIT_DATE);

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentTitle = cursor.getString(titleColumnIndex);
                int currentCount = cursor.getInt(countColumnIndex);
                String currentDate = cursor.getString(dateColumnIndex);
                System.out.println(currentID + " " + currentCount + " " + currentDate + " " + currentTitle);
            }
        } finally {
            cursor.close();
        }
    }

    private Cursor getCursor() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.HABIT_TITLE,
                HabitEntry.HABIT_COUNT,
                HabitEntry.HABIT_DATE,
        };
        return db.query(HabitEntry.TABLE_NAME, projection, null, null, null, null, null);
    }
}
