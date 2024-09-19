package id.deval.mygames

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.findFragment
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import id.deval.core.utils.safeNavigation
import id.deval.mygames.databinding.FragmentMainBinding

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
                R.id.favorite_nav -> {
                    installFavoriteFeature()
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

    private fun installFavoriteFeature(){
        val splitInstallManager = SplitInstallManagerFactory.create(requireContext())
        val moduleFavorite = "favorite"
        if (splitInstallManager.installedModules.contains(moduleFavorite)){
            Log.d(TAG, "Favorite module already installed")
            moveToFavorite()
            return
        } else {
            val splitInstallRequest = SplitInstallRequest.newBuilder()
                .addModule(moduleFavorite)
                .build()

            splitInstallManager.startInstall(splitInstallRequest)
                .addOnSuccessListener {
                    Log.d(TAG, "Success installing module")
                    moveToFavorite()
                }
                .addOnFailureListener {
                    Log.d(TAG, "Error installing module")
                }
        }
    }

    private fun moveToFavorite(){
        navController?.safeNavigation(R.id.favorite_nav)
    }

}