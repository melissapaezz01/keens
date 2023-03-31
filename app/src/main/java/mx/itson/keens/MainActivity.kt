package mx.itson.keens

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    var ubicacion = 0
    var contador = 0
    var puntos = 0
    var partidas =1

    var destapadas = IntArray(12)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnReiniciar = findViewById<Button>(R.id.btn_reiniciar)
        btnReiniciar.setOnClickListener(this)
        val btnPartidas = findViewById<Button>(R.id.btn_list)
        btnPartidas.setOnClickListener(this)
        for (i in 1..12) {
            var btnSeleccion = findViewById<ImageButton>(
                resources.getIdentifier(
                    "opcion$i",
                    "id",
                    this.packageName
                )
            )
            btnSeleccion.setOnClickListener(this)
        }
        iniciar()
    }

    fun iniciar() {
        findViewById<View>(R.id.opcion1).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion2).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion3).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion4).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion5).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion6).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion7).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion8).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion9).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion10).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion11).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion12).setBackgroundResource(R.drawable.icon_pregunta)
        val random = Random()
        ubicacion = random.nextInt(11)+1
        contador = 0
        destapadas = IntArray(12)
    }
    fun destapar(opcion: Int) {
        if (opcion == ubicacion) {
            partidas++
            Toast.makeText(this, "Perdiste", Toast.LENGTH_SHORT).show()
            for (i in 1..12) {
                var btnSeleccion = findViewById<ImageButton>(
                    resources.getIdentifier(
                        "opcion$i", "id", this.packageName
                    )
                )
                if (i == opcion) {
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems_llora)

                } else {
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems)
                }
            }
        } else {

            var btnSeleccion = findViewById<View>(
                resources.getIdentifier(
                    "opcion$opcion", "id", this.packageName
                )
            ) as ImageButton
            btnSeleccion.setBackgroundResource(R.drawable.icon_cheems)
            contador++
            puntos++
            if (contador == 11) {

                var btngGanador = findViewById<ImageButton>(
                    resources.getIdentifier(
                        "opcion$ubicacion", "id", this.packageName
                    )
                )
                btngGanador.setBackgroundResource(R.drawable.cheems_win)
                Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AgregarGanadorActivity::class.java).apply{
                    putExtra("partidas",partidas)
                    putExtra("puntos",puntos)
                }
                startActivity(intent)

            }
        }
    }

    override fun onClick(v: View?) {


    }


}