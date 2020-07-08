package direction.com.ingeniumedupro.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class EmployeeModel implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<EmployeeDataModel> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeModel withStatus(String status) {
        this.status = status;
        return this;
    }

    public List<EmployeeDataModel> getData() {
        return data;
    }

    public void setData(List<EmployeeDataModel> data) {
        this.data = data;
    }

    public EmployeeModel withData(List<EmployeeDataModel> data) {
        this.data = data;
        return this;
    }
}
