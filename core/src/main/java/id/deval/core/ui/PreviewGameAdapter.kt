package id.deval.core.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import id.deval.core.databinding.ItemPreviewGameBinding

class PreviewGameAdapter : RecyclerView.Adapter<PreviewGameAdapter.PreviewGameViewHolder>() {

    private var listData = ArrayList<String?>()
    companion object {
        const val TAG = "PreviewGameAdapter"
    }

    inner class PreviewGameViewHolder(binding: ItemPreviewGameBinding) :
        ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PreviewGameViewHolder {
        val binding =
            ItemPreviewGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PreviewGameViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PreviewGameViewHolder,
        position: Int
    ) {
        val url = listData[position]

        Log.d(TAG, "onBindViewHolder: url $url")
        val binding = ItemPreviewGameBinding.bind(holder.itemView)
        Glide.with(holder.itemView.context)
            .load(url)
            .into(binding.ivPreviewGame)
    }

    override fun getItemCount(): Int = listData.size

    fun setData(newListData: List<String?>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }
}