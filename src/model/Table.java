package model;

import java.util.Objects;

/**
 * Represents a table in the board game cafe.
 * 
 * @author Stephen Dawes
 * @version 13th June 2026
 */
public class Table {
    // instance variables
    private int tableId;
    private int capacity;
    private String location;
    private boolean isAvailable = true;

    /**
     * Constructor for objects of Table class.
     * 
     * @param tableId  the unique identifier for the table.
     * @param capacity the number of available seats.
     * @throws IllegalArgumentException if tableId is not positive.
     * @throws IllegalArgumentException if capacity is less than or equal to zero,
     *                                  or greater than 50.
     */
    public Table(int tableId, int capacity) {
        if (tableId <= 0) {
            throw new IllegalArgumentException("Table ID must be positive.");
        }
        this.tableId = tableId;

        if (capacity <= 0) {
            throw new IllegalArgumentException("Table must have capacity greater than zero.");
        }
        if (capacity > 50) {
            throw new IllegalArgumentException("Capacity appears unusually high.");
        }
        this.capacity = capacity;
    }

    /**
     * Updates the location of the table within the cafe.
     * 
     * @param location a descriptive name to help locate the table.
     * @throws IllegalArgumentException if the location is null or blank
     */
    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be blank.");
        }
        this.location = location;
    }

    /**
     * Updates the capacity of a table.
     * 
     * @param capacity the updated number of available seats.
     * @throws IllegalArgumentException if capacity is zero or negative or greater
     *                                  than 50.
     */
    public void updateCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Table capacity must be greater than zero.");
        }
        if (capacity > 50) {
            throw new IllegalArgumentException("Capacity appears unusually high.");
        }
        this.capacity = capacity;
    }

    /**
     * Returns the availability status of the table.
     * 
     * @return true if the table is available, false otherwise.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Returns the unique identifier of the table.
     * 
     * @return tableId the unique identifier.
     */
    public int getTableId() {
        return tableId;
    }

    /**
     * Returns the maximum capacity of the table.
     * 
     * @return capacity the maximum number of seats available.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns a location of the table.
     * 
     * @return location of the table..
     */
    public String getLocation() {
        return location;
    }

    /**
     * Marks the table as unavailable.
     */
    public void reserve() {
        this.isAvailable = false;
    }

    /**
     * Marks the table as available.
     */
    public void free() {
        this.isAvailable = true;
    }

    /**
     * Return a string representation of the table including
     * its id, location (unassigned if null or blank), capacity
     * and availability.
     * 
     * @return a string representation of the table.
     */
    public String toString() {
        String loc = isBlank(location) ? "unassigned" : location;
        String status = isAvailable ? "available" : "unavailable";

        return ("Table " + tableId + " (" + loc + "), seats "
                + capacity + " and is " + status);
    }

    // Helper method to check for valid inputs
    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Returns a has hash code value for the table object.
     * 
     * @return the hash code for this table id.
     */
    @Override
    public int hashCode() {
        return Objects.hash(tableId);
    }

    /**
     * Determines if this object is equal to another.
     * Two table objects are equal if they have the same tableId.
     * 
     * @param obj the object to compare with this table.
     * @return true if the objects are the same, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Table))
            return false;

        Table other = (Table) obj;
        return this.tableId == other.tableId;
    }

    /**
     * Checks whether the table has enough seats and is available
     * for a given group size.
     * 
     * @param groupSize the number of people requiring seating
     * @return true if the table can accommodate the group size and is available,
     *         false otherwise.
     */
    public boolean canSeat(int groupSize) {
        return groupSize > 0
                && groupSize <= capacity
                && isAvailable;
    }
}