package Soal2;
public  class Dog extends Pet{
    private String furColor;
    private String[] skill;

    public Dog(String n, String r, String w, String k){
        super(r, n);
        this.furColor = w;
        this.skill = k.split(", ");
    }

    public void displayDogDetail(){
        super.display();
        System.out.println("Warna Bulu: " +furColor);
        System.out.print("Memiliki kemampuan: ");
        for(int i = 0; i < skill.length; i++){
            System.out.print(skill[i] + "  ");
        }
    }
}

