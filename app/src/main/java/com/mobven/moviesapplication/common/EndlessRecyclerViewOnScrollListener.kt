package com.mobven.moviesapplication.common

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerViewOnScrollListener(linearLayoutManager: LinearLayoutManager): RecyclerView.OnScrollListener() {

    var TAG = this::class.java!!.getSimpleName()

    private var previousTotal = 0
    private var loading = true
    private val visibleThreshold = 1

    internal var firstVisibleItem: Int = 0
    internal var visibleItemCount:Int = 0
    internal var totalItemCount:Int = 0

    private var current_page = 1

    private var mLinearLayoutManager = linearLayoutManager

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        visibleItemCount = recyclerView.childCount
        totalItemCount = mLinearLayoutManager.itemCount
        firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition()

        if (loading) {
            if (totalItemCount > previousTotal + 1) {
                loading = false
                previousTotal = totalItemCount
            }
        }
        if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold && previousTotal != 0) {

            current_page++
            Log.d(TAG, current_page.toString())

            onLoadMore()
            loading = true
        }
    }

    abstract fun onLoadMore()

    fun reset(previousTotal: Int, loading: Boolean) {
        this.previousTotal = previousTotal
        this.loading = loading
    }
}