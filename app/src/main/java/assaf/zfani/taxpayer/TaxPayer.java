package assaf.zfani.taxpayer;

/**
 * Created by user on 11/2/2017.
 */

public class TaxPayer {
    String name;
    long cash;
    long realEstate;
    long portfolio;
    boolean immunity;

    public String getName() {
        return name;
    }

    public TaxPayer(String name, long cash, long realEstate, long portfolio, boolean immunity)
    {
        this.name =name;

        this.portfolio=portfolio;
        this.cash=cash;
        this.realEstate=realEstate;
        this.immunity= immunity;


    }

    public long getCash() {
        return cash;
    }

    public long getRealEstate() {
        return realEstate;
    }

    public long getPortfolio() {
        return portfolio;
    }

    public boolean isImmunity() {
        return immunity;
    }


    public long sumAssets()
    {
        return this.cash +this.realEstate +this.portfolio;
    }
    public  boolean isRich()
    {
        return sumAssets()>1000000;
    }
    public  void  removeTax()
    {
     this.cash*=0.9;
        this.portfolio*=0.9;
        this.realEstate*=0.9;

    }


}
