package com.example.beescourier.database;

import android.provider.BaseColumns;

public final class UserMaster {
    private UserMaster() {}


    public static class Users implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_WEIGHT = "weight";
        public static final String COLUMN_NAME_WIDTH = "width";
        public static final String COLUMN_NAME_LENGTH = "length";
        public static final String COLUMN_NAME_HEIGHT = "height";
        public static final String COLUMN_NAME_DELIVERY = "delivery";
    }
}
