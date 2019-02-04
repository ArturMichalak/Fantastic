package arturmichalak.fantastic;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import arturmichalak.fantastic.http.DTO.FakeDTO;
import arturmichalak.fantastic.http.HttpClient;
import arturmichalak.fantastic.http.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


        Test service = HttpClient.getInstance("https://jsonplaceholder.typicode.com/").create(Test.class);
        Call<List<FakeDTO>> call = service.fetchFake();
        call.enqueue(new Callback<List<FakeDTO>>() {
            @Override
            public void onResponse(Call<List<FakeDTO>> call, Response<List<FakeDTO>> response) {
                progressDoalog.dismiss();
                ((TextView) findViewById(R.id.hello)).setText(response.body().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<List<FakeDTO>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
