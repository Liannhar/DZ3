package com.example.my.model.service

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.my.model.Hobby

class DBHandler(context: Context?):SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val hobbyQuery = ("CREATE TABLE " + TABLE_NAME_HOBBY + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + IMAGE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + FAVORITE_COL + " NUMERIC)")

        val eventQuery = ("CREATE TABLE " + TABLE_NAME_EVENT + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + IMAGE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + SUBSCRIBE_COL + " NUMERIC,"
                + DUE_DATE + " NUMERIC,"
                + DUE_TIME + " NUMERIC)")

        val groupQuery = ("CREATE TABLE " + TABLE_NAME_GROUP + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + IMAGE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + SUBSCRIBE_COL + " NUNERIC,"
                + MEMBERS_COL + " NUMERIC)")

        db?.execSQL(hobbyQuery)
        db?.execSQL(groupQuery)
        db?.execSQL(eventQuery)
    }




    fun addNewHobby(
        hobbyName: String?,
        hobbyDescription: String?,
        hobbyImage: String?,
        hobbyFavorite:Boolean?
    ) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, hobbyName)
        values.put(DESCRIPTION_COL, hobbyDescription)
        values.put(IMAGE_COL, hobbyImage)
        values.put(FAVORITE_COL, hobbyFavorite)
        db.insert(TABLE_NAME_HOBBY, null, values)
        db.close()
    }

    fun getHobbyies():Hobby
    {
        val db = this.readableDatabase
        val cursor = db?.rawQuery("SELECT * FROM " + TABLE_NAME_HOBBY,null)

        with(cursor)
        {
            while(this?.moveToNext()!!){

            }
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_HOBBY)
        onCreate(db)
    }

    companion object {
        private const val DB_NAME = "HobbyDB"
        private const val DB_VERSION = 1

        private const val TABLE_NAME_HOBBY = "Hobby"
        private const val TABLE_NAME_EVENT = "Event"
        private const val TABLE_NAME_GROUP = "Group"

        private const val ID_COL = "id"
        private const val NAME_COL = "name"
        private const val IMAGE_COL = "image"
        private const val DESCRIPTION_COL = "description"

        private const val SUBSCRIBE_COL = "subscribe"
        private const val MEMBERS_COL = "members"
        private const val DUE_DATE="due date"
        private const val DUE_TIME="due time"
        private const val FAVORITE_COL = "favorite"
    }


}