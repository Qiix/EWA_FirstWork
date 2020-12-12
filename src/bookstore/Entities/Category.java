
package bookstore.Entities;


public class Category {
   private int idCategorie ;
   private String nomCategorie ;

    public Category(int idCategorie, String nomCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    @Override
    public String toString() {
        return "Category{" + "idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + '}';
    }
   
}
