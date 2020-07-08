package direction.com.ingeniumedupro.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import direction.com.ingeniumedupro.R;
import direction.com.ingeniumedupro.model.EmployeeDataModel;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {

    Context context;
    private List<EmployeeDataModel> employeeDataModelList;

    public EmployeeAdapter(Context context, List<EmployeeDataModel> employeeDataModelList) {
        this.context = context;
        this.employeeDataModelList = employeeDataModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_list_emp, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rootView.setLayoutParams(lp);
        return new MyViewHolder(rootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (!employeeDataModelList.isEmpty()) {

            if(!employeeDataModelList.get(position).getProfileImage().isEmpty()) {
                Picasso.get().load(employeeDataModelList.get(position).getProfileImage())
                        .into(holder.imgEmp);
            }else {
                Picasso.get().load(R.drawable.user_img)
                        .into(holder.imgEmp);
            }

            if (!employeeDataModelList.get(position).getEmployeeName().isEmpty()) {
                holder.tvEmpName.setText("" + employeeDataModelList.get(position).getEmployeeName());
            } else {
                holder.tvEmpName.setText("No data");
            }

            if (!employeeDataModelList.get(position).getEmployeeAge().isEmpty()) {
                holder.tvEmpAge.setText("" + employeeDataModelList.get(position).getEmployeeAge());
            } else {
                holder.tvEmpAge.setText("No data");
            }

            if (!employeeDataModelList.get(position).getEmployeeSalary().isEmpty()) {
                holder.tvEmpSalary.setText("\u20B9 " + employeeDataModelList.get(position).getEmployeeSalary());
            } else {
                holder.tvEmpSalary.setText("No data");
            }
        }
    }

    @Override
    public int getItemCount() {
        if(employeeDataModelList != null){
            return employeeDataModelList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView imgEmp;
        public AppCompatTextView tvEmpName;
        public AppCompatTextView tvEmpSalary;
        public AppCompatTextView tvEmpAge;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgEmp = itemView.findViewById(R.id.imgEmp);
            tvEmpName = itemView.findViewById(R.id.tvEmpNameValue);
            tvEmpSalary = itemView.findViewById(R.id.tvEmpSalaryValue);
            tvEmpAge = itemView.findViewById(R.id.tvEmpAgeValue);
        }
    }
}
