package aula05.ex3;

import aula05.ex1.DateYMD;

public class Main {
    public static void main(String[] args) {
        RealEstateAgency agency = new RealEstateAgency();
        agency.newProperty("Glória", 2, 30000);
        agency.newProperty("Vera Cruz", 1, 25000);
        agency.newProperty("Santa Joana", 3, 32000);
        agency.newProperty("Aradas", 2, 24000);
        agency.newProperty("São Bernardo", 2, 20000);

        agency.sell(1001);
        agency.setAuction(1002, new DateYMD(21, 3, 2023), 4);
        agency.setAuction(1003, new DateYMD(1, 4, 2023), 3);
        agency.setAuction(1001, new DateYMD(1, 4, 2023), 4);
        agency.setAuction(1010, new DateYMD(1, 4, 2023), 4);

        System.out.println(agency);

    }
}
