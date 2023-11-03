package com.example.myapplication;

import java.sql.Date;

public class dbRow {
    int id;
    int PersonalAccount;
    String FIO;
    String Street;
    int HouseNumber;
    int ApartmentNumber;
    String ServiceType;
    double Sum;
    String PayBefore;

    public dbRow(int Id, int PA, String Fio, String Street_name, int HN, int AN,
                 String ST, double sum, String PB){
        id = Id;
        PersonalAccount = PA;
        FIO = Fio;
        Street = Street_name;
        HouseNumber = HN;
        ApartmentNumber = AN;
        ServiceType = ST;
        Sum = sum;
        PayBefore = PB;
    }
}
