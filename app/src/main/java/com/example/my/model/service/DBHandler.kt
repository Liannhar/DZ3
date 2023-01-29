package com.example.my.model.service

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.my.model.Event
import com.example.my.model.Group
import com.example.my.model.Hobby
import javax.inject.Inject

class DBHandler
@Inject
constructor(context: Context?):SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

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
                + HOBBY_NAME_COL + " TEXT,"
                + DUE_DATE_COL + " NUMERIC,"
                + DUE_TIME_COL + " NUMERIC)")

        val groupQuery = ("CREATE TABLE " + TABLE_NAME_GROUP + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + IMAGE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + SUBSCRIBE_COL + " NUMERIC,"
                + HOBBY_NAME_COL + " TEXT,"
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

    fun getHobbyies():List<Hobby>
    {
        val db = this.readableDatabase
        val cursor = db?.rawQuery("SELECT * FROM " + TABLE_NAME_HOBBY,null)
        val hobbyList:MutableList<Hobby> = emptyList<Hobby>().toMutableList()


        if (cursor != null) {
            if (cursor.moveToFirst() ) {
                do {
                    hobbyList.add(Hobby(cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)))
                } while (cursor.moveToNext())
            }
        }
        cursor?.close()
        return hobbyList
    }

    fun getHobby(name:String):Hobby
    {
        val db = this.readableDatabase
        val cursor = db?.rawQuery("SELECT * FROM " + TABLE_NAME_HOBBY + "WHERE name=name",null)
        var hobby:Hobby=Hobby()

        if (cursor != null) {
            hobby = Hobby(cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5).toBoolean()
            )
        }
        cursor?.close()
        return hobby
    }

    fun getEvents(hobbyName: String?):List<Event>
    {
        val db = this.readableDatabase
        val cursor = db?.rawQuery("SELECT * FROM $TABLE_NAME_EVENT WHERE hobby=$hobbyName" ,null)
        val eventList:MutableList<Event> = emptyList<Event>().toMutableList()

        if (cursor != null) {
            if (cursor.moveToFirst() ) {
                do {
                    eventList.add(Event(cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5).toBoolean(),
                        cursor.getString(6),
                        cursor.getString(7)))
                } while (cursor.moveToNext())
            }
        }
        cursor?.close()
        return eventList
    }

    fun getEvent(name:String):Event
    {
        val db = this.readableDatabase
        val cursor = db?.rawQuery("SELECT * FROM $TABLE_NAME_EVENT WHERE name=$name",null)
        var event:Event=Event()

        if (cursor != null) {
            event = Event(cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5).toBoolean(),
                cursor.getString(6),
                cursor.getString(7))
        }
        cursor?.close()
        return event
    }

    fun addNewEvent(
        eventName: String?,
        eventDescription: String?,
        eventImage: String?,
        eventSubscribe:Boolean?,
        eventDuedate:String?,
        eventDuetime:String?
    ) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, eventName)
        values.put(DESCRIPTION_COL, eventDescription)
        values.put(IMAGE_COL, eventImage)
        values.put(SUBSCRIBE_COL,eventSubscribe)
        values.put(DUE_DATE_COL, eventDuedate)
        values.put(DUE_TIME_COL, eventDuetime)
        db.insert(TABLE_NAME_GROUP, null, values)
        db.close()
    }

    fun getGroups(hobbyName: String?):List<Group>
    {
        val db = this.readableDatabase
        val cursor = db?.rawQuery("SELECT * FROM $TABLE_NAME_GROUP Where hobby=$hobbyName",null)
        val groupList:MutableList<Group> = emptyList<Group>().toMutableList()

        if (cursor != null) {
            if (cursor.moveToFirst() ) {
                do {
                    groupList.add(Group(cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5).toBoolean(),
                        cursor.getString(6).toInt()))
                } while (cursor.moveToNext())
            }
        }
        cursor?.close()
        return groupList
    }

    fun getGroup(name:String):Group
    {
        val db = this.readableDatabase
        val cursor = db?.rawQuery("SELECT * FROM $TABLE_NAME_EVENT WHERE name=$name",null)
        var group:Group=Group()

        if (cursor != null) {
            group = Group(cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5).toBoolean(),
                cursor.getString(6).toInt())
        }
        cursor?.close()
        return group
    }
    fun addNewGroup(
        groupName: String?,
        groupDescription: String?,
        groupImage: String?,
        groupSubscribe:Boolean?,
        groupMembers:Int?
    ) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, groupName)
        values.put(DESCRIPTION_COL, groupDescription)
        values.put(IMAGE_COL, groupImage)
        values.put(SUBSCRIBE_COL, groupSubscribe)
        values.put(MEMBERS_COL, groupMembers)
        db.insert(TABLE_NAME_GROUP, null, values)
        db.close()
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_HOBBY")
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
        private const val HOBBY_NAME_COL="hobby"

        private const val SUBSCRIBE_COL = "subscribe"
        private const val MEMBERS_COL = "members"
        private const val DUE_DATE_COL="due date"
        private const val DUE_TIME_COL="due time"
        private const val FAVORITE_COL = "favorite"
    }


}