package com.mobven.moviesapplication.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UpcomingResponse {

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null
    @SerializedName("dates")
    @Expose
    var dates: Dates? = null
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null

    inner class Result {

        @SerializedName("vote_count")
        @Expose
        var voteCount: Int? = null
        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("video")
        @Expose
        var video: Boolean? = null
        @SerializedName("vote_average")
        @Expose
        var voteAverage: Double? = null
        @SerializedName("title")
        @Expose
        var title: String? = null
        @SerializedName("popularity")
        @Expose
        var popularity: Double? = null
        @SerializedName("poster_path")
        @Expose
        var posterPath: String? = null
        @SerializedName("original_language")
        @Expose
        var originalLanguage: String? = null
        @SerializedName("original_title")
        @Expose
        var originalTitle: String? = null
        @SerializedName("genre_ids")
        @Expose
        var genreIds: List<Int>? = null
        @SerializedName("backdrop_path")
        @Expose
        var backdropPath: String? = null
        @SerializedName("adult")
        @Expose
        var adult: Boolean? = null
        @SerializedName("overview")
        @Expose
        var overview: String? = null
        @SerializedName("release_date")
        @Expose
        var releaseDate: String? = null
    }

    inner class Dates {

        @SerializedName("maximum")
        @Expose
        var maximum: String? = null
        @SerializedName("minimum")
        @Expose
        var minimum: String? = null

    }

}