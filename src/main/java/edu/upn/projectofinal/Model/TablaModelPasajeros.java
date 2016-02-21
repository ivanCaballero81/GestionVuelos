/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.projectofinal.Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivan
 */
public class TablaModelPasajeros extends AbstractTableModel {

    List<PasajeroDto> listPasajeros = new ArrayList();
    protected String[] columnNames = new String[]{
        "Nombre", "Apellido Paterno", "Apellido Materno", "Tipo Documento", "Numero", "Pais"
    };

    public TablaModelPasajeros(List<PasajeroDto> pasajeros) {
        listPasajeros = pasajeros;
    }

    @Override
    public int getRowCount() {
        return listPasajeros.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    // Optional, the name of your column

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PasajeroDto pasajeroDto = listPasajeros.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pasajeroDto.getNombre();
            case 1:
                return pasajeroDto.getPaterno();
            case 2:
                return pasajeroDto.getMaterno();
            case 3:
                return pasajeroDto.getTipodocumento();
            case 4:
                return pasajeroDto.getNumeroDocumento();
            case 5:
                return pasajeroDto.getIdPais();

            default:
                return null;
        }
    }

}
