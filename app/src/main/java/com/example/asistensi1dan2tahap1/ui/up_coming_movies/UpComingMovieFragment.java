package com.example.asistensi1dan2tahap1.ui.up_coming_movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.asistensi1dan2tahap1.R;
import com.example.asistensi1dan2tahap1.adapters.UpComingMovieAdapter;
import com.example.asistensi1dan2tahap1.models.Movie;
import com.example.asistensi1dan2tahap1.models.Star;
import com.example.asistensi1dan2tahap1.ui.movies.MovieDetailActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class UpComingMovieFragment extends Fragment {

    private UpComingMovieViewModel mViewModel;
    private ListView LSUpComing;
    public static UpComingMovieFragment newInstance() {
        return new UpComingMovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#303960")));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>ProfileFragment</font>"));
        View root =  inflater.inflate(R.layout.fragment_up_coming_movie, container, false);
        LSUpComing = (ListView) root.findViewById(R.id.LS_UpComing);

        ArrayList upComingList = getDataUpComing();

        UpComingMovieAdapter upComingMovieAdapter = new UpComingMovieAdapter(getContext(), upComingList);
        LSUpComing.setAdapter(upComingMovieAdapter);
        LSUpComing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Movie movie = (Movie) LSUpComing.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable) movie.getStar());
                intent.putExtra("title",movie.getTitle());
                intent.putExtra("producers",movie.getProducer());
                intent.putExtra("directors",movie.getDirector());
                intent.putExtra("writers",movie.getWriter());
                intent.putExtra("genres",movie.getGenre());
                intent.putExtra("duration",movie.getMin());
                intent.putExtra("release",movie.getPlay());
                intent.putExtra("rating",movie.getRating());
                intent.putExtra("studio",movie.getStudio());
                intent.putExtra("BUNDLE",args);
                intent.putExtra("streaminglink",movie.getStreamingLink());
                intent.putExtra("description",movie.getDescription());

                intent.putExtra("imgURL",movie.getThumbnail());
                intent.putExtra("imgCover",movie.getThumbnail());

                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UpComingMovieViewModel.class);
        // TODO: Use the ViewModel
    }

    private ArrayList getDataUpComing(){
        ArrayList<Movie> result = new ArrayList<>();
        ArrayList<Star> stars = new ArrayList<>();

        stars.add(new Star(R.drawable.pak_eriktohir, "erik tohir", "Poppy"));
        stars.add(new Star(R.drawable.pak_sby, "susilo bambang yudoyono", "Branch"));
        stars.add(new Star(R.drawable.pak_eriktohir, "erik tohir", "Bloom"));
        stars.add(new Star(R.drawable.pak_sby, "susilo bambang yudoyono", "Kelly"));
        stars.add(new Star(R.drawable.pak_eriktohir, "erik tohir", "James"));

        result.add(new Movie("zee studio", R.drawable.india_1,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "181 Menit", "Action, Adventure, Drama ", "Gina Shay", "Anthony Russo, Joe Russo","Christopher Markus", "Robert Downey Jr., Chris Evans, Mark Ruffalo ", "26 April 2019 (USA)","8.4/10" ,"Marvel Studio", "https://www.youtube.com/watch?v=yP86-TR6IME" ,stars));

        result.add(new Movie("Fashion tv", R.drawable.india_2,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "119 Menit", "Drama, War", "Sam Mendes", "Sam Mendes","Sam Mendes, Krysty Wilson-Cairns", "Dean-Charles Chapman, George MacKay, Daniel Mays", "10 January 2020 (USA)","8.3/10" ,"Neil Soans", "https://www.youtube.com/watch?v=yP86-TR6IME" ,stars));

        result.add(new Movie("googd times tv ", R.drawable.india_3,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "140 Menit", "Biography, Crime, Drama", "Sam Mendes", "Michael Mann, Kevin Misher","Ronan Bennett ", "Christian Bale, Johnny Depp, Christian Stolte", "1 July 2009 (USA)","7.0/10" ,"Relative Media", "https://www.youtube.com/watch?v=Q8xOgO7_eT8" ,stars));

        result.add(new Movie("Saluran 1", R.drawable.saluran_1,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "119", "Adventure, Family, Fantasy", "Joe Roth, Angelina Jolie", "Joachim Rønning","Linda Woolverton, Noah Harpster", "Angelina Jolie, Elle Fanning, Harris Dickinson", "18 October 2019 (USA)","7.0/10" ,"Walt Disney Pictures", "https://www.youtube.com/watch?v=n0OFH4xpPr4" ,stars));

        result.add(new Movie("Saluran 2 ", R.drawable.saluran_2,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "148 Menit", "Drama, Horror, Mystery", "Patrik Andersson", "Ari Aster","Ari Aster", "Florence Pugh, Jack Reynor, Vilhelm Blomgren", "3 July 2019 (USA)","7.0/10" ,"Square Peg", "https://www.youtube.com/watch?v=1Vnghdsjmd0" ,stars));

        result.add(new Movie("Saluran 3 ", R.drawable.saluran_3,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "90 Menit", "Animation, Action, Sci-Fi", "Patrik Andersson", "Matt Peters","Ernie Altbacker", "Roger Cross, Rosario Dawson, Christopher Gorham", "5 May 2020","7.9/10" ,"DC Animation", "https://www.youtube.com/watch?v=tnCkn5xD2jg" ,stars));

        result.add(new Movie("Saluran 4", R.drawable.saluran_4,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "120 Menit", "Animation, Adventure, Comedy", "Gina Shay", "Walter Dohrn","Jonathan Aibel, Glenn Berger", "Anna Kendrick, Justin Timberlake, Rachel Bloom", "April","-" ,"Universal Pictures", "https://www.youtube.com/watch?v=yP86-TR6IME" ,stars));

        result.add(new Movie("Saluran 5", R.drawable.saluran_1,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "110 Menit", "Comedy", "Suzanne Todd", "Jon Lucas, Scott Moore","Jon Lucas, Scott Moore", "Adam Devine, Rose Byrne, Alexandra Shipp", "Oktober","-" ,"Entertaiment One", "https://www.youtube.com/watch?v=txSOaY-je-o" ,stars));

        result.add(new Movie("Saluran 6", R.drawable.saluran_2,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "126 Menit", "Comedy, Romance", "Gope T Samtani, Sunil Samtani", "Chandra Liow","Jovial da Lopez", "Andovi da Lopez, Jovial da Lopez, Tommy Limmm", "Maret","-" ,"Rapi Films", "https://www.youtube.com/watch?v=xSdAC9WSJ5s" ,stars));

        result.add(new Movie("Saluran 7", R.drawable.saluran_3,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "110 Menit", "Romance", "Agus Basuki, Ody Mulya Hidayat", "Eddy Prasetya","Nana Mulyana, Media Kita", "Salshabilla Andriani, Endi Arfian, H. Mahyeldi SP", "April","-" ,"MAX Pictures", "https://www.youtube.com/watch?v=KGXTYsZE5Vo" ,stars));

        result.add(new Movie("Saluran 8", R.drawable.saluran_4,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "155 Menit", "Drama, Music, Romance", "Kevin Downes, Andrew Erwin", "Andrew Erwin, Jon Erwin","Jon Erwin, Jon Gunn", "K.J. Apa, Britt Robertson, Abigail Cowen", "Maret","6.5/10" ,"Lionsgate", "https://www.youtube.com/watch?v=YnxHyBbYwQQ" ,stars));

        result.add(new Movie("Saluran 9", R.drawable.saluran_1,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "197 menit", "Horror, Thriller", "Allen Liu, Tom Waller", "Tom Waller","Tom Waller", "Maythavee Burapasing, Ron Smoorenburg, Kelly B. Jones", "Maret","5.1/10" ,"De Warrenner Picture", "https://www.youtube.com/watch?v=GloDhxD_bbc" ,stars));

        result.add(new Movie("Saluran 10", R.drawable.saluran_2,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "130 Menit", "Drama, Religious", "Chand Parwez Servia, Fiaz Servia", "Archie Hekagery","Archie Hekagery", "Panji Zoni, Yayan Ruhiyan, Maizura, Cemal Faruk", "December 31, 2020","-" ,"Starvision", "https://www.youtube.com/watch?v=V48qhATHklc" ,stars));

        result.add(new Movie("Saluran 11", R.drawable.saluran_3,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "187 Menit", "Horror, Drama", "Nona Quiliem, Ekadi Katili", "Ekadi Katili","Beni Susanto", "Iqbal Perdana, Yulinar Arief, Aga Dirgantara", "April 16, 2020","-" ,"Cinekadi Pictures", "https://www.youtube.com/watch?v=6CNbITLDWos" ,stars));

        result.add(new Movie("Saluran 12", R.drawable.saluran_4,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "187 Menit", "Action, Comedy, Family", "Dave Bautista, Chris Bender", "Peter Segal","Erich Hoeber, Jon Hoeber", "Dave Bautista, Kristen Schaal, Parisa Fitz-Henley", "January 9, 2020","6.2/10" ,"MWM Studios", "https://www.youtube.com/watch?v=imMQskUW_Ik" ,stars));

        result.add(new Movie("Saluran 13", R.drawable.saluran_1,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "187 Menit", "Drama, Comedy", "Partono Wiraputra, Andi Arsyil Rahman, Santi Muzhar", "Irham Acho Bahtiar","Ferdy. K, Andi Arsyil Rahman", "Andi Arsyil, Arlita Reggiana, Alexa Key", "March 19, 2020","-" ,"Moov Pictures", "https://www.youtube.com/watch?v=1zb64S1bF_U" ,stars));

        result.add(new Movie("Saluran 14", R.drawable.saluran_2,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "168 Menit", "Drama, Comedy, Horror", "dr Robby Hilman, Budi Yulianto, Cut Puti, M Rizky", "Sahrul Gibran","Fajar Umbara, Isman H", "Joe P Project, Fico Fahreza, Aming, Ben Kasyafani", "March 26, 2020","-" ,"MBK Pictures", "https://www.youtube.com/watch?v=D-Un3p637js" ,stars));

        result.add(new Movie("Saluran 15", R.drawable.saluran_3,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "177", "Horror, Action", "Unchu Viejay", "Adi Garing","Agus Noor Ismail", "Arnold Leonard, Dea Annisa, Gabriella Larasati", "March 26, 2020","-" ,"Super Media Pictures", "https://www.youtube.com/watch?v=5Hl6isbAW24" ,stars));

        result.add(new Movie("Saluran 16", R.drawable.saluran_4,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "147 Menit", "Action, Thriller", "Randall Emmett, George Furla, Luillo Ruiz, Mark Stewart", "Matt Eskandari","Paul Da Silva", "Bruce Willis, Nicky Whelan, Steve Guttenberg", "December 6, 2019","5/10" ,"Highland Film Group", "https://www.youtube.com/watch?v=1gUR-WRVf6U" ,stars));

        result.add(new Movie("Saluran 17", R.drawable.saluran_1,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "133 Menit", "Action, Crime, Drama", "Mary Aloe, Craig Chapman, Myles Nestel", "Malik Bader","Malik Bader", "Liam Hemsworth, Emory Cohen, Diane Guerrero", "August 8, 2019","5.6/10" ,"Solution Entertainment Group", "https://www.youtube.com/watch?v=i5niXDUtGEM" ,stars));

        result.add(new Movie("Saluran 18", R.drawable.saluran_2,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "87 Menit", "Horror, Fantasy", "Brian Kavanaugh Jones, Fred Berger", "Osgood Perkins","Rob Hayes", "Sophia Lillis, Sammy Leakey, Charles Babalola", "August 8, 2019","5.3/10" ,"Orion Pictures", "https://www.youtube.com/watch?v=6ZgkHjpUM8w" ,stars));

        result.add(new Movie("Saluran 19", R.drawable.saluran_3,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "87 Menit", "Drama, Music", "Fred Berger", "Max Minghella","Max Minghella", "Elle Fanning, Rebecca Hall, Agnieszka Grochowska", "June 20, 2019","6.1/10" ,"Elevation Pictures", "https://www.youtube.com/watch?v=CkA6DpQEKTU" ,stars));

        result.add(new Movie("Saluran 20", R.drawable.saluran_4,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "106 Menit", "Crime, Drama", "Focus Feature", "Miranda July","Miranda July", "Evan Rachel Wood, Debra Winger, Gina Rodriguez", "18 September 2020 (USA)","5.8/10" ,"Plan B Entertaiment", "https://www.youtube.com/watch?v=bN25v1US0h8" ,stars));

        result.add(new Movie("Saluran 21", R.drawable.saluran_1,R.drawable.spidercover,R.string.synopsisTrollsWorldTour, "-", "Thriller", "Andrew Gunn, Mark Gill, Lisa Ellzey", "Derrick Borte","Carl Ellsworth", "Russell Crowe, Jimmi Simpson, Caren Pistorius", "1 July 2020 (USA)","-" ,"Ingenious Media", "https://www.youtube.com/watch?v=vdxDXoODKN8" ,stars));

        return result;
    }

}
