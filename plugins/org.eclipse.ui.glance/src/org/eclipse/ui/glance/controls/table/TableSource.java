/******************************************************************************* 
 * Copyright (c) 2017 Exyte  
 * 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html  
 * 
 * Contributors: 
 *     Yuri Strot - initial API and Implementation 
 *******************************************************************************/
package org.eclipse.ui.glance.controls.table;

import java.util.List;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import org.eclipse.ui.glance.controls.items.ItemCell;
import org.eclipse.ui.glance.controls.items.ItemProvider;
import org.eclipse.ui.glance.controls.items.ItemSource;
import org.eclipse.ui.glance.sources.SourceSelection;

/**
 * @author Yuri Strot
 * 
 */
public class TableSource extends ItemSource {

	public TableSource(Table table) {
		super(table);
		table.addSelectionListener(this);
	}

	@Override
	public Table getControl() {
		return (Table) super.getControl();
	}

	@Override
	public void dispose() {
		getControl().removeSelectionListener(this);
		super.dispose();
	}

	public SourceSelection getSelection() {
		TableItem[] items = getControl().getSelection();
		if (items.length > 0) {
			List<ItemCell> cells = getCells();
			for (ItemCell cell : cells) {
				if (cell.getItem().equals(items[0])) {
					return new SourceSelection(cell, 0, cell.getText().length());
				}
			}
		}
		return null;
	}

	@Override
	protected void collectCells(List<ItemCell> cells) {
		Table table = getControl();
		TableItem[] items = table.getItems();
		int columns = table.getColumnCount();
		if (columns == 0)
			columns = 1;
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < columns; j++) {
				cells.add(new ItemCell(items[i], j, getItemProvider()));
			}
		}
	}

	@Override
	protected ItemProvider getItemProvider() {
		return TableItemProvider.getInstance();
	}

}
