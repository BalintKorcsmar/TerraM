package terra.resources;

public class InsufficientResourceException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Resource needs;

    public InsufficientResourceException(Resource needs) {
        this.setNeeds(needs);
    }

    public Resource getNeeds() {
        return needs;
    }

    public void setNeeds(Resource needs) {
        this.needs = needs;
    }
}
