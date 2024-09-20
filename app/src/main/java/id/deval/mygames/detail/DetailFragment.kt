package id.deval.mygames.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import id.deval.core.domain.model.Game
import id.deval.core.ui.PreviewGameAdapter
import id.deval.mygames.R
import id.deval.mygames.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val TAG = "DetailFragment"
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val game = arguments?.getParcelable<Game>(EXTRA_DATA)
        with(binding) {
            mtvDetailTitle.text = game?.name
            mtvDetailReleasedate.text = game?.released
            mtvDetailRating.text = "Ratings : ${game?.rating}"
            mtvDetailTotalRating.text = "Total Rating : ${game?.ratingsCount}"

            val previewAdapter = PreviewGameAdapter()
            val urls = game?.shortScreenshots?.map { it.image }?.toList()

            Log.d(TAG, "onViewCreated: $game")
            previewAdapter.setData(urls)

            rvDetailImages.adapter = previewAdapter
            rvDetailImages.setHasFixedSize(true)

            Glide.with(binding.root.context)
                .load(game?.backgroundImage)
                .into(ivDetailBackground)

            ibDetailBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

}