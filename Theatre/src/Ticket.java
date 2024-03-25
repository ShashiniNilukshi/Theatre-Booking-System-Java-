

public class Ticket {
    int row;
    int seat;
    float price;
    person person1=new person();

    public Ticket(int row, int seat, float price, person person1) {
        this.row= row;
        this.seat = seat;
        this.price= price;
        this.person1 = person1;
    }

    public Ticket (){
        this.row=0;
        this.seat=0;
        this.price=0.0F;
        this.person1=new person();
    }
    public void print(){
        System.out.println(person1.name+"\n"+person1.surname+"\n"+person1.email+"\n"+"row:"+row+"\n"+"seat:"+seat+"\n"+price);
    }
    public float getPrice() {
        return price;
    }
    public int getRow() {
        return row;
    }
    public int getSeat() {
        return seat;
    }

}


