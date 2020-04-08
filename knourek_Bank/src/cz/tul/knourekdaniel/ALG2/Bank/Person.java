package cz.tul.knourekdaniel.ALG2.Bank;

public class Person extends Client {
    public Person(String name){
        this.name = name;
    }

    @Override
    public String getClientInfo() {
        if (this.name.matches(".*(a|á)")){
            return String.format("Paní %s",this.name);
        }else{
            return String.format("Pan %s",this.name);
        }
    }
}
