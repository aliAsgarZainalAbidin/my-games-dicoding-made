package id.deval.core.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginEnd
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import id.deval.core.databinding.ItemGameContentBinding
import id.deval.core.domain.model.Game
import javax.inject.Inject

class GameAdapter(
    private val orientation: Int = LinearLayoutManager.HORIZONTAL
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    private var games = ArrayList<Game>()
    var onItemClick: ((Game) -> Unit)? = null

    inner class GameViewHolder(binding: ItemGameContentBinding) : ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(games[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding =
            ItemGameContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size


    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        if (games.isNotEmpty()) {
            val game = games[position]
            val binding = ItemGameContentBinding.bind(holder.itemView)
            with(binding) {
                Log.d("TAG", "onBindViewHolder: Adapter Game $game")

                Glide.with(holder.itemView.context)
                    .load(game.backgroundImage)
                    .into(ivGamecontentItem)
                mtvGamecontentName.text = game.name
                mtvGamecontentGenre.text = "Release : ${game.released}"
                mtvGamecontentPrice.text = "Rating : ${game.rating} Star"

                val layoutParams = root.layoutParams as ViewGroup.MarginLayoutParams
                when (orientation) {
                    LinearLayoutManager.HORIZONTAL -> {
                        layoutParams.setMargins(8,0,8,0)
                        root.layoutParams = layoutParams
                    }
                    LinearLayoutManager.VERTICAL -> {
                        layoutParams.setMargins(0,8,0,8)
                        root.layoutParams = layoutParams
                    }
                }
            }
        }
    }

    fun setGames(games: List<Game>) {
        this.games.clear()
        this.games.addAll(games)
        notifyDataSetChanged()
    }

}