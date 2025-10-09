package Soal2;
public class Dog extends Pet{
    String furColor;
    String[] skill;

    public void dog(String n, String f, String w, String[] k){
        this.name = n;
        this.race = f;
        this.furColor = w;
        this.skill = k;
    }

    public void displayDogDetail(){
        System.out.println("Dog");
    }
}
