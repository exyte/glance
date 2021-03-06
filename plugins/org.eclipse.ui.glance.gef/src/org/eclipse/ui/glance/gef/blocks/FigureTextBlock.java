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
package org.eclipse.ui.glance.gef.blocks;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;

import org.eclipse.ui.glance.sources.ITextBlock;
import org.eclipse.ui.glance.sources.ITextBlockListener;
import org.eclipse.ui.glance.sources.TextChangedEvent;

public abstract class FigureTextBlock<T extends IFigure> implements ITextBlock, FigureListener {

    private final T figure;

    private final ListenerList listeners;

    public FigureTextBlock(final T fig) {
        listeners = new ListenerList();
        figure = fig;
        figure.addFigureListener(this);
    }

    public void figureMoved(final IFigure source) {
        final Object[] objects = listeners.getListeners();
        final TextChangedEvent textEvent = new TextChangedEvent(0, getText().length(), getText());
        for (final Object object : objects) {
            final ITextBlockListener listener = (ITextBlockListener) object;
            listener.textChanged(textEvent);
        }
    }

    public T getFigure() {
        return figure;
    }

    public void addTextBlockListener(final ITextBlockListener listener) {
        listeners.add(listener);
    }

    public void removeTextBlockListener(final ITextBlockListener listener) {
        listeners.remove(listener);
    }

}
