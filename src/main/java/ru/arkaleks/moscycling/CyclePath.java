package ru.arkaleks.moscycling;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CyclePath {


    private int global_id;
    private Number Number;
    private Cells Cells;

    public static class Cells {

        private int global_id;
        private String Name;

        public int getGlobal_id() {
            return global_id;
        }

        public String getName() {
            return Name;
        }
    }

    //    private int ID;
  //  private String Name;
//    private String ObjectOperOrgPhone;
//    private String Type;
//    private String Location;
//    private String DepartamentalAffiliation;
//    private String OperOrgName;
//    private String PortionName;
//    private String[] geoData;
//    private int Width;


    public int getGlobal_id() {
        return global_id;
    }

    public Number getNumber() {
        return Number;
    }

    public CyclePath.Cells getCells() {
        return Cells;
    }

    //    public String getName() {
//        return Name;
//    }
//
//    public String getObjectOperOrgPhone() {
//        return ObjectOperOrgPhone;
//    }
//
//    public String getType() {
//        return Type;
//    }
//
//    public String getLocation() {
//        return Location;
//    }
//
//    public String getDepartamentalAffiliation() {
//        return DepartamentalAffiliation;
//    }
//
//    public String getOperOrgName() {
//        return OperOrgName;
//    }
//
//    public String getPortionName() {
//        return PortionName;
//    }
//
//    public String[] getGeoData() {
//        return geoData;
//    }
//
//    public int getWidth() {
//        return Width;
//    }
}
