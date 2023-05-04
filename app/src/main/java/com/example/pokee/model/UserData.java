package com.example.pokee.model;

public class UserData {
        String id, display_name, user_name, phone_number;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }


        public String getLast_name() {
            return display_name;
        }

        public void setLast_name(String last_name) {
            this.display_name = display_name;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }
}