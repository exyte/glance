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
package com.xored.glance.ui.gef.controls;

import org.eclipse.draw2d.IFigure;

import com.xored.glance.ui.sources.Match;

public interface IHighlightFigure {

    IFigure getHighlightedFigure();

    Match getMatch();

    void updateBounds();

    void select(boolean sel);
}
