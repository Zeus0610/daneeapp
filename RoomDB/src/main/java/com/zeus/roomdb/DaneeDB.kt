package com.zeus.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zeus.roomdb.dao.CharacterDao
import com.zeus.roomdb.entities.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
abstract class DaneeDB: RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    companion object {
        private var instance: DaneeDB? = null

        fun getInstance(context: Context): DaneeDB = instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context): DaneeDB {
            return Room.databaseBuilder(
                context = context,
                klass = DaneeDB::class.java,
                name = "danee_db"
            ).build()
        }
    }
}