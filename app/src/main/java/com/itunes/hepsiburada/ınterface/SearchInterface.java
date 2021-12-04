package com.itunes.hepsiburada.ınterface;

import com.itunes.hepsiburada.model.SearchModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchInterface {
    @GET("search")
    Call<SearchModel> getSearchResults(@Query("term") CharSequence searchTerm, @Query("entity") String entity, @Query("limit") int limit);

}
