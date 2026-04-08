public class Service{
  private String type;
  private double price;
  private int numberOfCalls;
  
  public Service(){
  }
  public Service(String type, double price){
    this.type = type;
    this.price = price;
  }
  
  public double getPrice(){
    return price;
  }
   public String getType(){
    return type;
  }
  public void setPrice(double price){
     this.price = price;
  }
   public int getNumberOfCalls(){
    return numberOfCalls;
  }
  public void setNumberOfCalls(int numberOfCalls){
     this.numberOfCalls = numberOfCalls;
  }
  public String toString(){
    return "Service: " + type + " " + price;
  }
}