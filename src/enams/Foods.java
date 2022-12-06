package enams;

public enum Foods {
    MEAT_POULSTRY(150," MEAT_POULSTRY"),
    FISH_SEAFOOF(300,"FISH_SEAFOOF"),
    WATER(20,"WATER"),
    TASTY(100,"TASTY");
    private int price;

   private String name;

    Foods(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "  Foods : " + '\n'+
                " price : " + price +'\n'+
                " name : " + name + '\n' +
                "------------------------\n";
    }
}
