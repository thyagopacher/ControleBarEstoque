/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import vo.Pessoa;


/**
 *
 * @author ThyagoHenrique
 */
public class TableModelPessoa  extends AbstractTableModel {
        private static final long serialVersionUID = 1L;

	/* Lista de Sócios que representam as linhas. */
	private final List<Pessoa> linhas;
	/* Array de Strings com o nome das colunas. */
	private String[] colunas;

	/* Cria um PessoaTableModel vazio. */
	public TableModelPessoa() {
		linhas        = new ArrayList<>(100);
                this.colunas  = new String[] {"Nome", "Nivel", "Apto", "Bloco"};
	}

	/* Cria um PessoaTableModel carregado com
	 * a lista de sócios especificada. */
	public TableModelPessoa(List<Pessoa> obj) {
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
		case 3: 
			return String.class;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
        
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pessoa pessoa = linhas.get(rowIndex);
		switch (columnIndex) {
		case 0: 
			return pessoa.getNome();
		case 1: 
			return pessoa.getNivel().getNome();
		case 2: 
			return pessoa.getApartamento();
		case 3: 
                        return pessoa.getBloco();                            
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

  	public void setValueAt(Pessoa aValue, int rowIndex) {
              linhas.set(rowIndex, aValue);
              fireTableRowsUpdated(rowIndex, rowIndex);
  }

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
          return false;
	}

	public Pessoa getPessoa(int indiceLinha) {
		return linhas.get(indiceLinha);
	}
	
	/* Adiciona um registro. */
	public void addPessoa(Pessoa pessoa) {
		linhas.add(pessoa);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	/* Remove a linha especificada. */
	public void removePessoa(int indiceLinha) {
		// Remove o sócio da linha especificada.    	
		linhas.remove(indiceLinha);
		// Reporta a mudança. O JTable recebe a notificação
		// e se redesenha permitindo que visualizemos a atualização.
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	/* Adiciona uma lista de sócios ao final dos registros. */
	public void addLista(List<Pessoa> obj) {
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
