package aula09.ex3;

import java.util.*;

public class PlaneManager {
    Collection<Plane> aircraftFleet = new HashSet<>();


    // Public Methods

    public void addPlane(Plane plane){
        aircraftFleet.add(plane);
    }

    public void removePlane(String id){
        aircraftFleet.removeIf(plane -> plane.getId().equals(id));
    }

    public Plane searchPlane(String id){
        for(Plane plane : aircraftFleet){
            if(plane.getId().equals(id)) return plane;
        }
        return null;
    }

    public Collection<CommercialPlane> getCommercialPlanes(){
        Collection<CommercialPlane> commercialPlanes = new HashSet<>();
        for(Plane plane : aircraftFleet){
            if(plane instanceof CommercialPlane) commercialPlanes.add((CommercialPlane) plane);
        }
        return commercialPlanes;
    }

    public Collection<MilitaryPlane> getMilitaryPlanes(){
        Collection<MilitaryPlane> militaryPlanes = new HashSet<>();
        for(Plane plane : aircraftFleet){
            if(plane instanceof MilitaryPlane) militaryPlanes.add((MilitaryPlane) plane);
        }
        return militaryPlanes;
    }

    public void printAllPlanes(String print){
        System.out.println();
        System.out.println("------ "+ print +" ------");
        for(Plane plane : aircraftFleet)
            System.out.println(plane);
        System.out.println("----------------------------");
    }

    public Plane getFastestPlane(){
        Plane fast = null;
        for(Plane plane : aircraftFleet){
            if(fast == null || fast.getMaxSpeed() < plane.getMaxSpeed()) fast = plane;
        }
        return fast;
    }
}
