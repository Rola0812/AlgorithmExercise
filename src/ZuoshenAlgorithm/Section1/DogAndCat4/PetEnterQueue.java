package ZuoshenAlgorithm.Section1.DogAndCat4;


class PetEnterQueue {

    private Pet pet;//用户原有实例
    private long count;//时间戳

    public PetEnterQueue(Pet pet, long count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet(){
        return this.pet;
    }

    public long getCount(){
        return this.count;
    }

    public String getEnterPetType(){
        return this.pet.getPetType();
    }
}

class Pet{
    private String type;

    public Pet(String type){
        this.type = type;
    }

    public String getPetType() {
        return type;
    }
}

class Dog extends Pet{
    public Dog(){
        super("dog");
    }
}

class Cat extends Pet{
    public Cat(){
        super("cat");
    }
}