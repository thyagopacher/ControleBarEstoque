/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import vo.Ambiente;


/**
 *
 * @author ThyagoHenrique
 */
public class TableModelAmbiente  extends AbstractTableModel {
        private static final long serialVersionUID = 1L;

	/* Lista de Sócios que representam as linhas. */
	private final List<Ambiente> linhas;
	/* Array de Strings com o nome das colunas. */
	private String[] colunas;

	/* Cria um AmbienteTableModel vazio. */
	public TableModelAmbiente() {
		linhas        = new ArrayList<>(100);
                this.colunas  = new String[] {"Nome", "Valor", "Tipo Reserva"};
	}

	/* Cria um AmbienteTableModel carregado com
	 * a lista de sócios especificada. */
	public TableModelAmbiente(List<Ambiente> obj) {
		linhas = new ArrayList<>(obj);
	}


	/* Retorna a quantidade de colunas. */
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	/* Retorna a quantidade de linhas. */
	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	};

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0: 
			return String.class;
		case 1: 
			return String.class;
		case 2: 
			return String.class;
		
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
        
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Ambiente ambiente = linhas.get(rowIndex);
		switch (columnIndex) {
		case 0: 
			return ambiente.getNome();
		case 1: 
			return Validacao.formatMoeda(ambiente.getValor());
		case 2: 
			return ambiente.getTiporeserva();                 
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

  	public void setValueAt(Ambiente aValue, int rowIndex) {
              linhas.set(rowIndex, aValue);
              fireTableRowsUpdated(rowIndex, rowIndex);
  }

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
          return false;
	}

	public Ambiente getAmbiente(int indiceLinha) {
		return linhas.get(indiceLinha);
	}
	
	/* Adiciona um registro. */
	public void addAmbiente(Ambiente ambiente) {
		linhas.add(ambiente);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	/* Remove a linha especificada. */
	public void removeAmbiente(int indiceLinha) {
		// Remove o sócio da linha especificada.    	
		linhas.remove(indiceLinha);
		// Reporta a mudança. O JTable recebe a notificação
		// e se redesenha permitindo que visualizemos a atualização.
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	/* Adiciona uma lista de sócios ao final dos registros. */
	public void addLista(List<Ambiente> obj) {
		// Pega o tamanho antigo da tabela.
		int tamanhoAntigo = getRowCount();
		// Adiciona os registros.
		linhas.addAll(obj);
		// Reporta a mudança. O JTable recebe a notificação
		// e se redesenha permitindo que visualizemos a atualização.
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	/* Remove todos os registros. */
	public void limpar() {
		linhas.clear();
		fireTableDataChanged();
	}

	/* Verifica se este table model está vazio. */
	public boolean isEmpty() {
		return linhas.isEmpty();
	}  
}
