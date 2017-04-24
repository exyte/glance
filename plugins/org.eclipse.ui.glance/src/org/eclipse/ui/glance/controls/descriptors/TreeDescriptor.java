/**
 * 
 */
package org.eclipse.ui.glance.controls.descriptors;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;

import org.eclipse.ui.glance.controls.tree.TreeControlSource;
import org.eclipse.ui.glance.sources.ITextSource;
import org.eclipse.ui.glance.sources.ITextSourceDescriptor;

/**
 * @author Yuri Strot
 * 
 */
public class TreeDescriptor implements ITextSourceDescriptor {

	public ITextSource createSource(Control control) {
		return new TreeControlSource((Tree) control);
	}

	public boolean isValid(Control control) {
		return control instanceof Tree;
	}

}
