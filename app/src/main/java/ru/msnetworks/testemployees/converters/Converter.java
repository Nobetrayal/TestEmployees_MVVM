package ru.msnetworks.testemployees.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ru.msnetworks.testemployees.pojo.Speciality;

public class Converter {

    @TypeConverter
    public String listSpecialityToString(List<Speciality> specialities) {

        return new Gson().toJson(specialities);

    }

    @TypeConverter
    public List<Speciality> stringToListSpeciality(String specialityAsString) {

        Gson gson = new Gson();
        List objects = gson.fromJson(specialityAsString, List.class);
        List<Speciality> specialities = new ArrayList<>();

        for (Object o : objects) {

            specialities.add(gson.fromJson(o.toString(), Speciality.class));

        }
        return specialities;
    }

}
