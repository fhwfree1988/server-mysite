package com.project.site.Modules.Reservation.model.dto;

public class Types {
    public enum AmenityType {
        POOL("POOL"), SAUNA("SAUNA"), GYM("GYM");

        private final String name;

        private AmenityType(String value) {
            name = value;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}