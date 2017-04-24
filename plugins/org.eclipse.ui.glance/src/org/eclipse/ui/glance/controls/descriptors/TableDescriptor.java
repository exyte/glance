/**
 * 
 */
package org.eclipse.ui.glance.controls.descriptors;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;

import org.eclipse.ui.glance.controls.table.TableSource;
import org.eclipse.ui.glance.sources.ITextSource;
import org.eclipse.ui.glance.sources.ITextSourceDescriptor;

/**
 * @author Yuri Strot
 * 
 */
public class TableDescriptor implements ITextSourceDescriptor {

	public ITextSource createSource(Control control) {
		return new TableSource((Table) control);
	}

	public boolean isValid(Control control) {
		return control instanceof Table;
	}

}
