package mx.itson.keens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itson.keens.adaptadores.Adaptador
import mx.itson.keens.entidades.winners

class ListWinnersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_winners)
        val listView = findViewById(R.id.listView)
        val lista = winners().obtenerwinners(this)
        val adaptador = Adaptador(lista)

        listView.adapter = adaptador

    }
}
    }
}