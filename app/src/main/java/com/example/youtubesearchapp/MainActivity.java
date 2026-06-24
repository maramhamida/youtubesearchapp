package com.example.youtubesearchapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.button.MaterialButton;
import android.widget.ProgressBar;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etSearchQuery;
    private MaterialButton btnSearch;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private VideoAdapter adapter;

    private static final String API_KEY = "AIzaSyBLJESBCoWj_L7fspz2qhWTH23--63vPVk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearchQuery = findViewById(R.id.etSearchQuery);
        btnSearch = findViewById(R.id.btnSearch);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);

        // 2. إعداد طريقة عرض القائمة (بشكل عمودي)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = etSearchQuery.getText().toString().trim();

                if (query.isEmpty()) {
                    Toast.makeText(MainActivity.this, "الرجاء إدخال كلمة للبحث", Toast.LENGTH_SHORT).show();
                } else {
                    searchVideos(query);
                }
            }
        });
    }

    private void searchVideos(String query) {

        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);


        YouTubeApiService apiService = RetrofitClient.getClient().create(YouTubeApiService.class);


        Call<youtuberesponse> call = apiService.searchVideos(query, 15, API_KEY);


        call.enqueue(new Callback<youtuberesponse>() {
            @Override
            public void onResponse(Call<youtuberesponse> call, Response<youtuberesponse> response) {

                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null) {
                    List<youtuberesponse.VideoItem> videos = response.body().getItems();


                    if (videos != null && !videos.isEmpty()) {
                        adapter = new VideoAdapter(MainActivity.this, videos);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(MainActivity.this, "لا توجد نتائج لهذا البحث", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "حدث خطأ، كود الرفض: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<youtuberesponse> call, Throwable t) {

                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "فشل الاتصال بالإنترنت. تأكد من الشبكة.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}