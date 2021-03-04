package visao;
 
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import vo.Bloco;
 
 
public class CbModelBloco extends AbstractListModel<Object> implements ComboBoxModel<Object> {
    private static final int FIRSTINDEX = 0;
    private static final long serialVersionUID = 1L;
    private List<Bloco> listBloco;
    private Bloco bloco;
 
    public CbModelBloco() {
        this.listBloco = new ArrayList<>(20);
    }
     
    public CbModelBloco(List<Bloco> listBloco) {
        this();
        this.listBloco.addAll(listBloco);
        if (this.getSize() > 0) {
            this.setSelectedItem(this.listBloco.get(FIRSTINDEX));
        }
    }

    @Override
    public String toString(){
        return bloco.getBloco();
    }    
    
    @Override
    public Object getElementAt(int index) {
        return listBloco.get(index);
    }
 
    @Override
    public int getSize() {
        return listBloco.size();
    }
 
    @Override
    public Bloco getSelectedItem() {
        return bloco;
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        bloco = (Bloco) anItem;
    }
     
    public void addBloco(Bloco bloco) {
        listBloco.add(bloco);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listBloco.get(getSize() - 1));
    }
     
    public void addList(List<Bloco> blocos) {
        int primeiraLinha = getSize();
        listBloco.addAll(blocos);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + blocos.size());
        setSelectedItem(listBloco.get(getSize() - 1));
    }
     
    public void remove(int selecionado) {
        listBloco.remove(selecionado);
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listBloco.get(FIRSTINDEX));
    }
     
    public void clear() {
        listBloco.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }

}

/**para definir qual atributo ira aparecer no combobox*/
class BlocoCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
//        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Bloco) {
            Bloco bloco = (Bloco)value;
            setText(bloco.getBloco());
        }
        return this;
    }
}



