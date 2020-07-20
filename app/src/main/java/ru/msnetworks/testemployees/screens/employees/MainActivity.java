package ru.msnetworks.testemployees.screens.employees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ru.msnetworks.testemployees.R;
import ru.msnetworks.testemployees.adapters.EmployeeAdapter;
import ru.msnetworks.testemployees.api.ApiFactory;
import ru.msnetworks.testemployees.api.ApiService;
import ru.msnetworks.testemployees.pojo.Employee;
import ru.msnetworks.testemployees.pojo.EmployeeResponse;

public class MainActivity extends AppCompatActivity implements EmployeesListView{

    private RecyclerView recyclerViewEmployees;
    private EmployeeAdapter adapter;
    private EmployeeListPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new EmployeeListPresenter(this);

        recyclerViewEmployees = findViewById(R.id.recyclerViewEmployees);

        adapter = new EmployeeAdapter();
        adapter.setEmployees(new ArrayList<Employee>());
        recyclerViewEmployees.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewEmployees.setAdapter(adapter);
        presenter.loadData();

    }

    public void showData(List<Employee> employees) {

        adapter.setEmployees(employees);
    }

    public void showError(Throwable throwable) {

        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        presenter.disposeDisposable();
        super.onDestroy();


    }
}