package mobile.android.partthree.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import mobile.android.partthree.ScreenTwoActivity
import mobile.android.partthree.databinding.ItemRecyclerviewBinding
import mobile.android.partthree.model.DataResponseItem

class ContactAdapter(private val activity: AppCompatActivity,
                     private val list: List<DataResponseItem>) : RecyclerView.Adapter<ContactAdapter.ContactVH>() {


   inner class ContactVH(private val itemBinding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(itemBinding.root){

        fun bind(item: DataResponseItem){
            itemView.run {
                itemBinding.name.text = item.firstName
                itemBinding.card.setOnClickListener {
                    val intent = Intent(activity, ScreenTwoActivity::class.java)
                    intent.putExtra(ScreenTwoActivity.EXTRA_ID, item.id)
                    activity.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactVH {
        return ContactVH(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ContactVH, position: Int) {
        val item = list[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int = list.size
}