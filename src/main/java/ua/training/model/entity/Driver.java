package ua.training.model.entity;

import ua.training.model.enumForEntity.CategoryRights;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Driver
 * <p>
 * Description: This is the entity for data from DataBase
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class Driver {
    private int id;
    private String name;
    private String surname;
    private int age;
    private CategoryRights[] rights;
    private double workExperience;
    private String rightsNumber;

    public Driver(int id, String name, String surname, int age, CategoryRights[] rights, double workExperience, String rightsNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.rights = rights;
        this.workExperience = workExperience;
        this.rightsNumber = rightsNumber;
    }

    public Driver(ResultSet resultSet) {
        try {
            this.id = (resultSet.getInt("id"));
            this.name = (resultSet.getString("name"));
            this.surname = (resultSet.getString("surname"));
            this.age = (resultSet.getInt("age"));
            this.rights = (getArraysOfRigths(resultSet.getString("rights")));
            this.workExperience = (resultSet.getDouble("workExperience"));
            this.rightsNumber = (resultSet.getString("rightsNumber"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Driver() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CategoryRights[] getRights() {
        return rights;
    }

    public void setRights(CategoryRights[] rights) {
        this.rights = rights;
    }

    public double getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(double workExperience) {
        this.workExperience = workExperience;
    }

    public String getRightsNumber() {
        return rightsNumber;
    }

    public void setRightsNumber(String rightsNumber) {
        this.rightsNumber = rightsNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private CategoryRights[] getArraysOfRigths(String str) {
        String array[] = str.split("[;]");

        CategoryRights[] rights = new CategoryRights[array.length];

        for (int i = 0; i < array.length; i++) {
            rights[i] = CategoryRights.valueOf(array[i]);
        }

        return rights;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", rights=" + Arrays.toString(rights) +
                ", workExperience=" + workExperience +
                ", rightsNumber='" + rightsNumber + '\'' +
                '}';
    }
}
