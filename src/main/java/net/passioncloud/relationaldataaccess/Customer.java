package net.passioncloud.relationaldataaccess;

public class Customer {
    private String id;
    private String firstName;
    private String lastName;

    public Customer(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName=%s, lastName=%s]", id, firstName, lastName);
    }
}

