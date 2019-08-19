package com.mobven.moviesapplication.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FavouriteResponse {

    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null

    inner class Result {

        @SerializedName("adult")
        @Expose
        var adult: Boolean? = null
        @SerializedName("backdrop_path")
        @Expose
        var backdropPath: String? = null
        @SerializedName("genre_ids")
        @Expose
        var genreIds: List<Int>? = null
        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("original_language")
        @Expose
        var originalLanguage: String? = null
        @SerializedName("original_title")
        @Expose
        var originalTitle: String? = null
        @SerializedName("overview")
        @Expose
        var overview: String? = null
        @SerializedName("poster_path")
        @Expose
        var posterPath: String? = null
        @SerializedName("release_date")
        @Expose
        var releaseDate: String? = null
        @SerializedName("title")
        @Expose
        var title: String? = null
        @SerializedName("video")
        @Expose
        var video: Boolean? = null
        @SerializedName("vote_average")
        @Expose
        var voteAverage: Double? = null
        @SerializedName("vote_count")
        @Expose
        var voteCount: Int? = null
        @SerializedName("popularity")
        @Expose
        var popularity: Double? = null

    }

}