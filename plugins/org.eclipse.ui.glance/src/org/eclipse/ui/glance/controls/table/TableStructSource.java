/*******************************************************************************
 * Copyright (c) 2017 Exyte
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Yuri Strot - initial API and Implementation
 ******************************************************************************/
package org.eclipse.ui.glance.controls.table;

import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import org.eclipse.ui.glance.controls.decor.StructCell;
import org.eclipse.ui.glance.controls.decor.StructSource;
import org.eclipse.ui.glance.sources.ITextBlock;
import org.eclipse.ui.glance.sources.SourceSelection;

public class TableStructSource extends StructSource {

	public TableStructSource(Table table) {
		super(table);
		table.addSelectionListener(this);
	}

	@Override
	public Table getControl() {
		return (Table) super.getControl();
	}

	@Override
	protected StructCell createCell(Item item, int column) {
		return new TableCell((TableItem) item, column);
	}

	@Override
	public void dispose() {
		super.dispose();
		getControl().removeSelectionListener(this);
	}

	@Override
	protected TableContent createContent() {
		return new TableContent(getControl());
	}

	protected SourceSelection getSourceSelection() {
		TableItem[] items = getControl().getSelection();
		if (items.length > 0) {
			ITextBlock block = content.getContent(createCell(items[0], 0));
			if (block != null) {
				return new SourceSelection(block, 0, block.getText().length());
			}
		}
		return null;
	}

}
