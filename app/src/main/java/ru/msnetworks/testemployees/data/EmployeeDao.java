package ru.msnetworks.testemployees.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ru.msnetworks.testemployees.pojo.Employee;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employees")
    LiveData<List<Employee>> getAllEmployees();

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertEmployees(List<Employee> employees);

    @Query("DELETE FROM employees")
    void deleteAllEmployees();

}
