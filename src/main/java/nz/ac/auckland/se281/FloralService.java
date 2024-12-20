package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class FloralService extends Services {
  // This class extends the Services 'parent' class
  private FloralType floralType;

  // Constructor for Floral class
  public FloralService(Bookings.BookingOperations bookingOperations) {
    super(bookingOperations);
  }

  // Method that adds a floral service to a booking
  public void addService(String bookingReference) {
    Bookings.VenueBooking booking = bookingOperations.getBooking(bookingReference);

    // If the booking is found, set the floral service and price
    if (booking != null) {
      String floralService = floralType.getName();
      int floralPrice = floralType.getCost();

      booking.setFloralType(floralService);
      booking.setFloralPrice(String.valueOf(floralPrice));
    }
  }

  // Method that sets the floral type
  public void setFloralType(FloralType floralType) {
    this.floralType = floralType;
  }
}
