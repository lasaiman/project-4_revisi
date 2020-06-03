package com.example.asistensi1dan2tahap1.ui.tv_shows;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.asistensi1dan2tahap1.R;
import com.example.asistensi1dan2tahap1.adapters.TVShowAdapter;
import com.example.asistensi1dan2tahap1.models.Star;
import com.example.asistensi1dan2tahap1.models.TVShow;

import java.io.Serializable;
import java.util.ArrayList;

public class TVShowsActivity extends AppCompatActivity {
    private ListView LSTVShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows);
        LSTVShow = (ListView) findViewById(R.id.LS_TVShow);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#303960")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Semua TV Show</font>"));
        getSupportActionBar().setElevation(0);
        initDataTVShows();
    }

    private void initDataTVShows(){

        ArrayList allTVShow = getDataTVShow();

        TVShowAdapter TVShowMovieAdapter = new TVShowAdapter(this, allTVShow);
        LSTVShow.setAdapter(TVShowMovieAdapter);
        LSTVShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                TVShow tvshow = (TVShow) LSTVShow.getItemAtPosition(position);
                Intent intent = new Intent(TVShowsActivity.this, TVShowDetailActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable) tvshow.getStar());
                intent.putExtra("title",tvshow.getTitle());
                intent.putExtra("creator",tvshow.getCreator());
                intent.putExtra("genres",tvshow.getGenre());
                intent.putExtra("duration",tvshow.getMin());
                intent.putExtra("release",tvshow.getPlay());
                intent.putExtra("rating",tvshow.getRating());
                intent.putExtra("studio",tvshow.getStudio());
                intent.putExtra("season",tvshow.getSeason());
                intent.putExtra("episode",tvshow.getEpisode());
                intent.putExtra("BUNDLE",args);
                intent.putExtra("streaminglink",tvshow.getStreamingLink());
                intent.putExtra("description",tvshow.getDescription());
                intent.putExtra("imgURL",tvshow.getThumbnail());
                intent.putExtra("imgCover",tvshow.getThumbnail());
                startActivity(intent);
            }
        });

    }

    private ArrayList getDataTVShow(){
        ArrayList<TVShow> result = new ArrayList<>();

        ArrayList<Star> stars = new ArrayList<>();

        stars.add(new Star(R.drawable.pak_eriktohir, "erik tohir", "Poppy"));
        stars.add(new Star(R.drawable.pak_sby, "susilo bambang yudoyono", "Branch"));
        stars.add(new Star(R.drawable.pak_eriktohir, "erik tohir", "Bloom"));
        stars.add(new Star(R.drawable.pak_sby, "susilo bambang yudoyono", "Kelly"));
        stars.add(new Star(R.drawable.pak_eriktohir, "erik tohir", "James"));

        result.add(new TVShow("Saluran 1 ", R.string.synopsisTrollsWorldTour, R.drawable.saluran_1, R.drawable.saluran_1, "9.5/10", "https://www.youtube.com/watch?v=c8aFcHFu8QM", "320 Menit / Episode", "Documentary", "David Attenborough", "TV Mini-Series (2016)", "BBC","David Attenborough", 6, 1, stars));

        result.add(new TVShow("Saluran 2 ", R.string.synopsisTrollsWorldTour, R.drawable.saluran_2, R.drawable.saluran_2, "9.4/10", "https://www.youtube.com/watch?v=c8aFcHFu8QM", "538 Menit / Episode", "Documentary", "David Attenborough", "TV Mini-Series (2006)", "BBC","David Attenborough, Sigourney Weaver, Thomas Anguti Johnston |", 12, 1, stars));

        result.add(new TVShow("Saluran 3  ", R.string.synopsisTrollsWorldTour, R.drawable.saluran_3, R.drawable.saluran_3, "9.4/10", "https://www.youtube.com/watch?v=aH06LWZs-Ys", "54 Menit / Episode", "Action, Drama, History", "Tom Hanks", "TV Mini-Series (2001)", "BBC","Scott Grimes, Damian Lewis, Ron Livingston", 10, 1, stars));

        result.add(new TVShow("Saluran 4  ", R.string.synopsisTrollsWorldTour, R.drawable.saluran_4, R.drawable.saluran_4, "9.5/10", "https://www.youtube.com/watch?v=HhesaQXLuRY", "49 Menit / Episode", "Crime, Drama, Thriller", "Vince Gilligan", "TV Series (2008–2013)", "AMC","Bryan Cranston, Aaron Paul, Anna Gunn", 62, 5, stars));

        result.add(new TVShow("Saluran 5 ", R.string.synopsisTrollsWorldTour, R.drawable.saluran_1, R.drawable.saluran_1, "9.4/10", "https://www.youtube.com/watch?v=HhesaQXLuRY", "49 Menit / Episode", "Drama, History, Thriller", "Craig Mazin", "TV Mini-Series (2019)", "AMC","Jessie Buckley, Jared Harris, Stellan Skarsgård", 5, 1, stars));

        result.add(new TVShow("Saluran 6", R.string.synopsisTrollsWorldTour, R.drawable.saluran_2, R.drawable.saluran_2, "9.3/10", "https://www.youtube.com/watch?v=9qK-VGjMr8g", "364 Menit / Episode", "Documentary", "David Simon", "TV Mini-Series (2017–2018)", "HBO","David Attenborough, Peter Drost, Roger Munns", 60, 5, stars));

        result.add(new TVShow("Saluran 7", R.string.synopsisTrollsWorldTour, R.drawable.saluran_3, R.drawable.saluran_3, "9.3/10", "https://www.youtube.com/watch?v=9qK-VGjMr8g", "364 Menit / Episode", "Documentary", "David Simon", "TV Mini-Series (2017–2018)", "HBO","David Attenborough, Peter Drost, Roger Munns", 60, 5, stars));

        result.add(new TVShow("saluran 8", R.string.synopsisTrollsWorldTour, R.drawable.saluran_4, R.drawable.saluran_4, "9.3/10", "https://www.youtube.com/watch?v=9qK-VGjMr8g", "364 Menit / Episode", "Documentary", "David Simon", "TV Mini-Series (2017–2018)", "HBO","David Attenborough, Peter Drost, Roger Munns", 60, 5, stars));

        result.add(new TVShow("Saluran 9", R.string.synopsisTrollsWorldTour, R.drawable.saluran_1, R.drawable.saluran_1, "9.3/10", "https://www.youtube.com/watch?v=9qK-VGjMr8g", "364 Menit / Episode", "Documentary", "David Simon", "TV Mini-Series (2017–2018)", "HBO","David Attenborough, Peter Drost, Roger Munns", 60, 5, stars));

        result.add(new TVShow("Saluran 10", R.string.synopsisTrollsWorldTour, R.drawable.saluran_2, R.drawable.saluran_2, "9.3/10", "https://www.youtube.com/watch?v=9qK-VGjMr8g", "364 Menit / Episode", "Documentary", "David Simon", "TV Mini-Series (2017–2018)", "HBO","David Attenborough, Peter Drost, Roger Munns", 60, 5, stars));

        return result;
    }
}
