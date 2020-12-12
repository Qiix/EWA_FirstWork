/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Entities;

/**
 *
 * @author MY HP
 */
class Categorie {
    private String idCategorie;
    private String intituleCategorie;

    public Categorie() {
    }

    public Categorie(String idCategorie, String intituleCategorie) {
        this.idCategorie = idCategorie;
        this.intituleCategorie = intituleCategorie;
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public String getIntituleCategorie() {
        return intituleCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setIntituleCategorie(String intituleCategorie) {
        this.intituleCategorie = intituleCategorie;
    }

    @Override
    public String toString() {
        return "Categorie{" + "idCategorie=" + idCategorie + ", intituleCategorie=" + intituleCategorie + '}';
    }
    
    
    
    
}
