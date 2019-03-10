package partida.david.peliculas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ver_pelicula.*

class verPelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_pelicula)


        var bundle = intent.extras
        var imagen: Int = bundle.getInt("pelicula")
        var nombre: String = intent.getStringExtra("nombre")
        var desc: String = intent.getStringExtra("descripcion")

        ver_iv_pelicula.setImageResource(imagen)
        ver_tv_nombre.text = nombre
        ver_tv_descripcion.text = desc

        supportActionBar!!.title = nombre
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


    }
}
