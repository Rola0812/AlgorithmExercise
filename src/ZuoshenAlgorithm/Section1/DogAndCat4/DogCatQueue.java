package ZuoshenAlgorithm.Section1.DogAndCat4;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue{

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            this.dogQ.add(new PetEnterQueue(pet,count++));
        }else if (pet.getPetType().equals("cat")){
            this.catQ.add(new PetEnterQueue(pet,count++));
        }else {
            throw new RuntimeException("err");
        }
    }

    public Pet pollAll(){
        if(!dogQ.isEmpty() && !catQ.isEmpty()){
            if(dogQ.peek().getCount()<catQ.peek().getCount()){
                return this.dogQ.poll().getPet();
            }else {
                return this.catQ.poll().getPet();
            }
        }else if(!dogQ.isEmpty()){
            return this.dogQ.poll().getPet();
        }else if(!catQ.isEmpty()){
            return this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("err");
        }
    }

    public Dog pollDog(){
        if(!this.isDogQueueEmpty()){
            return (Dog) this.dogQ.poll().getPet();
        }else {
            throw new RuntimeException("err");
        }
    }

    public Cat pollCat(){
        if(!this.isCatQueueEmpty()){
            return (Cat) this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("err");
        }
    }

    public boolean isEmpty(){
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return this.catQ.isEmpty();
    }
}
