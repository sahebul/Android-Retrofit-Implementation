package getnow.com.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import getnow.com.retrofit.data.model.LoginData;
import getnow.com.retrofit.data.model.Post;
import getnow.com.retrofit.data.model.test;
import getnow.com.retrofit.data.remote.RetrofitClient.APIService;
import getnow.com.retrofit.data.remote.RetrofitClient.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mResponseTv;
    private APIService mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText titleEt = (EditText) findViewById(R.id.et_title);
        final EditText bodyEt = (EditText) findViewById(R.id.et_body);
        Button submitBtn = (Button) findViewById(R.id.btn_submit);
        mResponseTv = (TextView) findViewById(R.id.tv_response);

        mAPIService = ApiUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEt.getText().toString().trim();
                String body = bodyEt.getText().toString().trim();
                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                    sendPost(title, body);
                }
            }
        });
    }

    public void sendPost(String title, String body) {
        mAPIService.savePost(title, body).enqueue(new Callback<test>() {
            @Override
            public void onResponse(Call<test> call, Response<test> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_LONG).show();
                    //showResponse(response.body().toString());
                  //  Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<test> call, Throwable t) {
                //Log.e(TAG, "Unable to submit post to API.");
                Toast.makeText(getBaseContext(), "something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }
}
