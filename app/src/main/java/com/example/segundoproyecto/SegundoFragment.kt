package com.example.segundoproyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult

class SegundoFragment : Fragment(R.layout.fragment_segundo) {
    private var nombre: String? = ""
    private var edad: Int? = 0

    /* TODO 2)Aca obtendremos los valores que nos pasaron por argumentos
         ni bien se inicialize este fragmento*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nombre = requireArguments().getString(MI_NOMBRE)
        edad = requireArguments().getInt(MI_EDAD)
    }

    /* TODO 3)Aca pintaremos el valor que obtenemos en uno de nuestros componentes*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.txt_output)
        val button = view.findViewById<Button>(R.id.btn_enviar_datos)
        // TODO Para enviar el valor al fragmento1
        button.setOnClickListener {
            val result = "Enviando al fragment 1"
            // TODO requestKey : Es el evento enviando
            // TODO bundleKey : Es una de las llaves de dicho evento enviado
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }
        text.text = "$nombre $edad"
    }

    // TODO 1)Para pasar variables como parametros a este fragmento
    companion object{
        private const val MI_NOMBRE = "nombre"
        private const val MI_EDAD = "edad"

        fun newInstance(nombre: String, edad: Int) = SegundoFragment().apply {
            // TODO Aqui mapeamos los valores a el constructor nombre, edad
            arguments = bundleOf(MI_NOMBRE to nombre, MI_EDAD to edad)
        }
    }
}