package com.example.at_fundamentos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.at_fundamentos.R
import com.example.at_fundamentos.viewmodels.FazeViewModel
import kotlinx.android.synthetic.main.fragment_primeira_fase.*

/**
 * A simple [Fragment] subclass.
 */
class primeiraFase : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primeira_fase, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var fazeViewModel: FazeViewModel
        activity?.let {
            fazeViewModel = ViewModelProviders.of(it).get(FazeViewModel::class.java)

        }

        btnAvançar.setOnClickListener {
            if (!RbEscolha1.isChecked && !RbEscolha2.isChecked ) {
                Toast.makeText(
                    activity!!.baseContext!!,
                    "Marque todas opções",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                if (RbEscolha1.isChecked){

                    fazeViewModel.faze!!.fazeEscolha = 1
                    findNavController().navigate(R.id.segundaFaze)
                }else{

                    fazeViewModel.faze!!.fazeEscolha = 2
                    findNavController().navigate(R.id.segundaFaze)
                    //perder vida
                }
            }
        }
    }

}
