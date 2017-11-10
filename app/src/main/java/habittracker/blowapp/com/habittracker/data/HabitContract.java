package habittracker.blowapp.com.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Aran on 11/10/2017.
 */

public class HabitContract {

    private HabitContract() {
    }

    public static class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "habit";
        public final static String _ID = BaseColumns._ID;
        public final static String HABIT_TITLE = "title";
        public final static String HABIT_COUNT = "count";
        public final static String HABIT_DATE = "date";
    }
}
