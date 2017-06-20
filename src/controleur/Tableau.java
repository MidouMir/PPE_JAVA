package controleur;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
 
public class Tableau extends AbstractTableModel{
     
    private Object[][] Data;
    private String[] Title;
 
    public Tableau(Object[][] data, String[] title){
        super();
        this.Data = data;
        this.Title = title;
    }
    /**
    * Retourne le titre de la colonne à l'indice spécifé
    */
    public String getColumnName(int col) {
      return this.Title[col];
    }
 
    /**
     * Retourne le nombre de colonnes
     */
    public int getColumnCount() {
        return this.Title.length;
    }
     
    /**
     * Retourne le nombre de lignes
     */
    public int getRowCount() {
        return this.Data.length;
    }
     
    /**
     * Retourne la valeur à l'emplacement spécifié
     */
    public Object getValueAt(int row, int col) {
        return this.Data[row][col];
    }
     
    /**
     * Défini la valeur à l'emplacement spécifié
     */
             
    /**
    * Retourne la classe de la donnée de la colonne
    * @param col
    */
    public Class getColumnClass(int col){
        //On retourne le type de la cellule à la colonne demandée
        //On se moque de la ligne puisque les données sur chaque ligne sont les mêmes
        //On choisit donc la première ligne
        return this.Data[0][col].getClass();
    }
 
    /**
     * Méthode permettant de retirer une ligne du tableau
     * @param position
     */
    public void removeRow(int position){
         
        int indice = 0, indice2 = 0, nbRow = this.getRowCount()-1, nbCol = this.getColumnCount();
        Object temp[][] = new Object[nbRow][nbCol];
         
        for(Object[] value : this.Data){
            if(indice != position){
                temp[indice2++] = value;
            }
            indice++;
        }
        this.Data = temp;
        temp = null;
        //Cette méthode permet d'avertir le tableau que les données ont été modifiées
        //Ce qui permet une mise à jours complète du tableau
        this.fireTableDataChanged();
    }
     
    /**
     * Permet d'ajouter une ligne dans le tableau
     * @param data
     */
    public void addRow(Object[] data){
        int indice = 0, nbRow = this.getRowCount(), nbCol = this.getColumnCount();
         
        Object temp[][] = this.Data;
        this.Data = new Object[nbRow+1][nbCol];
         
        for(Object[] value : temp)
            this.Data[indice++] = value;
         
             
        this.Data[indice] = data;
        temp = null;
        //Cette méthode permet d'avertir le tableau que les données ont été modifiées
        //Ce qui permet une mise à jours complète du tableau
        this.fireTableDataChanged();
    }
     
     
    public void setData(Object[][] data) {
        Data = data;
    }
    public boolean isCellEditable(int row, int col){
        return true;
    }
    
}