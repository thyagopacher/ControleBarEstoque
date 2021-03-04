package visao;
 
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import vo.Apartamento;
 
 
public class CbModelApartamento extends AbstractListModel<Object> implements ComboBoxModel<Object> {
    private static final int FIRSTINDEX = 0;
    private static final long serialVersionUID = 1L;
    private List<Apartamento> listApartamento;
    private Apartamento apartamento;
 
    public CbModelApartamento() {
        this.listApartamento = new ArrayList<>(20);
    }
     
    public CbModelApartamento(List<Apartamento> listApartamento) {
        this();
        this.listApartamento.addAll(listApartamento);
        if (this.getSize() > 0) {
            this.setSelectedItem(this.listApartamento.get(FIRSTINDEX));
        }
    }

    @Override
    public String toString(){
        return apartamento.getApartamento();
    }    
    
    @Override
    public Object getElementAt(int index) {
        return listApartamento.get(index);
    }
 
    @Override
    public int getSize() {
        return listApartamento.size();
    }
 
    @Override
    public Apartamento getSelectedItem() {
        return apartamento;
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        apartamento = (Apartamento) anItem;
    }
     
    public void addEstado(Apartamento apartamento) {
        listApartamento.add(apartamento);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listApartamento.get(getSize() - 1));
    }
     
    public void addList(List<Apartamento> apartamentos) {
        int primeiraLinha = getSize();
        listApartamento.addAll(apartamentos);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + apartamentos.size());
        setSelectedItem(listApartamento.get(getSize() - 1));
    }
     
    public void remove(int selecionado) {
        listApartamento.remove(selecionado);
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listApartamento.get(FIRSTINDEX));
    }
     
    public void clear() {
        listApartamento.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }

}

/**para definir qual atributo ira aparecer no combobox*/
class ApartamentoCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Apartamento) {
            Apartamento apartamento = (Apartamento) value;
            setText(apartamento.getApartamento());
        }
        return this;
    }
}



