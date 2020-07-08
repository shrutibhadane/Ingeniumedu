package direction.com.ingeniumedupro.api;

import direction.com.ingeniumedupro.model.EmployeeModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("employees")
    Call<EmployeeModel> getEmployeeDetails();
}

