package id.deval.mygames

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import id.deval.core.utils.safeNavigation
import id.deval.mygames.databinding.FragmentMainBinding
import id.deval.mygames.utils.Utils

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var navController: NavController? = null

    companion object {
        const val TAG = "MainFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment = childFragmentManager.findFragmentById(R.id.fcv_mainfragment_container) as NavHostFragment?
        navController = navHostFragment?.navController
        navController?.let {
            binding.botnavMainfragmentContainer.setupWithNavController(it)
        }

        binding.botnavMainfragmentContainer.setOnNavigationItemSelectedListener { items ->
            when (items.itemId){
                R.id.favoriteFragment -> {
                    Utils.installFavoriteFeature(requireContext()) { moveToFavorite() }
                    true
                }
                R.id.homeFragment -> {
                    navController?.safeNavigation(R.id.homeFragment)
                    true
                }
                else -> false
            }
        }
    }


    private fun moveToFavorite(){
        navController?.safeNavigation(R.id.favoriteFragment)
    }

}