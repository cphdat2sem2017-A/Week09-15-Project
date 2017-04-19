package model;

public class Part
{
  private int pno;
  private String pname;
  private int QOH;
  private double price;
  private int olevel;
  
  public Part(int p, String pn, int q, double pr, int ol)
  {
    pno=p;
    pname=pn;
    QOH=q;
    price=pr;
    olevel=ol;    
  }

  public void setPno(int pno)
  {
    this.pno = pno;
  }

  public int getPno()
  {
    return pno;
  }

  public void setPname(String pname)
  {
    this.pname = pname;
  }

  public String getPname()
  {
    return pname;
  }

  public void setQOH(int qOH)
  {
    this.QOH = qOH;
  }

  public int getQOH()
  {
    return QOH;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public double getPrice()
  {
    return price;
  }

  public void setOlevel(int olevel)
  {
    this.olevel = olevel;
  }

  public int getOlevel()
  {
    return olevel;
  }
}
