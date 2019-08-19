package com.mobven.moviesapplication.adapter

import android.content.Context
import android.os.Process
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.bumptech.glide.Glide
import com.mobven.moviesapplication.R
import com.mobven.moviesapplication.response.TopRatedResponse

class MovieListAdapter(context: Context, list: ArrayList<TopRatedResponse.Result>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ITEM = 1

    private var mContext = context
    private var mList = list

    private lateinit var itemClickedListener: ItemClickedListener

    interface ItemClickedListener{
        fun onItemClicked(data: TopRatedResponse.Result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieCardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return if (mList == null) 0 else mList.size
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_ITEM
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MovieCardViewHolder) holder.bind(holder, position)
    }

    fun addAll(list: ArrayList<TopRatedResponse.Result>) {
        this.mList.addAll(list)
        this.notifyDataSetChanged()
    }

    fun setItemClickListener(listener: ItemClickedListener){
        this.itemClickedListener = listener
    }

    inner class MovieCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            ButterKnife.bind(this, itemView)
        }

        @BindView(R.id.rootCV)
        lateinit var rootCV: CardView

        @BindView(R.id.backdropIV)
        lateinit var backdropIV: ImageView

        @BindView(R.id.posterIV)
        lateinit var posterIV: ImageView

        @BindView(R.id.titleTV)
        lateinit var titleTV: TextView

        @BindView(R.id.populurityTV)
        lateinit var populurityTV: TextView

        @BindView(R.id.languageTV)
        lateinit var languageTV: TextView

        @BindView(R.id.releaseDateTV)
        lateinit var releaseDateTV: TextView

        fun bind(holder: MovieCardViewHolder, position: Int) {
            var movie = mList.get(position)

            holder.titleTV.text = (movie as TopRatedResponse.Result).title
            holder.populurityTV.text = movie.popularity.toString()
            holder.languageTV.text = movie.originalLanguage
            holder.releaseDateTV.text = movie.releaseDate

            Glide
                .with(itemView)
                .load("http://image.tmdb.org/t/p/w500" + movie.backdropPath)
                .into(holder.backdropIV)

            Glide
                .with(itemView)
                .load("http://image.tmdb.org/t/p/w500" + movie.posterPath)
                .into(holder.posterIV)

            holder.rootCV.setOnClickListener{ itemClickedListener.onItemClicked(movie) }
        }
    }
}