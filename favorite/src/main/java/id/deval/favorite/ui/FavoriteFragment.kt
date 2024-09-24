package id.deval.favorite.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.EntryPointAccessors
import id.deval.core.data.Resource
import id.deval.core.ui.GameAdapter
import id.deval.core.utils.toGame
import id.deval.favorite.databinding.FragmentFavoriteBinding
import id.deval.favorite.di.DaggerFavoriteComponent
import id.deval.favorite.utils.ViewModelFactory
import id.deval.mygames.di.FavoriteModuleDependencies
import javax.inject.Inject


class FavoriteFragment : Fragment() {

    private var _binding : FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory : ViewModelFactory
    private val favoriteGameViewModel: FavoriteGameViewModel by viewModels {
        factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gameAdapter = GameAdapter(LinearLayoutManager.VERTICAL)
        favoriteGameViewModel.favoriteGames.observe(viewLifecycleOwner){ state ->
            when(state){
                is Resource.Loading -> {}
                is Resource.Success -> {
                    val data = state.data?.map { it.toGame() }
                    data?.let { gameAdapter.setGames(it) }
                }
                is Resource.Error -> {}
            }
        }

        binding.rvFavoriteGame.adapter = gameAdapter
        binding.rvFavoriteGame.setHasFixedSize(true)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFavoriteComponent.builder()
            .context(requireActivity())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireActivity().applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            ).build().inject(this)
    }

}