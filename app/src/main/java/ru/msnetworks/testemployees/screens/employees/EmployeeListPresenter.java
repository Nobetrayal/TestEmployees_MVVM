package ru.msnetworks.testemployees.screens.employees;

import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ru.msnetworks.testemployees.api.ApiFactory;
import ru.msnetworks.testemployees.api.ApiService;
import ru.msnetworks.testemployees.pojo.EmployeeResponse;

public class EmployeeListPresenter {

    private Disposable disposable;
    private EmployeesListView view;

    public EmployeeListPresenter(EmployeesListView view) {
        this.view = view;
    }

    public void loadData() {

        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        disposable = apiService.getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EmployeeResponse>() {
                    @Override
                    public void accept(EmployeeResponse employeeResponse) throws Exception {
                        view.showData(employeeResponse.getResponse());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.showError(throwable);
                    }
                });

    }

    public void disposeDisposable() {
        if (disposable != null) {
            disposable.dispose();
        }
    }

}
