package model;

public class Reponse {

    private String reponse;
    private Integer index;

    public Reponse(String reponse, Integer index ) {

        this.reponse = reponse;
        this.index = index;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
/*
 * TODO lancer le programme avec le bloc comment�
 * pour voir le comprtement par d�faut
 * puis d�commenter er voir la diff�rence    
 */
    
    @Override
    public String toString(){
        return this.getIndex() + ": " + this.getReponse();
    }
}
