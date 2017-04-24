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
package org.eclipse.ui.glance.gef.controls;

import java.util.List;

import org.eclipse.draw2d.IFigure;

import org.eclipse.ui.glance.sources.ITextBlock;
import org.eclipse.ui.glance.sources.ITextSourceListener;
import org.eclipse.ui.glance.sources.Match;

public interface IFigureDecorator {

    void connect(final IFigure figure);

    void disconnect();

    List<ITextBlock> getTextBlocks();

    void showMatches(Match[] matches);

    void selectMatch(Match match);

    void addTextSourceListener(ITextSourceListener listener);

    void removeTextSourceListener(ITextSourceListener listener);
}
