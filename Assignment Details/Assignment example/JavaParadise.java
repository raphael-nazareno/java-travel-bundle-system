import java.io.*;
import java.util.*;
import java.time.*;

public class JavaParadise {
  private FileInputStream fis;
  private ObjectInputStream ois;
  private FileOutputStream fos;
  private ObjectOutputStream oos;
  
  private ArrayList<Room> rooms ;
  private ArrayList<Customer> customers ;
  private ArrayList<Booking> bookings ;
  private ArrayList<Service> services;
  
  public  JavaParadise() {
       rooms = new ArrayList<Room>();
       customers = new ArrayList<Customer>();   
       bookings = new ArrayList<Booking>();
       services = new ArrayList<Service>();
  }

  public void populateLists(){
           Room[] arrOfRooms = {new Room("Single", 130), new Room("Double",240), 
           new Room("Single",120),new Room("Double", 260)};
           Customer[] arrOfCustomers = {new Customer("Natasha"), 
           new Customer("Jeff"), new Customer("Sam")};
     for(int i = 0; i < arrOfRooms.length; i++)
       rooms.add(arrOfRooms[i]);
     for(int i = 0; i < arrOfCustomers.length; i++)
       customers.add(arrOfCustomers[i]);
     services.add(new Service("cleaning", 12));
     services.add(new Service("ironing", 6));
 }

  public static void main (String[] args) {
    JavaParadise jp = new JavaParadise();
    jp.populateLists();
    jp.run();
  }
    
  
  public void run() {
    boolean flag = true;
    Scanner input = new Scanner(System.in);
    while (flag) {
      System.out.println("Java Paradise options\n------------------------\n"+
      "1: Display all rooms\n" +    
      "2: Display available rooms\n"+              
      "3: Add customer\n"+    
      "4: List customers\n"+          
      "5: Add booking\n" +        
      "6: List bookings\n"+   
      "7: Remove booking\n"+            
      "8: Edit booking\n"+           
      "9: Check out a customer\n"+  
      "10: Display unpaid bills\n"+  
      "11: Save bookings to file\n"+    
      "12: Read bookings from file\n"+  
      "13: Quit\n");
      
      System.out.print("Choose an option: ");
      int option = input.nextInt();
      input.nextLine();
      switch (option) {
        case 1:
          displayAllRooms();
          break;
        case 2:
          displayAvailableRooms();
          break;
        case 3:
          addCustomer();
          break;
        case 4: 
          listCustomers();
        break;
        case 5:
          addBooking();
          break;
        case 6:
          listBookings();
          break;
        case 7:
          removeBookingById();
          break;
        case 8:
          listBookings();
          Scanner input2 = new Scanner(System.in);
          System.out.println("Customer ID? ");
          int id = input2.nextInt();
          input2.nextLine();
          editBookingByCustId(id);
        break;
        case 9:
          Scanner input1 = new Scanner(System.in);
          String payNow = null;
          System.out.println("Customer ID? ");
          int custId = input1.nextInt();
          input1.nextLine();
          checkOut(custId);
        break;
        case 10:
          displayUnpaidBills();
        break;
        case 11:
          saveBookings();
          break;
        case 12:
          readBookings();
          break;
        case 13:
          flag = false;
          break;
        default:
          System.out.println("Invalid option.");
        }
    
    }
    
  }
  
  public void displayAllRooms() {
      for (Room r:rooms) {
      System.out.println(r);
    }
  }
  public void displayServices() {
      for (Service s:services) {
      System.out.println(s);
    }
  }
   public void displayAvailableRooms() {
      for (Room r:rooms) {
       if (r.getAvailability())
          System.out.println(r);
    }
  }
   
  public void addCustomer() {
   Scanner input = new Scanner(System.in);
   System.out.print("Customer name? ");
    String name = input.nextLine();
    Customer c = new Customer(name);
    customers.add(c);
  }
  
  public void listCustomers() {
      for (Customer c:customers) {
      System.out.println(c);
    }
  }
  public void listBookings() {
      for (Booking b:bookings) {
      System.out.println(b);
    }
  }
  public Customer searchCustomerById() {
    Scanner input = new Scanner(System.in);
    System.out.println("Customer ID? ");
    int custId = input.nextInt();
    input.nextLine();
    for (Customer c:customers) {
      if (c.getCustId() == custId)
      return c;
    }
    return null;
  }
  public void addBooking() {
    Scanner input = new Scanner(System.in);
    System.out.print("Customer ID? ");
    int custId = input.nextInt();
    input.nextLine();       
        System.out.print("Duration? ");
        int dur = input.nextInt();
        input.nextLine();
            
     System.out.print("Date in format yyyy-mm-dd? ");
     String dateStr = input.nextLine();
      LocalDate date = null;
     try{
       date = LocalDate.parse(dateStr);
     }
     catch(Exception e){}
      
     Booking booking = new Booking(custId, date, dur);
     boolean match = false;
      while(true) {
        System.out.print("Room type? ");
        String roomType = input.nextLine();
         for (Room r: rooms) {
          if (r.getType().equalsIgnoreCase(roomType) && r.getAvailability()) {
            // Update room status  in ArrayList
            r.setAvailability(false);
            booking.setRoomNo(r.getRoomNo());
            // Set match flag to break loop
             match = true;
            // Stop searching for matching bike
             break;
           }
         }
         if (match)
          break;
          System.out.println("Did not find a match.");
        
      }
       bookings.add(booking);
    } 
   
