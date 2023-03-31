package mx.itson.keens.entidades

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import mx.itson.keens.persistencia.Bdkeens

class winners {
    var id = 0
    var nombre: String? = null
    var puntos: Int = 0
    var partidas: Int = 0

    constructor()

    constructor(nombre: String, puntos: Int, partidas: Int) {
        this.nombre = nombre
        this.puntos = puntos
        this.partidas = partidas

    }

    fun guardar(context: Context, nombre: String, puntos: Int, partidas: Int) {
        try {
            val keens = Bdkeens(context, "keens", null, 1)
            var baseDatos: SQLiteDatabase = keens.writableDatabase

            val valores = ContentValues()
            valores.put("nombre", nombre)
            valores.put("puntos", puntos)
            valores.put("partidas", partidas)

            baseDatos.insert("winners", null, valores)


        } catch (ex: Exception) {
        }
    }
        fun obtenerjugadores(context: Context): ArrayList<winners> {
            val list: MutableList<winners> = ArrayList()
            try {
                val keens = Bdkeens(context, "keens", null, 1)
                var baseDatos: SQLiteDatabase = keens.readableDatabase

                val cursor = baseDatos.rawQuery("SELECT id, nombre, puntos, partidas FROM winners ORDER BY puntos ASC LIMIT 10", null)
                 while (cursor.moveToNext()){

                     val w= winners(cursor.getString(1), cursor.getInt(2), cursor.getInt(3))

                     list.add(w)
                 }

            } catch (ex: Exception) {


            }
            return list as ArrayList<winners>
        }
    }
