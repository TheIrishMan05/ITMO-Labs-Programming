package Locations;

import Entities.Snufkin;
import Enums.Weather;
import Interfaces.ILocation;

public class Street implements ILocation {

    @Override
    public void describe() {
        System.out.println("На улице " + (Math.random() >= 0.5 ? Weather.SUNNY : Weather.RAINY) + ".");
    }

    public void doActivities(Snufkin snufkin, House.Door door) {
        this.describe();
        snufkin.knock(door);
    }

}
