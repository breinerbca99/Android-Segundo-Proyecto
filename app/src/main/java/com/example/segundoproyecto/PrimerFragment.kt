package com.example.segundoproyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener

/* TODO Este fragment, extienden de Fragment
    y recibe como parametro un LayoutRes */
class PrimerFragment : Fragment(R.layout.fragment_primer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO
        val button = view.findViewById<Button>(R.id.btn_navegar)
        val valorRecibido = view.findViewById<TextView>(R.id.txt_output)

        // TODO Para recuperar el valor del fragmento2
        // TODO requestKey : Es el evento recibido
        // TODO bundleKey : Es una de las llaves de dicho evento recibido
        setFragmentResultListener("requestKey"){ key, bundle ->
            val result = bundle.getString("bundleKey")
            valorRecibido.text = result
        }

        button.setOnClickListener{
            requireActivity().supportFragmentManager.commit {
                // TODO Acciones : add - replace
                replace(R.id.fragment_container_view, SegundoFragment.newInstance("Breiner",23))
                // TODO Lo que hara es poner un id en el backStack para poder navegar hacia aca sin ningun problema
                addToBackStack("primerFragment")
            }
        }
    }
}