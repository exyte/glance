/*******************************************************************************
 * Copyright (c) 2017 Exyte
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Igor Zapletnev - initial API and implementation
 ******************************************************************************/
package org.eclipse.ui.glance.gef.descriptors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchPartReference;
import org.eclipse.ui.part.MultiPageEditorPart;

import org.eclipse.ui.glance.gef.sources.GraphicalViewerTextSource;
import org.eclipse.ui.glance.sources.ITextSource;
import org.eclipse.ui.glance.sources.ITextSourceDescriptor;

@SuppressWarnings("restriction")
public class GraphicalViewerDescriptor implements ITextSourceDescriptor {

    protected GraphicalViewer viewer;

    public boolean isValid(final Control control) {
        return getGraphicalViewer(getEditPart(control)) != null;
    }

    public ITextSource createSource(final Control control) {
        return new GraphicalViewerTextSource(viewer);
    }

    protected GraphicalViewer getGraphicalViewer(final IWorkbenchPart editPart) {
        Object editor;
        if (editPart instanceof MultiPageEditorPart) {
            final MultiPageEditorPart multipageEditor = (MultiPageEditorPart) editPart;
            editor = multipageEditor.getSelectedPage();
        } else {
            editor = editPart;
        }
        if (editor instanceof IWorkbenchPart) {
            return viewer = (GraphicalViewer) ((IWorkbenchPart) editor).getAdapter(GraphicalViewer.class);
        }
        return null;
    }

    protected static IWorkbenchPart getEditPart(final Control control) {
        final Map<Control, IWorkbenchPart> partMap = getPartMap();
        Composite parent = control.getParent();
        while (parent != null) {
            if (partMap.get(parent) != null) {
                return getPartMap().get(parent);
            }
            parent = parent.getParent();

        }
        return null;
    }

    private static IEditorReference[] getEditorReference() {
        final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (activeWindow != null) {
            if (activeWindow.getActivePage() != null) {
                return activeWindow.getActivePage().getEditorReferences();
            }
        }
        return new IEditorReference[0];
    }

    private static Map<Control, IWorkbenchPart> getPartMap() {
        final Map<Control, IWorkbenchPart> map = new HashMap<Control, IWorkbenchPart>();
        for (final IEditorReference ref : getEditorReference()) {
            map.put(((WorkbenchPartReference) ref).getPane().getControl(), ref.getPart(false));
        }
        return map;
    }
}
