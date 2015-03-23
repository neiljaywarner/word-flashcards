package wordflashcards.njwapps.com.wordflashcards.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import wordflashcards.njwapps.com.wordflashcards.model.Verse;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by warner on 3/23/15.
 */
public class CupboardSQLLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "word.db";
    private static final int DATABASE_VERSION = 1;

    static {
        // register our models
        cupboard().register(Verse.class);
    }

    public CupboardSQLLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // this will ensure that all tables are created
        cupboard().withDatabase(db).createTables();
        // add indexes and other database tweaks
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this will upgrade tables, adding columns and new tables.
        // Note that existing columns will not be converted
        cupboard().withDatabase(db).upgradeTables();
        // do migration work
    }
}
