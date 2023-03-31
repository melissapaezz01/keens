package mx.itson.keens.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.keens.R
import mx.itson.keens.entidades.winners

class Adaptador {
    class Adaptador (val listaJugador : ArrayList<winners>): BaseAdapter() {
        override fun getCount(): Int {
            return  listaJugador.size
        }

        override fun getItem(position: Int): Any {
            return listaJugador[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var view = convertView
            if (view == null) {
                view = LayoutInflater.from(parent?.context).inflate(R.layout.item_winner, parent, false)
            }
            val nombreTextView = view?.findViewById<TextView>(R.id.txt_nombre)
            nombreTextView?.text = listaJugador[position].nombre

            val puntosTextView = view?.findViewById<TextView>(R.id.txt_puntos)
            puntosTextView?.text = listaJugador[position].puntos.toString()

            val partidasTextView = view?.findViewById<TextView>(R.id.txt_partidas)
            partidasTextView?.text = listaJugador[position].partidas.toString()


            return view!!
        }

}