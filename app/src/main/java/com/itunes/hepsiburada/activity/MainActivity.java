package com.itunes.hepsiburada.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.itunes.hepsiburada.R;
import com.itunes.hepsiburada.adapters.ListAdapter;
import com.itunes.hepsiburada.api.ApiClient;
import com.itunes.hepsiburada.databinding.ActivityMainBinding;
import com.itunes.hepsiburada.model.SearchModel;
import com.itunes.hepsiburada.util.EndlessRecyclerViewScrollistener;
import com.itunes.hepsiburada.ınterface.SearchInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapters;
    SearchInterface searchInterface;
    List<SearchModel.Result> resultList;
    List<SearchModel.Result> filterArray;
    String entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        selectedButton();

        binding.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    hideKeyboard(MainActivity.this);
                    requestList(v.getText().toString(), entity);
                    return true;
                }
                return false;
            }
        });
    }

    private void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void selectedButton() {

        binding.txtEbook.setTextColor(getResources().getColor(R.color.unselected_color));
        binding.txtMovies.setTextColor(getResources().getColor(R.color.selected_color));
        binding.txtMusic.setTextColor(getResources().getColor(R.color.unselected_color));
        binding.txtPodcast.setTextColor(getResources().getColor(R.color.unselected_color));

        entity = "movie";


        binding.txtEbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtEbook.setTextColor(getResources().getColor(R.color.selected_color));
                binding.txtMovies.setTextColor(getResources().getColor(R.color.unselected_color));
                binding.txtMusic.setTextColor(getResources().getColor(R.color.unselected_color));
                binding.txtPodcast.setTextColor(getResources().getColor(R.color.unselected_color));

                entity = "ebook";
            }
        });

        binding.txtMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtMovies.setTextColor(getResources().getColor(R.color.selected_color));
                binding.txtEbook.setTextColor(getResources().getColor(R.color.unselected_color));
                binding.txtMusic.setTextColor(getResources().getColor(R.color.unselected_color));
                binding.txtPodcast.setTextColor(getResources().getColor(R.color.unselected_color));

                entity = "movie";
            }
        });

        binding.txtMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtEbook.setTextColor(getResources().getColor(R.color.unselected_color));
                binding.txtMovies.setTextColor(getResources().getColor(R.color.unselected_color));
                binding.txtMusic.setTextColor(getResources().getColor(R.color.selected_color));
                binding.txtPodcast.setTextColor(getResources().getColor(R.color.unselected_color));

                entity = "musicTrack";
            }
        });

        binding.txtPodcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtEbook.setTextColor(getResources().getColor(R.color.unselected_color));
                binding.txtMovies.setTextColor(getResources().getColor(R.color.unselected_color));
                binding.txtMusic.setTextColor(getResources().getColor(R.color.unselected_color));
                binding.txtPodcast.setTextColor(getResources().getColor(R.color.selected_color));

                entity = "podcast";
            }
        });
    }

    private void requestList(String key, String entity) {
        if (resultList != null && resultList.size() > 0) {
            resultList.clear();
        }
        if (filterArray != null && filterArray.size() > 0) {
            filterArray.clear();
            listAdapters.notifyDataSetChanged();
        }
        binding.progresBar.setVisibility(View.VISIBLE);
        searchInterface = ApiClient.getRetrofit().create(SearchInterface.class);
        Call<SearchModel> searchModelCall = searchInterface.getSearchResults(key, entity, 200);
        searchModelCall.enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().results != null) {
                            resultList = new ArrayList<>();
                            resultList = response.body().getResults();
                            if (resultList != null && resultList.size() > 0) {
                                if (resultList.size() >= 20) {
                                    filterArray = new ArrayList<>(resultList.subList(0, 20));
                                } else {
                                    filterArray = new ArrayList<>(resultList);
                                }

                                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
                                listAdapters = new ListAdapter(MainActivity.this, filterArray);
                                binding.recyclerView.setLayoutManager(gridLayoutManager);
                                binding.recyclerView.setHasFixedSize(true);
                                binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
                                binding.recyclerView.setAdapter(listAdapters);
                                listAdapters.notifyDataSetChanged();
                                pagination(gridLayoutManager);
                            }
                        }
                    }
                }


                binding.progresBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {
                binding.progresBar.setVisibility(View.GONE);
            }
        });
    }

    private void pagination(GridLayoutManager gridLayoutManager) {

        binding.recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollistener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                if (resultList.size() > filterArray.size()) {
                    ArrayList<SearchModel.Result> arrayList;
                    if (resultList.size() >= filterArray.size() + 20) {
                        arrayList = new ArrayList<>(resultList.subList(filterArray.size(), filterArray.size() + 20));
                    }else {
                        arrayList = new ArrayList<>(resultList.subList(filterArray.size(), resultList.size()));
                    }
                    for (int i = 0; i < arrayList.size(); i++) {
                        listAdapters.add(arrayList.get(i));
                    }
                }


            }
        });
    }
}