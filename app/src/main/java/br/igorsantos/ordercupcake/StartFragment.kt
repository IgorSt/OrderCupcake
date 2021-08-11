package br.igorsantos.ordercupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.igorsantos.ordercupcake.databinding.FragmentStartBinding
import br.igorsantos.ordercupcake.model.OrderViewModel

/**
 * Created by IgorSantos on 8/7/2021.
 */
class StartFragment : Fragment() {

    private var binding: FragmentStartBinding? = null

    private val sharedViewModels: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding
            .inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this
    }

    fun orderCupcake(quantity: Int){
        sharedViewModels.setQuantity(quantity)

        if(sharedViewModels.hasNoFlavorSet()){
            sharedViewModels.setFlavor(getString(R.string.vanilla))
        }

        findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}