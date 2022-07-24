package com.example.segundoproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*TODO Es recomendable manejar la referencia de la ruta del fragmento
        *  a travez de codigo y no del XML : android:name="com.example.segundoproyecto.PrimerFragment"
        *  Navegamos hacia al fragmento para ponerlo dentro del contenedor*/
        supportFragmentManager.commit {
            // TODO Para que las transiciones se ejecuten de manera correcta
            setReorderingAllowed(true)
            // TODO Primero encontramos el contenedor y luego el fragmento
            add(R.id.fragment_container_view, PrimerFragment())
        }
    }
}