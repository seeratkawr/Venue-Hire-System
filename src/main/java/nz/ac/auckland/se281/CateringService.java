package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class CateringService extends Services {
  // This class extends the Services 'parent' class
  private CateringType cateringType;

  // Constructor for Catering class
  public CateringService(Bookings.BookingOperations bookingOperations) {
    super(bookingOperations);
  }

  // Method that adds a catering service to a booking
  public void addService(String bookingReference) {
    // Get the booking from the booking reference
    Bookings.VenueBooking booking = bookingOperations.getBooking(bookingReference);

    // If the booking is found, set the catering service and price
    if (booking != null) {
      String cateringService = cateringType.getName();
      // Catering price is found by multiplying the cost per person by the number of attendees
      int cateringPrice =
          cateringType.getCostPerPerson()
              * Integer.parseInt(
                  booking.attendees.get(booking.bookingReferences.indexOf(bookingReference)));

      booking.setCateringType(cateringService);
      booking.setCateringPrice(String.valueOf(cateringPrice));
    }
  }

  // Method that sets the catering type
  public void setCateringType(CateringType cateringType) {
    this.cateringType = cateringType;
  }
}
