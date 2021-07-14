package id.tadi.visithumbang.events.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.tadi.visithumbang.databinding.SecondaryCardBinding

class EventSecondaryAdapter(private val events : ArrayList<Event>) : RecyclerView.Adapter<EventSecondaryAdapter.SecondaryViewHolder>() {

    inner class SecondaryViewHolder(private val binding : SecondaryCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(event : Event){
            binding.scTitle.text = event.eventName
            binding.scTitle.setTextColor(Color.WHITE)
            binding.scDate.text = event.eventDate
            binding.scDate.setTextColor(Color.WHITE)
            binding.scLocation.text = event.eventLocation
            binding.scLocation.setTextColor(Color.WHITE)
            Glide.with(binding.cardBackground.context)
                .load(event.eventPoster)
                .into(binding.cardBackground)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondaryViewHolder {
        return SecondaryViewHolder(SecondaryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SecondaryViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int {
        return events.size
    }

}