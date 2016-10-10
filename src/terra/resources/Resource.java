package terra.resources;

public class Resource {
    private int worker = 0;
    private int gold = 0;
    private int priest = 0;

    public Resource(int worker, int gold, int priest) {
        this.worker = worker;
        this.gold = gold;
        this.priest = priest;
    }
    
    public int getWorker() {
        return worker;
    }
    public int getPriest() {
        return priest;
    }
    public int getGold() {
        return gold;
    }
    
    public void setWorker(int worker) {
        this.worker = worker;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setPriest(int priest) {
        this.priest = priest;
    }

    public void Spend(Resource amount) throws InsufficientResourceException {
        if (this.worker < amount.worker ||
            this.gold < amount.gold ||
            this.priest < amount.priest) {
            
            Resource needs = new Resource(this.worker - amount.worker < 0 ? -(this.worker - amount.worker) : 0,
                                          this.gold - amount.gold < 0 ? -(this.gold - amount.gold) : 0,
                                          this.priest - amount.priest < 0 ? -(this.priest - amount.priest) : 0);
            throw new InsufficientResourceException(needs);
        }
        this.worker -= amount.worker;
        this.gold -= amount.gold;
        this.priest -= amount.priest;
    }
    
    public boolean CanSpend(Resource amount) {
        return (this.worker >= amount.worker &&
                this.gold >= amount.gold &&
                this.priest >= amount.priest);
    }

    public void print() {
        System.out.format("\tWorker: %d, Gold: %d Priest: %d\n", worker, gold, priest);
        
    }
}
