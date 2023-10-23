package uz.itschool.joshqinshoporiginal.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import uz.itschool.joshqinshoporiginal.R
import uz.itschool.joshqinshoporiginal.adapters.ChoosedAdapter
import uz.itschool.joshqinshoporiginal.databinding.FragmentChoosedBinding
import uz.itschool.joshqinshoporiginal.model.Product
import uz.itschool.joshqinshoporiginal.networking.MySharedPreferences

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class ChoosedFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var choosedList: MutableList<Product>
    lateinit var mySharedPreferences: MySharedPreferences
    lateinit var binding: FragmentChoosedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChoosedBinding.inflate(inflater, container, false)
        mySharedPreferences = MySharedPreferences.newInstance(requireContext())
        choosedList = mySharedPreferences.getSelectedCarsList()
        Log.d("List", "onCreateView: $choosedList")

        if (mySharedPreferences.getSelectedCarsList().isNotEmpty()){
            binding.choosedRecycler.visibility = View.VISIBLE
            binding.notfounded.visibility = View.GONE
            binding.choosedRecycler.adapter = ChoosedAdapter(object : ChoosedAdapter.OnBuy{
                override fun onBuy(product: Product) {
                    Toast.makeText(requireContext(), "You have not added your card yet", Toast.LENGTH_SHORT).show()
                }

            }, requireContext(), object : ChoosedAdapter.OnPressed{
                override fun onPressed(product: Product) {
                    parentFragmentManager.beginTransaction().replace(
                        R.id.main,
                        SingleProductFragment.newInstance(product)
                    ).commit()
                }

            })
        }else{
            binding.choosedRecycler.visibility = View.GONE
            binding.notfounded.visibility = View.VISIBLE
        }


        binding.backtoMain.setOnClickListener {
            binding.congratulations.visibility = View.GONE
        }

        binding.ChoosedBack.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main, HomeFragment()).commit()
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChoosedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}