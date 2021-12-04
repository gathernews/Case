package com.itunes.hepsiburada.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.itunes.hepsiburada.R;
import com.itunes.hepsiburada.activity.DetailActivity;
import com.itunes.hepsiburada.model.SearchModel;
import com.itunes.hepsiburada.util.WImageView;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ListAdapter extends RecyclerView.Adapter {

    List<SearchModel.Result> resultList;
    Activity context;
    private LayoutInflater inflater;


    public ListAdapter(Activity activity, List<SearchModel.Result> result) {
        this.context = activity;
        this.resultList = result;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_search, parent, false);
        return new ViewHolder(v);
    }

    public void add(SearchModel.Result obj) {
        resultList.add(obj);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SearchModel.Result result = resultList.get(position);

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.setItems(result);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txt_header, txt_title, txt_date;
        public WImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_date = (TextView) itemView.findViewById(R.id.txt_date);
            txt_header = (TextView) itemView.findViewById(R.id.txt_header);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            imageView = (WImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }

        void setItems(SearchModel.Result result) {

            if ( result.getWrapperType()!=null){
                Log.e("wrapperType", result.getWrapperType());
            }

            NumberFormat format = NumberFormat.getCurrencyInstance();
            if (result.getCollectionPrice() != null) {
                txt_title.setText(format.format(result.getCollectionPrice()));
            }


            String dtStart = result.getReleaseDate();
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            try {
                Date date = formatDate.parse(dtStart);
                System.out.println(date);
                txt_date.setText(date.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }


            txt_header.setText(result.getCollectionName());


            Glide.with(context).load(result.getArtworkUrl100()).into(imageView);


            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, DetailActivity.class);
                    i.putExtra("result", result);
                    context.startActivity(i);
                }
            });
        }
    }
}
