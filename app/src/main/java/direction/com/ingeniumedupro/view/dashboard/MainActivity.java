package direction.com.ingeniumedupro.view.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

import direction.com.ingeniumedupro.api.ApiClient;
import direction.com.ingeniumedupro.api.ApiInterface;
import direction.com.ingeniumedupro.R;
import direction.com.ingeniumedupro.adapter.EmployeeAdapter;
import direction.com.ingeniumedupro.model.EmployeeDataModel;
import direction.com.ingeniumedupro.model.EmployeeModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EmployeeModel employeeModel;
    List<EmployeeDataModel> employeeDataModelList;
    RecyclerView recyclerView;
    EmployeeAdapter employeeAdapter;
    TextView tvNoData;
    LottieAnimationView animationProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeDataModelList = new ArrayList<>();

        initView();

        getAllDetails();

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rvAllDetails);
        tvNoData = (TextView) findViewById(R.id.tvNoData);
        animationProgress = (LottieAnimationView) findViewById(R.id.animationProgress);
    }

    private void getAllDetails() {
        animationProgress.setVisibility(View.VISIBLE);
        animationProgress.playAnimation();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<EmployeeModel> call = apiService.getEmployeeDetails();

        call.enqueue(new Callback<EmployeeModel>() {
            @Override
            public void onResponse(Call<EmployeeModel> call, Response<EmployeeModel> response) {
                employeeModel = (EmployeeModel) response.body();
                employeeDataModelList = employeeModel.getData();

                animationProgress.cancelAnimation();
                animationProgress.setVisibility(View.GONE);

                if (!employeeDataModelList.isEmpty()) {
                    recyclerView.setVisibility(View.VISIBLE);
                    tvNoData.setVisibility(View.GONE);

                    LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    employeeAdapter = new EmployeeAdapter(MainActivity.this, employeeDataModelList);
                    recyclerView.setAdapter(employeeAdapter);
                } else {
                    recyclerView.setVisibility(View.GONE);
                    tvNoData.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<EmployeeModel> call, Throwable t) {
                animationProgress.cancelAnimation();
                animationProgress.setVisibility(View.GONE);

                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}