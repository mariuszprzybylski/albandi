package com.przybylski.lamaniekodu.model.Hobby;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

        @OneToMany(mappedBy = "category")

        List<RegistrationForSportsActivities> registrationForSportsActivities;

        public List<RegistrationForSportsActivities> getRegistrationForSportsActivities() {
            return registrationForSportsActivities;
        }

        public void setRegistrationForSportsActivities(List<RegistrationForSportsActivities> registrationForSportsActivities) {
            this.registrationForSportsActivities = registrationForSportsActivities;
        }

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer id;
        private String name;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return getName() + " ";
        }
    }

