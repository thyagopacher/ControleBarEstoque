package visao;
 
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import vo.Pessoa;
 
 
public class CbModelMorador extends AbstractListModel<Object> implements ComboBoxModel<Object> {
    private static final int FIRSTINDEX = 0;
    private static final long serialVersionUID = 1L;
    private List<Pessoa> listPessoa;
    private Pessoa morador;
 
    public CbModelMorador() {
        this.listPessoa = new ArrayList<>(20);
    }
     
    public CbModelMorador(List<Pessoa> listPessoa) {
        this();
        this.listPessoa.addAll(listPessoa);
        if (getSize() > 0) {
            setSelectedItem(this.listPessoa.get(FIRSTINDEX));
        }
    }

    @Override
    public String toString(){
        return morador.getNome();
    }    
    
    @Override
    public Object getElementAt(int index) {
        return listPessoa.get(index);
    }
 
    @Override
    public int getSize() {
        return listPessoa.size();
    }
 
    @Override
    public Object getSelectedItem() {
        return morador;
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        morador = (Pessoa) anItem;
    }
     
    public void addEstado(Pessoa morador) {
        listPessoa.add(morador);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listPessoa.get(getSize() - 1));
    }
     
    public void addList(List<Pessoa> moradors) {
        int primeiraLinha = getSize();
        listPessoa.addAll(moradors);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + moradors.size());
        setSelectedItem(listPessoa.get(getSize() - 1));
    }
     
    public void remove(int selecionado) {
        listPessoa.remove(selecionado);
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listPessoa.get(FIRSTINDEX));
    }
     
    public void clear() {
        listPessoa.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }

}

/**para definir qual atributo ira aparecer no combobox*/
class PessoaCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Pessoa) {
            Pessoa morador = (Pessoa) value;
            setText(morador.getNome());
        }
        return this;
    }
}



