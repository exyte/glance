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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.ui.glance.sources.ColorManager;
import org.eclipse.ui.glance.sources.Match;

public class HighlightLabel extends HighlightFigure<Label> {

    private static String LINE_SEPARATOR = System.getProperty("line.separator");

    private final int fontHeight;

    public HighlightLabel(final Label label, final Match match) {
        super(label, match);
        fontHeight = delegate.getTextUtilities().getTextExtents("", getFont()).height;
    }

    @Override
    public void paint(final Graphics g) {
        if (!isVisible()) {
            return;
        }
        final String originalText = delegate.getText();
        final String matchString = originalText.substring(match.getOffset(),
            match.getOffset() + match.getLength());

        g.setBackgroundColor(isSelected() ? ColorManager.getInstance().getSelectedBackgroundColor()
            : ColorManager.getInstance().getBackgroundColor());

        final Dimension extent = getTextExtents(matchString);
        final Point topLeft = bounds.getTopLeft();
        g.fillRectangle(topLeft.x, topLeft.y, extent.width, extent.height);

        g.setForegroundColor(ColorConstants.black);
        g.setFont(getFont());
        g.drawText(matchString, topLeft.getCopy());
    }

    public void updateBounds() {
        if (!isVisible()) {
            return;
        }
        final String originalText = delegate.getText();

        final Rectangle bounds = delegate.getTextBounds();
        final Point origin = bounds.getTopLeft();
        final Point caret = origin.getCopy();

        final String suffix = originalText.substring(0, match.getOffset());
        caret.x += widthExtent(suffix);
        caret.y += heightExtent(suffix);

        final Dimension highlightExtent = getTextExtents(originalText.substring(match.getOffset(),
            match.getOffset() + match.getLength()));
        setBounds(new Rectangle(caret.x, caret.y, highlightExtent.width, highlightExtent.height));
    }

    private int widthExtent(final String text) {
        if (text.endsWith(LINE_SEPARATOR)) {
            return 0;
        }
        final String[] lines = text.split(LINE_SEPARATOR);
        return getTextExtents(lines[lines.length - 1]).width;
    }

    private int heightExtent(final String text) {
        return getTextExtents(text).height - fontHeight;
    }
}
