package visao;
 
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import vo.TipoPagamento;
 
 
public class CbModelTipoPagamento extends AbstractListModel<Object> implements ComboBoxModel<Object> {
    private static final int FIRSTINDEX = 0;
    private static final long serialVersionUID = 1L;
    private List<TipoPagamento> listTipoPagamento;
    private TipoPagamento tipo;
 
    public CbModelTipoPagamento() {
        this.listTipoPagamento = new ArrayList<>(20);
    }
     
    public CbModelTipoPagamento(List<TipoPagamento> listTipoPagamento) {
        this();
        this.listTipoPagamento.addAll(listTipoPagamento);
        if (getSize() > 0) {
            setSelectedItem(this.listTipoPagamento.get(FIRSTINDEX));
        }
    }

    @Override
    public String toString(){
        return tipo.getNome();
    }    
    
    @Override
    public Object getElementAt(int index) {
        return listTipoPagamento.get(index);
    }
 
    @Override
    public int getSize() {
        return listTipoPagamento.size();
    }
 
    @Override
    public Object getSelectedItem() {
        return tipo;
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        tipo = (TipoPagamento) anItem;
    }
     
    public void addEstado(TipoPagamento tipo) {
        listTipoPagamento.add(tipo);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listTipoPagamento.get(getSize() - 1));
    }
     
    public void addList(List<TipoPagamento> tipos) {
        int primeiraLinha = getSize();
        listTipoPagamento.addAll(tipos);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + tipos.size());
        setSelectedItem(listTipoPagamento.get(getSize() - 1));
    }
     
    public void remove(int selecionado) {
        listTipoPagamento.remove(selecionado);
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listTipoPagamento.get(FIRSTINDEX));
    }
     
    public void clear() {
        listTipoPagamento.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }

}

/**para definir qual atributo ira aparecer no combobox*/
class TipoPagamentoCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof TipoPagamento) {
            TipoPagamento tipo = (TipoPagamento) value;
            setText(tipo.getNome());
        }
        return this;
    }
}



