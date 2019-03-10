package partida.david.peliculas

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.pelicula_view.view.*

class MainActivity : AppCompatActivity() {
    var listaPeliculas = ArrayList<Pelicula>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        crearPeliculas()
        var adaptador = AdaptadorPelicula(this,listaPeliculas)
        listview.adapter = adaptador



    }
    fun crearPeliculas(){
        var pelicula1 = Pelicula("Sueños de libertad", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", R.drawable.suenos_de_libertad)
        var pelicula2 = Pelicula("El Padrino", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", R.drawable.el_padrino)
        var pelicula3 = Pelicula("El padrino: Parte II", "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.", R.drawable.el_padrino_ii)
        var pelicula4 = Pelicula("Batman: El Caballero de la Noche", "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.", R.drawable.batman_el_caballero_de_la_noche)
        var pelicula5 = Pelicula("12 hombres en pugna", "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.", R.drawable.doce_hombres_en_pugna)

        listaPeliculas.add(pelicula1)
        listaPeliculas.add(pelicula2)
        listaPeliculas.add(pelicula3)
        listaPeliculas.add(pelicula4)
        listaPeliculas.add(pelicula5)

    }
    private class AdaptadorPelicula:BaseAdapter{
        var contexto: Context? = null
        var peliculas = ArrayList<Pelicula>()

        constructor(context: Context, peliculas: ArrayList<Pelicula>){
            contexto = context
            this.peliculas = peliculas
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.pelicula_view,null)
            var pelicula = peliculas[position]
            vista.iv_pelicula.setImageResource(pelicula.imagen)
            vista.tv_nombre.text = pelicula.nombre
            if (pelicula.desc != null){
                vista.tv_descripcion.text = pelicula.desc
            }
            vista.setOnClickListener{
                val intent = Intent(contexto, verPelicula::class.java)
                intent.putExtra("pelicula", pelicula.imagen)
                intent.putExtra("nombre", pelicula.nombre)
                intent.putExtra("descripcion", pelicula.desc)


                contexto?.startActivity(intent)
            }
            return vista
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return peliculas.size
        }
    }
}
