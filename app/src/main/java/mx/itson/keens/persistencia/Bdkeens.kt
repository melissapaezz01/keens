package mx.itson.keens.persistencia

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class Bdkeens(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        try {
        db?.execSQL("CREATE TABLE winners (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, puntos INTEGER, partidas INT)")
    }catch (ex:Exception) {
            Log.e("error", ex.toString())
        }
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}