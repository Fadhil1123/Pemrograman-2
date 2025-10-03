public class Fruits {
    private String name;
    private double price;
    private double weight;
    private double totalWeight;

    public Fruits(String name, double weight, double price,  double totalWeight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.totalWeight = totalWeight;
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
        System.out.println("Nama Buah: " + name);
        System.out.println("Berat: " + weight + " kg");
        System.out.println("Harga: Rp" + price);
        System.out.println("Jumlah beli: " + totalWeight + " kg");
        System.out.println("Harga Sebelum Diskon: Rp" + String.format("%.2f", priceBefore()));
        System.out.println("Total Diskon: Rp" + String.format("%.2f", totalDiscount()));
        System.out.println("Harga Setelah Diskon: Rp" + String.format("%.2f", priceAfter()));
    }
}