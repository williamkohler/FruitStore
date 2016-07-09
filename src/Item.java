/**
 * Created by williamkohler on 6/20/16.
 */
public interface Item {


    public void setDesc(String desc_in);

    public String getDesc();



    public void setPrice(double price_in);

    public double getPrice();



    public void setPriority(int priority_in);

    public int getPriority();



    public void setSelected(boolean choice);

    public boolean getSelection();


    public void setQuantity(int quantity);

    public int getQuantity();


}
