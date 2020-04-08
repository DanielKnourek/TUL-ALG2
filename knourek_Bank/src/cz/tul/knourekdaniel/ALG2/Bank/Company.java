package cz.tul.knourekdaniel.ALG2.Bank;

public class Company extends Client{
    public Company(String name){
        this.name = name;
    }

    @Override
    public String getClientInfo(){
        return "firma " + this.name;
    }
}