  public void removeBookingById () {
    listBookings();
    Scanner input = new Scanner(System.in);
    System.out.print("Booking ID? ");
    int id = input.nextInt();
    for (int i = 0; i < bookings.size(); i++) {
      Booking b = bookings.get(i);
      if (b.getBookingId() == id){
        bookings.remove(b);
      }
    }
   }
  public void editBookingByCustId(int custId) {
      Booking b = searchBookingsByCustId(custId); 
      System.out.println(b);
       Scanner input = new Scanner(System.in);
       System.out.println("Select option:\n"+
                         "1.Start date\n2.Duration\n3.Room");
       int choice = input.nextInt();
       switch(choice){
         case 1:
           System.out.println("Enter a new start date");
           String dateStr = input.nextLine();
           b.setDate(dateStr);
          break;
        case 2:
           System.out.println("Enter a new duration");
           int newDuration = input.nextInt();
           b.setDuration(newDuration);
        break;
         case 3: 
            displayAvailableRooms();
            System.out.println("Enter a new room number");
             int newRoomNo = input.nextInt();
             b.setRoomNo(newRoomNo);
         break;
  }
  }
  
  public Booking searchBookingsByCustId(int custId) {
      for (Booking b: bookings) {
      if (b.getCustId() == custId)
       return b;
     }
    return null;
  }
  
  public void displayUnpaidBills(){
    
    for (Booking b: bookings) {
      if (!b.getIsPaid())
      System.out.println("Customer " + b.getCustId() + ". Amount due " + b.getTotalCost()+ "$");
    
  }
  }
  public Room searchRoomsByRoomNo(int roomNo){
    for(Room r: rooms){
      if(r.getRoomNo() == roomNo)
        return r;
    }
    return null;
   }
  
  public Service searchServiceByType(String type) {
      for (Service s: services) {
       if (s.getType().equalsIgnoreCase(type))
       return s;
     }
    return null;
  }
  
  public void checkOut(int custID){
        Booking b = searchBookingsByCustId(custID);
        int duration = b.getDuration();
        int roomNo = b.getRoomNo();
        Room r = searchRoomsByRoomNo(roomNo);
        r.setAvailability(true);
        double totalCost = duration * r.getPricePerDay();
        System.out.println("Is breakfast included? y/n");
        Scanner input = new Scanner(System.in);
        String breakfast = input.nextLine();
        if(breakfast.equalsIgnoreCase("y"))
           totalCost +=b.getBreakfast()*duration;
        displayServices();
        System.out.println("Enter type of service if any and number of calls separated with space?");
        String service = input.next();
        int numberOfCalls = input.nextInt();
        input.nextLine();
        Service s = searchServiceByType(service);
        if(s!=null){
          s.setNumberOfCalls(numberOfCalls);
          totalCost +=s.getPrice()* s.getNumberOfCalls();
        }
        b.setTotalCost(totalCost);
        System.out.println("You have to pay "+ totalCost + ". Would you pay now? y/n");
          String payNow = input.nextLine();
          if(payNow.equalsIgnoreCase("y"))
            b.setIsPaid(true);
  }
  
    
  public void saveBookings() {
    try {
      fos = new FileOutputStream("bookings.dat");
      oos = new ObjectOutputStream(fos);
      for (Booking b:bookings) {
        oos.writeObject(b);
      }
      fos.close();
      oos.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
  
  public void readBookings() {
   bookings.clear();
    try {
      fis = new FileInputStream("bookings.dat");
      ois = new ObjectInputStream(fis);
      
      while (true) {
        try {
          Object object = ois.readObject();
          Booking b = (Booking)object;
          //update room status
           int roomNo = b.getRoomNo();
          Room r = searchRoomsByRoomNo(roomNo);
          r.setAvailability(false);
          //add to array list
          bookings.add(b);
          System.out.println(b);
        } catch (EOFException eof) {
          fis.close();
          ois.close();
          break;
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  
  }
  
}