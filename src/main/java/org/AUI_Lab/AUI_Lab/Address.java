package org.AUI_Lab.AUI_Lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Address implements Comparable<Address>, Serializable {
    private String city;
    private String zipCode;
    private String street;
    private int houseNumber;
    private int apartmentNumber;

    @Override
    public int hashCode() {
        return Objects.hash(city, zipCode, street, houseNumber, apartmentNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return houseNumber == address.houseNumber
                && apartmentNumber == address.apartmentNumber
                && Objects.equals(city, address.city)
                && Objects.equals(zipCode, address.zipCode)
                && Objects.equals(street, address.street);
    }

    @Override
    public int compareTo(Address other) {
        if(!city.equals(other.city))return city.compareTo(other.city);
        if(!zipCode.equals(other.zipCode))return zipCode.compareTo(other.zipCode);
        if(!street.equals(other.street))return street.compareTo(other.street);
        if(houseNumber!=other.houseNumber)return houseNumber-other.houseNumber;
        if(apartmentNumber!=other.apartmentNumber)return apartmentNumber-other.apartmentNumber;
        return 0;
    }

    @Override
    public String toString(){
        String apartmentString = "";
        if(apartmentNumber!=0)apartmentString="/"+String.valueOf(apartmentNumber);
        return city + " " + zipCode + " " + street + " " + String.valueOf(houseNumber) + apartmentString;
    }
}
