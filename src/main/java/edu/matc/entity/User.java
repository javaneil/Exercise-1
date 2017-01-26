package edu.matc.entity;

// TODO Add instance variable for the date of birth
// TODO Add a calculation for the user's age. Age should not be stored, it should be calculated only.

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private Date   birthDate;


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     * @param birthDate the birthdate // added 2017_01_21nkf
     */
    public User( String firstName, String lastName, String userid, Date birthDate) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.userid    = userid;
        this.birthDate = birthDate;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Sets birthdate
     * @param birthDate SQL date of birth
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Calculate and return age derived from birthDate
     * @return the calculated age
     */
    public int getAge() {
//        LocalDate birthday = birthDate.toLocalDate();
//        LocalDate today = LocalDate.now();
//        long Age = ((today.toEpochDay() - birthday.toEpochDay()) / 365);
        int age = Period.between( birthDate.toLocalDate(), LocalDate.now() ).getYears();
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='"   + firstName + '\'' +
                ", lastName='"  + lastName  + '\'' +
                ", userid='"    + userid    + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

}