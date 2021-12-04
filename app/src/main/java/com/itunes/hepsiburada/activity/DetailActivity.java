package com.itunes.hepsiburada.activity;

import android.app.Activity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.itunes.hepsiburada.databinding.ActivityDetailBinding;
import com.itunes.hepsiburada.model.SearchModel;

public class DetailActivity extends Activity {

    ActivityDetailBinding binding;
    SearchModel.Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        result = (SearchModel.Result) getIntent().getExtras().getSerializable("result");

        if (result != null) {
            Glide.with(DetailActivity.this).load(result.getArtworkUrl100()).into(binding.detailImage);
            binding.txtType.setText(result.getWrapperType());
            binding.txtArtistName.setText(result.getArtistName());
            binding.txtCollectionName.setText(result.getCollectionName());
            binding.txtTrackName.setText(result.getPrimaryGenreName());
        }

    }
}
