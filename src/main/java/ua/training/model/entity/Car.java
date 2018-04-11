package ua.training.model.entity;

import ua.training.model.enumForEntity.CarBrand;
import ua.training.model.enumForEntity.CarClass;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Car
 * <p>
 * Description: This is the entity for data from DataBase
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class Car {
    private int id;
    private CarBrand carBrand;
    private String mark;
    private int price;
    private CarClass carClass;
    private double power;
    private double fuelConsumption;
    private String carNumber;

    public Car(int id, CarBrand carBrand, String mark, int price, CarClass carClass, double power, double fuelConsumption, String carNumber) {
        this.id = id;
        this.carBrand = carBrand;
        this.mark = mark;
        this.price = price;
        this.carClass = carClass;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.carNumber = carNumber;
    }

    public Car(ResultSet resultSet) {
        try {
            this.id = (resultSet.getInt("id"));
            this.carBrand = (CarBrand.valueOf(resultSet.getString("carBrand")));
            this.mark = (resultSet.getString("mark"));
            this.price = (resultSet.getInt("price"));
            this.carClass = (CarClass.valueOf(resultSet.getString("carClass")));
            this.power = (resultSet.getDouble("power"));
            this.fuelConsumption = (resultSet.getDouble("fuelConsumption"));
            this.carNumber = (resultSet.getString("carNumber"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand=" + carBrand +
                ", mark='" + mark + '\'' +
                ", price=" + price +
                ", carClass=" + carClass +
                ", power=" + power +
                ", fuelConsumption=" + fuelConsumption +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}
