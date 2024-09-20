package id.deval.mygames.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.deval.core.data.Resource
import id.deval.core.ui.GameAdapter
import id.deval.core.utils.safeNavigation
import id.deval.mygames.R
import id.deval.mygames.databinding.FragmentHomeBinding
import id.deval.mygames.detail.DetailFragment

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()

    companion object {
        const val TAG = "HomeFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gameAdapter = GameAdapter()
        gameAdapter.onItemClick = { game ->
            val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.fcv_mainactivity_container) as NavHostFragment?
            val navControllerActivity = navHostFragment?.navController

            val gameDetail = Bundle()
            gameDetail.putParcelable(DetailFragment.EXTRA_DATA, game)
            navControllerActivity?.safeNavigation(R.id.detailFragment, gameDetail)
        }
        homeViewModel.games.observe(viewLifecycleOwner) { games ->
            when (games) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    games.data?.let { gameAdapter.setGames(it) }
                }

                is Resource.Error -> {

                }
            }
        }

        with(binding.rvHomeGame) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = gameAdapter
        }

    }
}