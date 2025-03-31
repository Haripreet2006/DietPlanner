package com.example.dietmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
    public DBHelper(Context context)
    {
        super(context, "UserData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // Create Nutrition table
        String createNutritionTable = "CREATE TABLE IF NOT EXISTS Nutrition (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "date TEXT NOT NULL," +
                "protein REAL NOT NULL," +
                "carbohydrate REAL NOT NULL," +
                "fats REAL NOT NULL," +
                "calories REAL NOT NULL)";

        db.execSQL(createNutritionTable);

        // Create Weight table
        String createWeightTable = "CREATE TABLE IF NOT EXISTS Weight (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "date TEXT NOT NULL," +
                "weight REAL NOT NULL," +
                "didYouExercise INTEGER NOT NULL," + // Using INTEGER for boolean (0 = false, 1 = true)
                "dailyGoalAchieved INTEGER NOT NULL," + // Using INTEGER for boolean (0 = false, 1 = true)
                "hasGoalBeenAchieved INTEGER NOT NULL," + // Using INTEGER for boolean (0 = false, 1 = true)
                "FOREIGN KEY (date) REFERENCES Nutrition(date))"; // Linking date between tables

        db.execSQL(createWeightTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
