/**
 * Created by williamkohler on 6/20/16.
 */
public class Fruit implements Item {

    public String Desc;
    public double Price;
    public int Priority;
    public int quantity;
    public boolean Selected;


    Fruit(){
        Desc = "N/A";
        Priority = 0;
        Price = 0.00;
        Selected = false;
        quantity=1;

    }

    public void setDesc(String desc_in){
        Desc = desc_in;
    }

    public String getDesc(){
        return Desc;
    }


    public void setPrice(double price_in){
        Price = price_in;
    }

    public double getPrice(){
        return Price;
    }



    public void setPriority(int priority_in){
        Priority = priority_in;
    }

    public int getPriority(){
        return Priority;
    }



    public void setSelected(boolean choice){
        Selected = choice;
    }

    public boolean getSelection(){
        return Selected;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
