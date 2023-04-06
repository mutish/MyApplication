package com.example.myapplication3.adapter
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.databinding.QuestionItemBinding
import com.example.myapplication3.model.Question

class ListAdapter(private val context: Context, private val mQuestion: List<Question>, private val mRowLayout: Int)
    : RecyclerView.Adapter<ListAdapter.QuestionViewHolder>() {

    //inflating the recycled layout
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuestionViewHolder {

        val binding = QuestionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionViewHolder(binding)

    }
    @SuppressLint("StringFormatInvalid")
    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
//         map the title and the link and position to the textview in the recycled items
//        holder.positionNumber?.text = context.resources.getString(R.string.question_num, position + 1)
//        holder.title?.text = context.resources.getString(R.string.question_title, mQuestion[position].title)
//        holder.link?.text = context.resources.getString(R.string.question_link, mQuestion[position].link)
        holder.positionNumber?.text = (position + 1).toString()
        holder.title?.text = mQuestion[position].title
        holder.link?.text = mQuestion[position].link

    }
    override fun getItemCount(): Int {
        return mQuestion.size
    }
    // access to views from recycled items
    class QuestionViewHolder(private val binding: QuestionItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val positionNumber = binding.itemNumber
        val title = binding.title
        val link = binding.link
    }
}