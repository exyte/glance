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
package org.eclipse.ui.glance.internal.viewers;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.graphics.Point;

import org.eclipse.ui.glance.controls.text.styled.TextSelector;
import org.eclipse.ui.glance.sources.BaseTextSource;
import org.eclipse.ui.glance.sources.ITextBlock;
import org.eclipse.ui.glance.sources.ITextSourceListener;
import org.eclipse.ui.glance.sources.Match;
import org.eclipse.ui.glance.sources.SourceSelection;

/**
 * @author Yuri Strot
 * 
 */
public class TextViewerControl extends BaseTextSource implements
		ISelectionChangedListener {

	public TextViewerControl(final TextViewer viewer) {
		this.viewer = viewer;
		listeners = new ListenerList();
		blocks = new ColoredTextViewerBlock[] { new ColoredTextViewerBlock(
				viewer) };
	}

	public void addTextSourceListener(final ITextSourceListener listener) {
		listeners.add(listener);
	}

	public void removeTextSourceListener(final ITextSourceListener listener) {
		listeners.remove(listener);
	}

	public void dispose() {
		if (!disposed) {
			selector.dispose();
			viewer.removeSelectionChangedListener(this);
			getBlock().dispose();
			disposed = true;
		}
	}

	public void selectionChanged(final SelectionChangedEvent event) {
		final ISelection selection = event.getSelection();
		if (selection instanceof TextSelection) {
			final TextSelection tSelection = (TextSelection) selection;
			final SourceSelection sSelection = new SourceSelection(getBlock(),
					tSelection.getOffset(), tSelection.getLength());
			final Object[] objects = listeners.getListeners();
			for (final Object object : objects) {
				final ITextSourceListener listener = (ITextSourceListener) object;
				listener.selectionChanged(sSelection);
			}
		}
	}

	public boolean isDisposed() {
		return disposed;
	}

	public ColoredTextViewerBlock getBlock() {
		return blocks[0];
	}

	public ITextBlock[] getBlocks() {
		return blocks;
	}

	public SourceSelection getSelection() {
		final Point selection = viewer.getSelectedRange();
		return new SourceSelection(getBlock(), selection.x, selection.y);
	}

	public void select(final Match match) {
		getBlock().setSelected(match);
		selector.setMatch(match);
	}

	public void show(final Match[] matches) {
		getBlock().setMatches(matches);
	}

	@Override
	public void init() {
		selector = new ViewerSelector(viewer);
		viewer.addSelectionChangedListener(this);
	}

	private TextSelector selector;
	private final ListenerList listeners;
	private boolean disposed;
	private final ColoredTextViewerBlock[] blocks;
	private final TextViewer viewer;

}
