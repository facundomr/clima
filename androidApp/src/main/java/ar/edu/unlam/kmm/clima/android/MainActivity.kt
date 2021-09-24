package ar.edu.unlam.kmm.clima.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ar.edu.unlam.kmm.clima.repositorio.RepositorioDelClima
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val repositorio = RepositorioDelClima()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "Cargando..."

        MainScope().launch {
            kotlin.runCatching {
                repositorio.obtenerClima()
            }.onSuccess {
                tv.text = it
            }
            .onFailure {
                tv.text = it.toString()
            }
        }
    }
}