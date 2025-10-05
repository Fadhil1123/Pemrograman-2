public class Fruits {
    private String name;
    private double price;
    private double weight;
    private double totalWeight;

    public Fruits() {
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }


    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public double getWeight() {
        return weight;
    }
    public double getTotalWeight() {
        return totalWeight;
    }

    public double totalDiscount(){
        return (int) (totalWeight/4)*(4*price)*0.02;
    }
    public double priceBefore(){
        return  priceKG() * totalWeight;
    }
    public double priceKG(){
        return price / weight;
    }
    public double priceAfter(){
        return priceBefore() - totalDiscount();
    }

    public void print(){
        System.out.println("Nama Buah: " + getName());
        System.out.println("Berat: " + getWeight());
        System.out.println("Harga: Rp" + getPrice());
        System.out.println("Jumlah beli: " + getTotalWeight() + "kg");
        System.out.println("Harga Sebelum Diskon: Rp" + String.format("%.2f", priceBefore()));
        System.out.println("Total Diskon: Rp" + String.format("%.2f", totalDiscount()));
        System.out.println("Harga Setelah Diskon: Rp" + String.format("%.2f", priceAfter()));
        System.out.println("\n");
    }
}
