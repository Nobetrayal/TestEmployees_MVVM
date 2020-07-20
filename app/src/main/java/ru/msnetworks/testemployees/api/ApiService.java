package ru.msnetworks.testemployees.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import ru.msnetworks.testemployees.pojo.EmployeeResponse;

public interface ApiService {

    @GET("testTask.json")
    Observable<EmployeeResponse> getEmployees();

}
